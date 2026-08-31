#include <bits/stdc++.h>
using namespace std;
int l, r, aand, diver, n, sum, jia[105], jian[105], counnt;
char ch[3], fuhao[105];
int main() {
  while (~scanf("%s", ch)) {
    if (ch[0] == '?')
      continue;
    else if (ch[0] == '+') {
      aand++;
      fuhao[counnt++] = '+';
    } else if (ch[0] == '-') {
      diver++;
      fuhao[counnt++] = '-';
    } else
      break;
  }
  sum = aand + 1 - diver;
  for (int i = 0; i <= aand; i++) {
    jia[i] = 1;
  }
  for (int i = 0; i < diver; i++) {
    jian[i] = 1;
  }
  scanf("%d", &n);
  l = aand + 1 - diver * n;
  r = (aand + 1) * n - diver;
  int ant1 = 0, ant2 = 0;
  if (n < l || n > r) {
    printf("Impossible\n");
  } else {
    printf("Possible\n");
    while (sum != n) {
      if (sum < n) {
        while (jia[ant1] < n && sum != n) {
          jia[ant1]++;
          sum++;
        }
        ant1++;
      } else {
        while (jian[ant2] < n && sum != n) {
          jian[ant2]++;
          sum--;
        }
        ant2++;
      }
    }
    int res1 = 0, res2 = 0;
    printf("%d", jia[res1++]);
    for (int i = 0; i < aand + diver; i++) {
      if (fuhao[i] == '+') {
        printf(" + %d", jia[res1++]);
      } else {
        printf(" - %d", jian[res2++]);
      }
    }
    printf(" = %d\n", n);
  }
  return 0;
}
