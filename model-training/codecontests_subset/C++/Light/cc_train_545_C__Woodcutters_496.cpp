#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  long long x[n];
  long long h[n];
  for (int i = 0; i < n; i++) {
    cin >> x[i];
    cin >> h[i];
  }
  long long prev = -INT_MAX;
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    if (x[i] - h[i] > prev) {
      ans++;
      prev = x[i];
    } else if (x[i] + h[i] < x[i + 1]) {
      ans++;
      prev = x[i] + h[i];
    } else {
      prev = x[i];
    }
  }
  cout << ans;
  return 0;
}
