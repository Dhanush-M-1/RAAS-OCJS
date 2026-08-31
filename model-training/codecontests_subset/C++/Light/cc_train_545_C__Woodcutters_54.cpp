#include <bits/stdc++.h>
using namespace std;
const int mod = 1000000007;
int main() {
  long long n;
  cin >> n;
  long long x[n], h[n];
  for (long long i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  long long ans = 0;
  long long xl = -9999999999;
  for (long long i = 0; i < n - 1; i++) {
    if (x[i] - h[i] > xl) {
      xl = x[i];
      ans++;
    } else if (x[i] + h[i] < x[i + 1]) {
      xl = x[i] + h[i];
      ans++;
    }
    if (xl < x[i]) xl = x[i];
  }
  cout << ans + 1;
}
