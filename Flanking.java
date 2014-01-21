
public class Flanking extends GamePlay {

	//Declaration of the outFlankHori() method which makes the outflank action horizontally 
    public static void outFlankHori(){
       for (int j = intnum + 1; j <= numsize[0]; j++){
          if (move == 0){
             if (board [letternum - 64][j] == " ."){
                break;
             }
             //Checks for horizontal outflanks
             else if (board [letternum - 64][j].equals(" B")){
                for (int i = intnum + 1; i < j; i++){
                   board[letternum - 64][i] = " B";
                   bflankpoints += 1;
                   wflankpoints -= 1;
                   bpoints += 1;
                   wpoints -= 1;
                }
                break;
             }
          }
          if (move == 1){
             if (board [letternum - 64][j].equals(" .")){
                break;
             }
             //Checks for horizontal outflanks
             else if (board [letternum - 64][j].equals( " W")){
                for (int i = intnum + 1; i < j; i++){
                   board[letternum - 64][i] = " W";
                   wflankpoints += 1;
                   bflankpoints -= 1;
                   bpoints -= 1;
                   wpoints += 1;
                }
                break;
             }
          }
       }
       if (intnum != 1){
          for (int j = intnum - 1; j >= 1; j--){
             if (move == 0){
                if (board [letternum - 64][j].equals(" .")){
                   break;
                }
                //Checks for horizontal outflanks
                else if (board [letternum - 64][j].equals(" B")){
                   for (int i = intnum - 1; i > j; i--){
                      board[letternum - 64][i] = " B";
                      bflankpoints += 1;
                      wflankpoints -= 1;
                      bpoints += 1;
                      wpoints -= 1;
                   }
                   break;
                }
             }
             if (move == 1){
                if (board [letternum - 64][j].equals(" .")){
                   break;
                }
                //Checks for horizontal outflanks
                else if (board [letternum - 64][j].equals(" W")){
                   for (int i = intnum - 1; i > j; i--){
                      board[letternum - 64][i] = " W";
                      wflankpoints += 1;
                      bflankpoints -= 1;
                      bpoints -= 1;
                      wpoints += 1;
                   }
                   break;
                }
             }
          }
       }
    }
    
  //Declaration of the outFlankVert() method which makes the outflank action vertically 
    public static void outFlankVert(){
       for (int j = letternum - 64 + 1; j <= numsize[1]; j++){
          if (move == 0){
             if (board [j][intnum].equals(" .")){
                break;
             }
             //Checks for vertical outflanks
             else if (board [j][intnum].equals(" B")){
                for (int i = letternum - 64 + 1; i < j; i++){
                   board[i][intnum] = " B";
                   bflankpoints += 1;
                   wflankpoints -= 1;
                   bpoints += 1;
                   wpoints -= 1;
                }
                break;
             }
          }
          if (move == 1){
             if (board [j][intnum].equals(" .")){
                break;
             }
             //Checks for vertical outflanks
             else if (board [j][intnum].equals(" W")){
                for (int i = letternum - 64 + 1; i < j; i++){
                   board[i][intnum] = " W";
                   bflankpoints -= 1;
                   wflankpoints += 1;
                   bpoints -= 1;
                   wpoints += 1;
                }
                break;
             }
          }
       }
       if (letternum - 64 != 1){
          for (int j = letternum - 64 - 1; j >= 1; j--){
             if (move == 0){
                if (board [j][intnum].equals(" .")){
                   break;
                }
                //Checks for vertical outflanks
                else if (board [j][intnum].equals(" B")){
                   for (int i = letternum - 64 - 1; i > j; i--){
                      board[i][intnum] = " B";
                      bflankpoints += 1;
                      wflankpoints -= 1;
                      bpoints += 1;
                      wpoints -= 1;
                   }
                   break;
                }
             }
             if (move == 1){
                if (board [j][intnum].equals(" .")){
                   break;
                }
                //Checks for vertical outflanks
                else if (board [j][intnum].equals(" W")){
                   for (int i = letternum - 64 - 1; i > j; i--){
                      board[i][intnum] = " W";
                      bflankpoints -= 1;
                      wflankpoints += 1;
                      bpoints -= 1;
                      wpoints += 1;
                   }
                   break;
                }
             }
          }
       }
    }
 
 
 //Declaration of the outFlankDiag() method which makes the outflank action diagonally
    public static void outFlankDiag(){
       int j = letternum - 64 + 1; 
       int a = intnum + 1;
       while ( j <= numsize[1] && a <= numsize[0]){
          if (move == 0){
             if (board [j][a].equals(" .")){
                break;
             } 
             //Checks for diagonally outflanks
             else if (board [j][a].equals(" B")){
                int i = letternum - 64 + 1; 
                int b = intnum + 1;
                while ( i < j && b < a){
                   board[i][b] = " B";
                   bflankpoints += 1;
                   wflankpoints -= 1;
                   bpoints += 1;
                   wpoints -= 1;
                   i++;
                   b++;
                }
                break;
             }
          }
          if (move == 1){
             if (board [j][a].equals(" .")){
                break;
             } 
             //Checks for diagonally outflanks
             else if (board [j][a].equals(" W")){
                int i2 = letternum - 64 + 1;
                int b2 = intnum + 1;
                while (i2 < j && b2 < a){
                   board[i2][b2] = " W";
                   bflankpoints -= 1;
                   wflankpoints += 1;
                   bpoints -= 1;
                   wpoints += 1;
                   i2++; 
                   b2++;
                }
                break;
             }
          }
          a++; 
          j++;
       }
       int j2 = letternum - 64 - 1; 
       int a2 = intnum - 1;
       while ( j2 >= 1 && a2 >= 1){
          if (move == 0){
             if (board [j2][a2].equals(" .")){
                break;
             } 
             //Checks for diagonally outflanks
             else if (board [j2][a2].equals(" B")){
                int i3 = letternum - 64 - 1;
                int b3 = intnum - 1;
                while ( i3 > j2 && b3 > a2){
                   board[i3][b3] = " B";
                   bflankpoints += 1;
                   wflankpoints -= 1;
                   bpoints += 1;
                   wpoints -= 1;
                   i3--;
                   b3--;
                }
                break;
             }
          }
          if (move == 1){
             if (board [j2][a2].equals(" .")){
                break;
             } 
             //Checks for diagonally outflanks
             else if (board [j2][a2].equals(" W")){
                int i4 = letternum - 64 - 1;
                int b4 = intnum - 1;
                while( i4 > j2 && b4 > a2){
                   board[i4][b4] = " W";
                   bflankpoints -= 1;
                   wflankpoints += 1;
                   bpoints -= 1;
                   wpoints += 1;
                   i4--;
                   b4--;
                }
                break;
             }
          }
          j2--;
          a2--;
       }
       int j3 = letternum - 64 + 1;
       int a3 = intnum - 1;
       while ( j3 <= numsize[1] && a3 >= 1){
          if (move == 0){
             if (board [j3][a3].equals(" .")){
                break;
             } 
             //Checks for diagonally outflanks
             else if (board [j3][a3].equals(" B")){
                int i5 = letternum - 64 + 1;
                int b5 = intnum - 1;
                while (i5 < j3 && b5 > a3){
                   board[i5][b5] = " B";
                   bflankpoints += 1;
                   wflankpoints -= 1;
                   bpoints += 1;
                   wpoints -= 1;
                   i5++;
                   b5--;
                }
                break;
             }
          }
          if (move == 1){
             if (board [j3][a3].equals(" .")){
                break;
             } 
             //Checks for diagonally outflanks
             else if (board [j3][a3].equals(" W")){
                int i6 = letternum - 64 + 1;
                int b6 = intnum - 1;
                while ( i6 < j3 && b6 > a3){
                   board[i6][b6] = " W";
                   bflankpoints -= 1;
                   wflankpoints += 1;
                   bpoints -= 1;
                   wpoints += 1;
                   i6++;
                   b6--;
                }
                break;
             }
          }
          a3--; 
          j3++;
       }
       int j4 = letternum - 64 - 1;
       int a4 = intnum + 1;
       while (a4 <= numsize[0] && j4 >= 1){
          if (move == 0){
             if (board [j4][a4].equals(" .")){
                break;
             } 
             //Checks for diagonally outflanks
             else if (board [j4][a4].equals(" B")){
                int i7 = letternum - 64 - 1;
                int b7 = intnum + 1;
                while ( i7 > j4 && b7 < a4){
                   board[i7][b7] = " B";
                   bflankpoints += 1;
                   wflankpoints -= 1;
                   bpoints += 1;
                   wpoints -= 1;
                   i7--;
                   b7++;
                }
                break;
             }
          }
          if (move == 1){
             if (board [j4][a4].equals(" .")){
                break;
             } 
             //Checks for diagonally outflanks
             else if (board [j4][a4].equals(" W")){
                int i8 = letternum - 64 - 1;
                int b8 = intnum + 1;
                while (i8 > j4 && b8 < a4){
                   board[i8][b8] = " W";
                   bflankpoints -= 1;
                   wflankpoints += 1;
                   bpoints -= 1;
                   wpoints += 1;
                   i8--;
                   b8++;
                }
                break;
             }
          }
          j4--;
          a4++;
       }
    }
}
