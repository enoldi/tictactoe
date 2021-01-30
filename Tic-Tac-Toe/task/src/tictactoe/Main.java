package tictactoe;

import java.util.Scanner;

public class Main {
    static String stringPion = "         ";
    public static void main(String[] args) {
        // write your code here
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream

        String pionX = "X";
        String pionO = "O";

        int count = 0;

        String result = extracted ( stringPion , null , sc , " ");

        while (result.equals ( "Game not finished" )) {

            System.out.print("Enter the coordinates: ");
            String move = sc.nextLine();
            String resultMove;

            if ( count%2 == 0 ) resultMove = extracted ( stringPion , move , sc , pionX );
            else resultMove = extracted ( stringPion , move , sc , pionO );

            if (resultMove.equals ( "Game not finished" ))
                count++;

            result = resultMove;

        }

        switch (result) {
            case "Impossible":
                System.out.println("Impossible");
                break;
            case "Draw":
                System.out.println("Draw");
                break;
            case "O wins":
                System.out.println("O wins");
                break;
            case "X wins":
                System.out.println("X wins");
                break;
            default:
                System.out.println("The game should be finished!");
        }
    }

    /**
     *
     * @param str
     * @param move
     * @param sc
     * @param pion
     * @return
     */
    private static String extracted(String str, String move, Scanner sc , String pion) {
        
        String result = "";
        
        String positionUne = Character.valueOf(str.charAt(0)).toString();
        String positionDeux = Character.valueOf(str.charAt(1)).toString();
        String positionTrois = Character.valueOf(str.charAt(2)).toString();
        String positionQuatre = Character.valueOf(str.charAt(3)).toString();
        String positionCinq = Character.valueOf(str.charAt(4)).toString();
        String positionSix = Character.valueOf(str.charAt(5)).toString();
        String positionSept = Character.valueOf(str.charAt(6)).toString();
        String positionHuit = Character.valueOf(str.charAt(7)).toString();
        String positionNeuf = Character.valueOf(str.charAt(8)).toString();

        if ( move != null ) {
            if ( move.matches ( "^[0-9\\s]*$" ) ) {
                int i = Integer.parseInt ( Character.valueOf ( move.charAt ( 0 ) ).toString ( ) );
                int j = Integer.parseInt ( Character.valueOf ( move.charAt ( 2 ) ).toString ( ) );

                if ( 0 < i && i < 4 && 0 < j && j < 4 ) {
                    if ( i == 1 && j == 1 ) {
                        result =  checkAndUpdatePosition ( 1 , positionUne , str , sc , positionUne , positionDeux , positionTrois , positionQuatre , positionCinq , positionSix , positionSept , positionHuit , positionNeuf ,  pion );
                    } else if ( i == 1 && j == 2 ) {
                        result =  checkAndUpdatePosition ( 2 , positionDeux , str , sc , positionUne , positionDeux , positionTrois , positionQuatre , positionCinq , positionSix , positionSept , positionHuit , positionNeuf ,  pion );
                    } else if ( i == 1 && j == 3 ) {
                        result =  checkAndUpdatePosition ( 3 , positionTrois , str , sc , positionUne , positionDeux , positionTrois , positionQuatre , positionCinq , positionSix , positionSept , positionHuit , positionNeuf ,  pion );
                    } else if ( i == 2 && j == 1 ) {
                        result =  checkAndUpdatePosition ( 4 , positionQuatre , str , sc , positionUne , positionDeux , positionTrois , positionQuatre , positionCinq , positionSix , positionSept , positionHuit , positionNeuf ,  pion );
                    } else if ( i == 2 && j == 2 ) {
                        result =  checkAndUpdatePosition ( 5 , positionCinq , str , sc , positionUne , positionDeux , positionTrois , positionQuatre , positionCinq , positionSix , positionSept , positionHuit , positionNeuf ,  pion );
                    } else if ( i == 2 && j == 3 ) {
                        result =  checkAndUpdatePosition ( 6 , positionSix , str , sc , positionUne , positionDeux , positionTrois , positionQuatre , positionCinq , positionSix , positionSept , positionHuit , positionNeuf ,  pion );
                    } else if ( i == 3 && j == 1 ) {
                        result =  checkAndUpdatePosition ( 7 , positionSept , str , sc , positionUne , positionDeux , positionTrois , positionQuatre , positionCinq , positionSix , positionSept , positionHuit , positionNeuf ,  pion );
                    } else if ( i == 3 && j == 2 ) {
                        result =  checkAndUpdatePosition ( 8 , positionHuit , str , sc , positionUne , positionDeux , positionTrois , positionQuatre , positionCinq , positionSix , positionSept , positionHuit , positionNeuf ,  pion );
                    } else if ( i == 3 && j == 3 ) {
                        result =  checkAndUpdatePosition ( 9 , positionNeuf , str , sc , positionUne , positionDeux , positionTrois , positionQuatre , positionCinq , positionSix , positionSept , positionHuit , positionNeuf ,  pion );
                    }
                } else result =  enterBadCoordinates ( str , sc , pion );
            } else result =  enterStringCoordinates ( str , sc , pion );
        } else {
            stringPion = writeGrid(positionUne, positionDeux, positionTrois, positionQuatre, positionCinq, positionSix, positionSept, positionHuit, positionNeuf);
            result = "Game not finished";
        }
        
        return  result;
    }

    /**
     *
     * @param positionInt
     * @param position
     * @param str
     * @param sc
     * @param positionUne
     * @param positionDeux
     * @param positionTrois
     * @param positionQuatre
     * @param positionCinq
     * @param positionSix
     * @param positionSept
     * @param positionHuit
     * @param positionNeuf
     */
    private static String checkAndUpdatePosition(int positionInt ,String position , String str , Scanner sc , String positionUne , 
                                                 String positionDeux , String positionTrois , String positionQuatre , String positionCinq ,
                                                 String positionSix , String positionSept , String positionHuit , String positionNeuf ,
                                                 String pion) {
        if ( position.equals ( "_" ) || position.equals ( " " ) ) {
            if (positionInt == 1)
                positionUne = pion;
            else if (positionInt == 2)
                positionDeux = pion;
            else if (positionInt == 3)
                positionTrois = pion;
            else if (positionInt == 4)
                positionQuatre = pion;
            else if (positionInt == 5)
                positionCinq = pion;
            else if (positionInt == 6)
                positionSix = pion;
            else if (positionInt == 7)
                positionSept = pion;
            else if (positionInt == 8)
                positionHuit = pion;
            else if (positionInt == 9)
                positionNeuf = pion;

            stringPion = writeGrid( positionUne , positionDeux , positionTrois , positionQuatre , positionCinq , positionSix , positionSept , positionHuit , positionNeuf );
            return conditionToWin( positionUne , positionDeux , positionTrois , positionQuatre , positionCinq , positionSix , positionSept , positionHuit , positionNeuf , stringPion );
        } else {
            return enterCoordinates ( str , sc , pion);
        }
    }

    private static String writeGrid(String positionUne, String positionDeux, String positionTrois, String positionQuatre, String positionCinq, String positionSix, String positionSept, String positionHuit, String positionNeuf) {
        System.out.print("\n");
        System.out.println("---------");
        positionFieldsTowrite ( positionUne , positionDeux , positionTrois );
        positionFieldsTowrite ( positionQuatre , positionCinq , positionSix );
        positionFieldsTowrite ( positionSept , positionHuit , positionNeuf );
        System.out.println("---------");

        return positionUne + positionDeux + positionTrois + positionQuatre + positionCinq + positionSix + positionSept + positionHuit  + positionNeuf;
    }

    private static void positionFieldsTowrite(String positionUne , String positionDeux , String positionTrois) {
        System.out.print("|");
        System.out.print(" ");
        System.out.print(positionUne);
        System.out.print(" ");
        System.out.print(positionDeux);
        System.out.print(" ");
        System.out.print(positionTrois);
        System.out.print(" ");
        System.out.print("|");
        System.out.print("\n");
    }

    /**
     *
     * @param positionUne
     * @param positionDeux
     * @param positionTrois
     * @param positionQuatre
     * @param positionCinq
     * @param positionSix
     * @param positionSept
     * @param positionHuit
     * @param positionNeuf
     * @param str 
     */
    private static String conditionToWin( String positionUne , String positionDeux , String positionTrois , String positionQuatre ,
                                        String positionCinq , String positionSix , String positionSept , String positionHuit ,
                                        String positionNeuf , String str ) {

        String premierLigne = positionUne + "" + positionDeux + "" + positionTrois;
        String deuxiemeLigne = positionQuatre + "" + positionCinq + "" + positionSix;
        String troisiemeLigne = positionSept + "" + positionHuit + "" + positionNeuf;

        String premierColonne = positionUne + "" + positionQuatre + "" + positionSept;
        String deuxiemeColonne = positionDeux + "" + positionCinq + "" + positionHuit;
        String troisiemeColonne = positionTrois + "" + positionSix + "" + positionNeuf;

        String premiereDiagonale = positionUne + "" + positionCinq + "" + positionNeuf;
        String deuxiemeDiagonale = positionTrois + "" + positionCinq + "" + positionSept;

        String oWin = "OOO";
        String xWin = "XXX";
        int somX = 0;
        int somO = 0;

        for ( int i = 0 ; i < str.length ( ) ; i++ ) {
            if ( Character.valueOf ( str.charAt ( i ) ).compareTo ( Character.valueOf ( 'X' ) ) == 0 ) {
                ++somX;
            } else if ( Character.valueOf ( str.charAt ( i ) ).compareTo ( Character.valueOf ( 'O' ) ) == 0 ) {
                ++somO;
            }
        }

        boolean b = ( positionUne.compareTo ( "X" ) == 0 ) || ( positionUne.compareTo ( "O" ) == 0 );
        final boolean b1 = ( positionTrois.compareTo ( "X" ) == 0 ) || ( positionTrois.compareTo ( "O" ) == 0 );

        if ( ( Math.abs ( ( somO - somX ) ) >= 2 ) || ( ( premierLigne.equals ( oWin ) ) && ( deuxiemeLigne.contains ( xWin ) ) || ( premierLigne.equals ( oWin ) ) && ( troisiemeLigne.equals ( xWin ) ) ) ||
                ( ( premierLigne.equals ( xWin ) ) && ( deuxiemeLigne.equals ( oWin ) ) || ( premierLigne.equals ( xWin ) ) && ( troisiemeLigne.equals ( oWin ) ) ) ||
                ( ( premierColonne.equals ( oWin ) ) && ( deuxiemeColonne.equals ( xWin ) ) || ( premierColonne.equals ( oWin ) ) && ( troisiemeColonne.equals ( xWin ) ) ) ||
                ( ( premierColonne.equals ( xWin ) ) && ( deuxiemeColonne.equals ( oWin ) ) || ( premierColonne.equals ( xWin ) ) && ( troisiemeColonne.equals ( oWin ) ) ) )
            return  ( "Impossible" );
        else if ( ( premierLigne.contains ( "X" ) ) && ( premierLigne.contains ( "O" ) ) && ( deuxiemeLigne.contains ( "O" ) ) && ( deuxiemeLigne.contains ( "X" ) )
                && ( troisiemeLigne.contains ( "X" ) ) && ( troisiemeLigne.contains ( "O" ) ) && ( premierColonne.contains ( "O" ) ) && ( premierColonne.contains ( "X" ) )
                && ( deuxiemeColonne.contains ( "O" ) ) && ( deuxiemeColonne.contains ( "X" ) ) && ( troisiemeColonne.contains ( "O" ) ) && ( troisiemeColonne.contains ( "X" ) )
                && ( premiereDiagonale.contains ( "O" ) ) && ( premiereDiagonale.contains ( "X" ) ) && ( deuxiemeDiagonale.contains ( "O" ) ) && ( deuxiemeDiagonale.contains ( "X" ) ) )
            return  ( "Draw" );
        else if ( positionUne.equals ( positionDeux ) && positionDeux.equals ( positionTrois ) && b )
            return  ( positionUne + " wins" );
        else if ( positionQuatre.equalsIgnoreCase ( positionCinq ) && positionCinq.equals ( positionSix ) && ( ( positionQuatre.compareTo ( "X" ) == 0 ) || ( positionQuatre.compareTo ( "O" ) == 0 ) ) )
            return  ( positionQuatre + " wins" );
        else if ( positionSept.equals ( positionHuit ) && positionHuit.equals ( positionNeuf ) && ( ( positionHuit.compareTo ( "X" ) == 0 ) || ( positionHuit.compareTo ( "O" ) == 0 ) ) )
            return  ( positionSept + " wins" );
        else if ( positionUne.equals ( positionQuatre ) && positionQuatre.equals ( positionSept ) && b )
            return  ( positionUne + " wins" );
        else if ( positionDeux.equals ( positionCinq ) && positionCinq.equals ( positionHuit ) && ( ( positionDeux.compareTo ( "X" ) == 0 ) || ( positionDeux.compareTo ( "O" ) == 0 ) ) )
            return  ( positionDeux + " wins" );
        else if ( positionTrois.equals ( positionSix ) && positionSix.equals ( positionNeuf ) && b1 )
            return  ( positionTrois + " wins" );
        else if ( positionUne.equals ( positionCinq ) && positionCinq.equals ( positionNeuf ) && b )
            return  ( positionUne + " wins" );
        else if ( positionTrois.equals ( positionCinq ) && positionCinq.equals ( positionSept ) && b1 )
            return  ( positionTrois + " wins" );
        else return  ( "Game not finished" );
    }

    /**
     *
     * @param str
     * @param sc
     */
    private static String enterCoordinates(String str, Scanner sc , String pion) {
        System.out.println("This cell is occupied! Choose another one! ");

        System.out.println(str);

        System.out.print("Enter the coordinates: ");
        String mv = sc.nextLine();
        return extracted(str, mv, sc, pion);
    }

    /**
     *
     * @param str
     * @param sc
     */
    private static String enterStringCoordinates(String str, Scanner sc, String pion) {
        System.out.println("You should enter numbers! ");

        System.out.println(str);

        System.out.print("Enter the coordinates: ");
        String mv = sc.nextLine();
        return extracted(str, mv, sc ,pion);
    }

    /**
     *
     * @param str
     * @param sc
     */
    private static String enterBadCoordinates(String str , Scanner sc , String pion) {
        System.out.println("Coordinates should be from 1 to 3! ");

        System.out.println(str);

        System.out.print("Enter the coordinates: ");
        String mv = sc.nextLine();
        return extracted(str, mv, sc, pion);
    }
}
