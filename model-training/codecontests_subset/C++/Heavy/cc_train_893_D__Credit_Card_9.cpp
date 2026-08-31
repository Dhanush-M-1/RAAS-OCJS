#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 10;
long long n, ans, S, tmp, sum, d, X;
long long a[N], MX[N], p[N];
vector<long long> v;
void read_input() {
  cin >> n >> d;
  for (long long i = 1; i <= n; i++) {
    cin >> a[i];
    p[i] = p[i - 1] + a[i];
  }
  MX[n + 1] = -1e9;
  for (long long i = n; i > 0; i--) {
    MX[i] = max(MX[i + 1], p[i]);
  }
}
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  read_input();
  for (long long i = 1; i <= n; i++) {
    sum += a[i];
    if (a[i] == 0 && sum < 0) {
      X = max(d - MX[i] - tmp, -sum);
      ans++;
      tmp += X;
      sum += X;
    }
    if (d < sum) {
      cout << -1;
      return 0;
    }
  }
  cout << ans;
  return 0;
}
