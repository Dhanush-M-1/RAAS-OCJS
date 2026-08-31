#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, x, y;
  int bin[123] = {0};
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &x);
    for (int j = 1; j <= x; j++) {
      scanf("%d", &y);
      bin[y] = 1;
    }
  }
  bool OK = 1;
  for (int i = 1; i <= m; i++)
    if (bin[i] == 0) OK = 0;
  if (OK)
    printf("YES");
  else
    printf("NO");
}
