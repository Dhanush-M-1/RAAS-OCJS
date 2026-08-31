#include <bits/stdc++.h>
const long long mod = 1e9 + 7;
const long long N = 5e5 + 5;
using namespace std;
long long MOD(long long a, long long b) {
  if (a < b) a += b;
  a = a % b;
  return ((a + b) % b);
}
long long modpow(long long x, long long n) {
  long long ans = 1;
  while (n) {
    if (n & 1) ans = MOD(ans * x, mod);
    x = MOD(x * x, mod);
    n >>= 1;
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n, m;
  cin >> n >> m;
  vector<int> a(n + 1);
  vector<int> v[n + 1];
  for (int i = 1; i <= n; i++) cin >> a[i];
  while (m--) {
    int x, y;
    cin >> x >> y;
    v[x].push_back(y);
  }
  vector<bool> vis(n + 1);
  vis[a[n]] = true;
  int ans = 0;
  for (int i = n - 1; i >= 1; i--) {
    int cnt = 0;
    for (auto &j : v[a[i]])
      if (vis[j]) cnt++;
    if (cnt + i + ans == n)
      ans++;
    else
      vis[a[i]] = true;
  }
  cout << ans << "\n";
  return 0;
}
