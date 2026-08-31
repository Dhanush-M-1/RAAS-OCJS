#include <bits/stdc++.h>
template <class T>
T gcd(T a, T b) {
  T r;
  while (b != 0) {
    r = a % b;
    a = b;
    b = r;
  }
  return a;
}
template <class T>
T lcm(T a, T b) {
  return a / gcd(a, b) * b;
}
using namespace std;
const long long MOD = 1e18;
long long n, m, k, t, dd[300005], a[300005], ans, cnt;
vector<int> p[300005];
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= m; i++) {
    int u, v;
    cin >> u >> v;
    p[v].push_back(u);
  }
  for (int i = n; i >= 1; i--) {
    if (dd[a[i]] == cnt && i != n) {
      ans++;
      continue;
    }
    for (auto j : p[a[i]]) dd[j]++;
    cnt++;
  }
  cout << ans;
}
