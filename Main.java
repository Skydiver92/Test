package com.company;

class Main {

    public static void main(String[] args) {

        String TextString = "What a perfect weatheeear today. ciiiivilian. " +
                "An engeneeer. check. I checked my cooooooooat. It is success! TTTTtte? " +
                "I would like to druuuoonk some coffee and go for a walk. The weather is finnnne! eee";
        System.out.print(TextString + "\n");
        TextString = removeArticles(TextString);
        System.out.print(TextString + "\n");
        TextString = removeC(TextString);
        System.out.print(TextString + "\n");
        TextString = removeDouble(TextString);
        System.out.print(TextString + "\n");
        TextString = removeE(TextString);
        System.out.print(TextString + "\n");
    }


    private static String removeArticles(String text) {

        return text.replaceAll(" A | a | An | an | The | the ", " ");
    }

    private static String removeC(String text) {
        return text.replaceAll("Ci", "Si")
                .replaceAll("ci", "si")
                .replaceAll("Ce", "Se")
                .replaceAll("ce", "se")
                .replaceAll("Ck", "K")
                .replaceAll("ck", "k")
                .replaceAll("C", "K")
                .replaceAll("c", "k");
    }

    private static String removeDouble(String text) {
        boolean isContain = text.contains("Ee") | text.contains("ee") | text.contains("Oo") | text.contains("oo");
        while (isContain) {
            text = text.replaceAll("Ee", "I")
                    .replaceAll("ee", "i")
                    .replaceAll("Oo", "U")
                    .replaceAll("oo", "u");
            isContain = text.contains("Ee|ee|Oo|oo");
        }
        text = text.replaceAll("([a-z])\\1+", "$1")
                    .replaceAll("([A-Z])\\1+", "$1")
                    .replaceAll("([A-Z])([a-z])", "$1");
        return text;
    }

    private static String removeE(String text) {
        char[] chArray1 = text.toCharArray();
        for (int i = 1; i < chArray1.length - 1; i++) {

            if (chArray1[i] == 'e' & chArray1[i - 1] != ' ' & (chArray1[i + 1] == ' '  | chArray1[i + 1] == '!' |
                    chArray1[i + 1] == '.' | chArray1[i + 1] == '?') |  chArray1[i + 1] == ':' | chArray1[i + 1] == '"') {

                chArray1[i] = ' ';
            }
            if (chArray1[chArray1.length-1] == 'e') {chArray1[chArray1.length-1] = ' ';
            }


        }

        return new String(chArray1);
        //return text.replaceAll("(\\we\\s)|(\\we\\W)", " ");
    }
}
