#include <bits/stdc++.h>
using namespace std;
const int maxn = 105;
const int INF = 1e9 + 9;
int n;
vector<int> a;
void ReadInput() {
  cin >> n;
  a.resize(n + 2);
  for (int i = 1; i <= n; ++i) cin >> a[i];
  a[0] = 1;
  a[n + 1] = 1e6;
  sort(a.begin(), a.end());
}
void Solve() {
  int l = 1, r = 1e6;
  int ans = INF;
  for (int i = 0; i <= n; ++i) ans = min(ans, max(a[i] - l, r - a[i + 1]));
  cout << ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  ReadInput();
  Solve();
}
