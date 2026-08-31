#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 1010;
;
int n, k, m;
int lst[maxn];
bool ok[maxn];
int a[maxn];
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    int x;
    scanf("%d", &x);
    ok[x] = 1;
  }
  if (ok[0]) {
    puts("-1");
    return 0;
  }
  int tmp = 0;
  for (int i = 1; i <= n; i++) {
    if (!ok[i]) tmp = i;
    lst[i] = tmp;
  }
  long long ans = 1LL * maxn * maxn;
  bool ok = 0;
  for (int i = 1; i <= k; i++) {
    int p;
    scanf("%d", &p);
    int nw = 0, num = 1;
    bool flag = 1;
    while (nw + i < n) {
      num++;
      if (lst[nw + i] <= nw) {
        flag = 0;
        break;
      }
      nw = lst[nw + i];
    }
    if (flag) {
      ok = 1;
      ans = min(ans, 1LL * num * p);
    }
  }
  if (!ok) {
    puts("-1");
    return 0;
  }
  cout << ans << endl;
}
