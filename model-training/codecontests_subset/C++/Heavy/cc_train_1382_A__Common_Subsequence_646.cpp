#include <bits/stdc++.h>
using namespace std;
const int N = 1e3;
int t, n, m;
int a[N + 2], b[N + 2];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> t;
  while (t--) {
    cin >> n >> m;
    memset(a, 0, sizeof(a));
    memset(b, 0, sizeof(b));
    for (int i = 0; i < n; i++) {
      int x;
      cin >> x;
      a[x]++;
    }
    for (int i = 0; i < m; i++) {
      int x;
      cin >> x;
      b[x]++;
    }
    int cnt = 0;
    int ans = -1;
    for (int i = 0; i <= N; i++) {
      if (a[i] > 0 && b[i] > 0) {
        ans = i;
        break;
      }
    }
    if (ans == -1)
      cout << "NO\n";
    else
      cout << "YES\n1 " << ans << '\n';
  }
  return 0;
}
