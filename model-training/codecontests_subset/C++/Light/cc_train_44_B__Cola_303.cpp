#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
long long dx[] = {-1, 0, 1, 0};
long long dy[] = {0, -1, 0, 1};
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n, a, b, c;
  cin >> n >> a >> b >> c;
  long long ans = 0;
  for (long long i = 0; i <= a; i += 2) {
    for (long long j = 0; j <= c; j++) {
      long long k = n - i / 2 - 2 * j;
      if (k < 0 || k > b) continue;
      ans++;
    }
  }
  cout << ans << "\n";
}
