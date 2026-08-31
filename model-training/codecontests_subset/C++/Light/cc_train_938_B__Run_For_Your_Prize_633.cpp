#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1e9 + 7;
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};
string ds = "RLDU";
long long int abm(long long int a, long long int b, long long int m) {
  long long int ans = 1;
  a = a % m;
  while (b > 0) {
    if (b & 1) ans = (ans * a) % m;
    a = (a * a) % m;
    b = b / 2;
  }
  return ans % m;
}
long long int ncr(long long int n, long long int r, long long int m) {
  if (r == 0) return 1;
  long long int fac[n + 5];
  fac[0] = 1;
  for (long long int i = 1; i < n + 1; i++) {
    fac[i] = fac[i - 1] * i % m;
  }
  return (((fac[n] * abm(fac[r], m - 2, m)) % m) *
          (abm(fac[n - r], m - 2, m))) %
         m;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int n;
  cin >> n;
  long long int a[n];
  for (long long int i = 0; i < n; i++) cin >> a[i];
  long long int ans = 1e9;
  for (long long int i = 0; i < n + 1; i++) {
    long long int cur = 0;
    if (i != 0) {
      cur = max(cur, a[i - 1] - 1);
    }
    if (i != n) {
      cur = max(cur, 1000000 - a[i]);
    }
    ans = min(ans, cur);
  }
  cout << ans << "\n";
  return 0;
}
