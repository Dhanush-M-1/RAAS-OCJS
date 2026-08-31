#include <bits/stdc++.h>
using namespace std;
int n, m, i, j, k, x, y, t;
int a[300055];
char ch;
int main() {
  scanf("%d", &n);
  ch = getchar();
  while (ch < 'a' || ch > 'z') ch = getchar();
  while (ch >= 'a' && ch <= 'z') a[++i] = ch - 'a', ch = getchar();
  for (i = 1; i <= n - 1; i++)
    if (a[i] > a[i + 1]) {
      printf("YES\n%d %d", i, i + 1);
      return 0;
    }
  printf("NO");
  return 0;
}
