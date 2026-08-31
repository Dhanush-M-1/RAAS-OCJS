#include <bits/stdc++.h>
using namespace std;
void fast(string name = "") {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  if ((int)name.size() > 0) {
    freopen((name + ".in").c_str(), "r", stdin);
    freopen((name + ".out").c_str(), "w", stdout);
  }
}
const int N = 1e5;
int deg[N];
int n;
void solve() {
  cin >> n;
  int a, b;
  fill(deg, deg + n + 1, 0);
  for (int i = 1; i < n; ++i) {
    cin >> a >> b;
    deg[a]++;
    deg[b]++;
  }
  for (int i = 1; i <= n; ++i) {
    if (deg[i] == 2) {
      cout << "NO\n";
      return;
    }
  }
  cout << "YES\n";
}
int main() {
  fast("");
  solve();
  return 0;
}
