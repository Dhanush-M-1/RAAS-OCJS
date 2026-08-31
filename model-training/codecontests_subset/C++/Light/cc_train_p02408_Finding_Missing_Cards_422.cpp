#include <cstdio>
int main(){
  int n, num, i, j, vec[4][13];
  char card;
  scanf("%d%*c", &n);
  for (i=0; i<n; i++) {
    scanf("%c %d%*c", &card, &num);
    if (card=='S') vec[0][num-1]=num;
    else if (card=='H') vec[1][num-1]=num;
    else if (card=='C') vec[2][num-1]=num;
    else vec[3][num-1]=num;
  }

  for (i=0; i<4; i++) {
    if (i==0) card='S';
    else if (i==1) card='H';
    else if (i==2) card='C';
    else card='D';
    for (j=0; j<13; j++) {
      if (vec[i][j]!=j+1) {
        printf("%c %d\n", card, j+1);
      }
    }
  }
}
