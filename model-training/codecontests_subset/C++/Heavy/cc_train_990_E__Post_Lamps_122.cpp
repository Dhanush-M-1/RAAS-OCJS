#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
enum { MOD0 = 1000000000, MOD7 = 1000000007, MOD9 = 1000000009 };
template <typename T>
ostream &operator<<(ostream &cout, vector<T> &a) {
  for (size_t i = 0; i < a.size(); ++i) cout << a[i] << " ";
  return cout;
}
template <typename T>
ostream &operator<<(ostream &cout, vector<vector<T> > &a) {
  for (size_t i = 0; i < a.size(); ++i) cout << a[i] << endl;
  return cout;
}
bool bad[1000000];
int a[1000000];
int l[1000000];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int n, k, m;
  cin >> n >> m >> k;
  for (int i = 0; i < m; ++i) {
    int x;
    cin >> x;
    bad[x] = true;
  }
  if (bad[0]) {
    cout << -1 << '\n';
    return 0;
  }
  int cur = 0;
  int mx = 0;
  for (int i = 1; i < n; ++i) {
    if (bad[i]) {
      l[i] = cur;
    } else {
      l[i] = cur = i;
    }
    mx = max(mx, i - cur);
  }
  if (mx >= k) {
    cout << -1 << '\n';
    return 0;
  }
  for (int i = 0; i < k; ++i) {
    cin >> a[i];
  }
  long long ans = LLONG_MAX;
  for (int i = mx; i < k; ++i) {
    int st = 0;
    int cc = 0;
    while (true) {
      ++cc;
      if (st + i + 1 >= n) break;
      st = l[st + i + 1];
    }
    ans = min((long long)cc * a[i], ans);
  }
  cout << ans << '\n';
}
