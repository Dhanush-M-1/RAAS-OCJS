#include <bits/stdc++.h>
char a[1000][100];
char b[1000][100];
int main() {
  int n, a, b, c;
  scanf("%d%d%d%d", &n, &a, &b, &c);
  int rez = 0;
  for (int i = 0; i <= c; i++)
    for (int j = 0; j <= b; j++) {
      if ((n - i * 2 - j) * 2 <= a && n - i * 2 - j >= 0) rez++;
    }
  printf("%d", rez);
}
