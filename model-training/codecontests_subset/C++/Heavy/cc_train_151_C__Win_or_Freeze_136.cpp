#include <bits/stdc++.h>
const long long N = 2e5 + 10, MOD = 1e9 + 7;
using namespace std;
int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};
long long n, t, ans;
long long div(long long n) {
  long long tmp = n, res = 1, cnt = 0;
  for (long long p = 2; p * p <= n; ++p) {
    int e = 0;
    while (tmp % p == 0) {
      ++e;
      tmp /= p;
    }
    if (e && cnt < 2) e > 1 ? res = p * p, cnt = 2 : res *= p, cnt++;
  }
  if (tmp != n && cnt < 2) res *= tmp;
  return res == 1 ? 0 : res;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  long long ans = div(n);
  if (!ans || (div(ans) && ans != n))
    cout << 1 << '\n' << ans;
  else
    cout << 2;
  return 0;
}
