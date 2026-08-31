#include <bits/stdc++.h>
inline int min(int x, int y) { return x < y ? x : y; }
inline int getch() {
  int ch = getchar();
  while (!isdigit(ch)) ch = getchar();
  return ch;
}
int n;
int main() {
  scanf("%d", &n);
  int NOE = 0;
  for (register int i = 1; i <= n; ++i) {
    int ch = getch();
    if (ch == '8') ++NOE;
  }
  printf("%d\n", min(NOE, n / 11));
  return 0;
}
