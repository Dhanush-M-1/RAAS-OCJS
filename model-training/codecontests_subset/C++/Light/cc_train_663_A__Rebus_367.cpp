#include <bits/stdc++.h>
using namespace std;
char S[2];
int n, m, x, y, z, k, w;
int add, minu;
int A[105], ANS[105];
int main() {
  add = 1;
  A[0] = 1;
  while (1) {
    scanf("%s", S);
    if (S[0] == '?') n++;
    if (S[0] == '-')
      minu++;
    else if (S[0] == '+')
      add++;
    if (S[0] == '-')
      A[++w] = 0;
    else if (S[0] == '+')
      A[++w] = 1;
    if (S[0] == '=') break;
  }
  scanf("%d", &x);
  if (add == 1 && minu >= 1) {
    printf("Impossible\n");
    return 0;
  } else if (add == 1 && minu == 0) {
    printf("Possible\n%d = %d\n", x, x);
    return 0;
  }
  ANS[0] = x;
  for (int i = (1); i <= (w); i++)
    if (A[i] == 0)
      ANS[i] = -1;
    else
      ANS[i] = 1;
  y = 0;
  for (int i = (0); i <= (w); i++) y += ANS[i];
  if (y > x) {
    for (int i = (0); i <= (w); i++) {
      while (ANS[i] > 1 && y > x) {
        ANS[i]--;
        y--;
      }
      while (ANS[i] <= -1 && ANS[i] > -x && y > x) {
        ANS[i]--;
        y--;
      }
    }
  } else {
    for (int i = (0); i <= (w); i++) {
      while (ANS[i] >= 1 && ANS[i] < x && y < x) {
        ANS[i]++;
        y++;
      }
    }
  }
  if (y != x) {
    printf("Impossible\n");
    return 0;
  }
  printf("Possible\n");
  for (int i = (0); i <= (w); i++) {
    printf("%d", abs(ANS[i]));
    if (i == w) break;
    if (A[i + 1] == 0)
      printf(" - ");
    else
      printf(" + ");
  }
  printf(" = %d\n", x);
  return 0;
}
