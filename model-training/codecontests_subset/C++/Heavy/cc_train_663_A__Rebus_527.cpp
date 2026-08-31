#include <bits/stdc++.h>
using namespace std;
const int M = 1001000;
char s[M];
int lens, n;
int a[M], lena, b[M], lenb;
void init() {
  char ch = getchar();
  s[++lens] = '+';
  lena++;
  while (ch < '0' || ch > '9') {
    if (ch == '-' || ch == '+') {
      s[++lens] = ch;
      if (ch == '+')
        lena++;
      else
        lenb++;
    }
    ch = getchar();
  }
  while (ch <= '9' && ch >= '0') {
    n *= 10;
    n += ch - '0';
    ch = getchar();
  }
}
int main() {
  init();
  int sum = lena * n - lenb;
  for (int i = 1; i <= lena; i++) a[i] = n;
  for (int i = 1; i <= lenb; i++) b[i] = 1;
  if (sum < n) {
    printf("Impossible");
    return 0;
  }
  int j = 1;
  int k = 1;
  for (int i = n + 1; i <= sum; i++) {
    if (j == lena + 1) {
      if (b[k] < n)
        b[k]++;
      else {
        k++;
        b[k]++;
      }
    } else {
      if (a[j] > 1)
        a[j]--;
      else {
        j++;
        if (a[j] > 1)
          a[j]--;
        else
          i--;
      }
    }
  }
  sum = 0;
  for (int i = 1; i <= lena; i++) sum += a[i];
  for (int i = 1; i <= lenb; i++) sum -= b[i];
  if (sum != n) {
    printf("Impossible");
    return 0;
  }
  printf("Possible\n");
  j = 2, k = 1;
  printf("%d ", a[1]);
  for (int i = 2; i <= lens; i++)
    if (s[i] == '+') {
      printf("+ ");
      printf("%d ", a[j]);
      j++;
    } else {
      printf("- ");
      printf("%d ", b[k]);
      k++;
    }
  printf("= %d", n);
  return 0;
}
