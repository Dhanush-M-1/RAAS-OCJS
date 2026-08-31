#include <bits/stdc++.h>
using namespace std;
const double PI = 3.1415926535897932;
const int mod = 1e9 + 7;
int max(int a, int b) {
  if (a > b) return a;
  return b;
}
const int N = 5007, INF = 1000 * 1000 * 1000;
int add[N], mx[N], cur[N];
int t[N], l[N], r[N], m[N];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  for (int i = 0; i < N; ++i) mx[i] = INF;
  int n, q;
  cin >> n >> q;
  for (int i = 0; i < q; ++i) {
    cin >> t[i];
    cin >> l[i] >> r[i] >> m[i];
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; ++j) add[j] += m[i];
    } else {
      for (int j = l[i]; j <= r[i]; ++j) mx[j] = min(mx[j], m[i] - add[j]);
    }
  }
  for (int i = 1; i <= n; ++i) cur[i] = mx[i];
  for (int i = 0; i < q; ++i) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; ++j) cur[j] += m[i];
    } else {
      int t = 0;
      for (int j = l[i]; j <= r[i]; ++j) t = max(t, cur[j]);
      if (t < m[i]) {
        cout << "NO\n";
        exit(0);
      }
    }
  }
  cout << "YES\n";
  for (int i = 1; i <= n; ++i) cout << mx[i] << ' ';
  cout << endl;
}
