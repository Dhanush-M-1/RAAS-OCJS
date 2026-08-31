#include <bits/stdc++.h>
using namespace std;
int n, m;
bool mark[123];
int main() {
  scanf("%d%d", &n, &m);
  memset(mark, false, sizeof(mark));
  for (int i = 0; i < n; i++) {
    int x;
    scanf("%d", &x);
    for (int j = 0; j < x; j++) {
      int y;
      scanf("%d", &y);
      mark[y] = true;
    }
  }
  bool ans = true;
  for (int i = 1; i <= m; i++) ans = ans && mark[i];
  if (ans)
    puts("YES");
  else
    puts("NO");
}
