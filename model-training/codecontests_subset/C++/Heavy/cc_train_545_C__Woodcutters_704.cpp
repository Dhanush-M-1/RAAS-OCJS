#include <bits/stdc++.h>
using namespace std;
long long powermod(long long a, long long b) {
  if (b == 0) return 1;
  long long x = powermod(a, b / 2);
  x = x * x;
  if (b & 1) x = x * a;
  return x;
}
void solve() {
  long long i, j, k, n, m;
  cin >> n;
  vector<long long> x(n), h(n);
  for (i = (0); i < (n); i++) cin >> x[i] >> h[i];
  long long curr = -1e10;
  long long ans = 0;
  for (i = (0); i < (n); i++) {
    if (curr <= x[i] - h[i]) {
      ans++;
      curr = x[i] + 1;
      continue;
    }
    curr = x[i] + 1;
    if (i == n - 1 || x[i] + h[i] < x[i + 1]) {
      ans++;
      curr = x[i] + h[i] + 1;
    }
  }
  cout << ans << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  long long t = 1;
  while (t--) solve();
  return 0;
}
