public class Main {

    static String findBalance(String s) {
        char[] message = s.toCharArray();

        if(recurseBalance(message)[0] == 'T') {
            return "Is Balanced";
        } else {
            return "Is NOT Balanced";
        }
    }

    static char[] recurseBalance(char[] message) {

        if(message.length == 0) {
            char[] result = new char[1];
            result[0] = 'T';
            return result;
        } else {
            for(int i = 0, n = message.length; i < n - 1; i++) {

                if((int)message[i] + 1 == (int)message[i + 1] || (int)message[i] + 2 == (int)message[i + 1]) {

                    char[] newMessage = new char[n - 2];

                    for(int j = 0; j < n; j++) {

                        if(j < i) {
                            newMessage[j] = message[j];
                        }
                        else if(j > i + 1) {
                            newMessage[j - 2] = message[j];
                        }
                    }

                    return recurseBalance(newMessage);
                }
            }

            char[] result = new char[1];
            result[0] = 'F';
            return result;
        }
    }

    public static void main (String[] args) {
        System.out.println(findBalance(args[0]));
    }
}
