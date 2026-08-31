#include <bits/stdc++.h>
using namespace std;
int a[1000], b[1000];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    memset(a, 0, sizeof a);
    memset(b, 0, sizeof b);
    int n, m, flag = 0;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) cin >> a[i];
    for (int i = 1; i <= m; i++) cin >> b[i];
    sort(b + 1, b + 1 + m);
    for (int i = 1; i <= n; i++)
      if (b[lower_bound(b + 1, b + 1 + m, a[i]) - b] == a[i]) {
        flag = i;
        break;
      }
    if (flag)
      cout << "YES\n1 " << a[flag] << endl;
    else
      cout << "NO" << endl;
  }
  return 0;
}
