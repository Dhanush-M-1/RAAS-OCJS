#include <bits/stdc++.h>
using namespace std;
const int MAXN = 30000 + 20, MAXM = 2 * 100000 + 10,
          MOD = 1000 * 1000 * 1000 + 7, INF = 1000 * 1000 * 1000;
int a[MAXN], b[MAXN];
void solve() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i <= 1000; i++) a[i] = 0;
  for (int i = 0, x; i < n; i++) {
    cin >> x;
    a[x]++;
  }
  for (int i = 0; i < m; i++) {
    cin >> b[i];
  }
  for (int i = 0; i < m; i++)
    if (a[b[i]]) {
      cout << "YES" << endl;
      cout << 1 << " " << b[i] << endl;
      return;
    }
  cout << "NO" << endl;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int q;
  cin >> q;
  while (q--) {
    solve();
  }
}
