#include <bits/stdc++.h>
using namespace std;
long long MAXN = (long long)1e5 + 10;
vector<long long> x(MAXN);
vector<long long> h(MAXN);
long long n;
int main() {
  cout << setprecision(20);
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> x[i] >> h[i];
  }
  long long ans = 0;
  long long r = (long long)-1e10;
  for (int i = 0; i < n; ++i) {
    if (x[i] - h[i] > r) {
      ++ans;
      r = x[i];
      continue;
    }
    if (i == n - 1 || x[i + 1] > x[i] + h[i]) {
      r = x[i] + h[i];
      ++ans;
      continue;
    }
    r = x[i];
  }
  cout << ans;
  return 0;
}
