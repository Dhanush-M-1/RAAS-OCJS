#include <bits/stdc++.h>
using namespace std;
long long n;
long long ans;
long long x[100010];
long long h[100010];
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> x[i] >> h[i];
  }
  if (n != 1) ans++;
  ans++;
  for (int i = 2; i < n; i++) {
    if (x[i] - h[i] > x[i - 1])
      ans++;
    else {
      if (x[i] + h[i] < x[i + 1]) {
        x[i] = x[i] + h[i];
        ans++;
      }
    }
  }
  cout << ans;
  return 0;
}
