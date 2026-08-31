#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  vector<long long> x(n), h(n);
  for (long long i = 0; i < n; i++) cin >> x[i] >> h[i];
  long long l = -1e9 - 10;
  long long ans = 0;
  for (long long i = 0; i < n; i++) {
    if (x[i] - h[i] > l) {
      ans++;
      l = x[i];
    } else if (i == n - 1 || x[i] + h[i] < x[i + 1]) {
      ans++;
      l = x[i] + h[i];
    } else
      l = x[i];
  }
  cout << ans;
}
