#include <bits/stdc++.h>
using namespace std;
int T, n, m, a[1005], b[1005], book[1005];
int main() {
  cin >> T;
  while (T--) {
    memset(book, 0, sizeof(book));
    cin >> n >> m;
    for (register int i = 1; i <= n; i++) cin >> a[i], book[a[i]] = 1;
    ;
    for (register int i = 1; i <= m; i++) cin >> b[i];
    int flag = 0;
    for (register int i = 1; i <= m; i++) {
      if (book[b[i]]) {
        flag = 1;
        puts("YES");
        printf("1 %d\n", b[i]);
        break;
      }
    }
    if (!flag) puts("NO");
  }
  return 0;
}
