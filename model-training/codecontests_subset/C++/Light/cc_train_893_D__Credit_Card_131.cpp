#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int n, d;
  cin >> n >> d;
  int a[n], b[n], mx[n];
  int temp = 0;
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
    temp += a[i];
    b[i] = temp;
  }
  mx[n - 1] = b[n - 1];
  for (int i = n - 2; i >= 0; --i) {
    mx[i] = max(mx[i + 1], b[i]);
  }
  int ans = 0;
  temp = 0;
  for (int i = 0; i < n; ++i) {
    if (b[i] + temp > d) {
      cout << -1 << '\n';
      ;
      return 0;
    }
    if (a[i] == 0) {
      if (b[i] + temp < 0) {
        int curr = 0 - b[i] - temp;
        if (curr > d - (mx[i] + temp)) {
          cout << -1 << '\n';
          ;
          return 0;
        }
        curr = d - mx[i] - temp;
        temp += curr;
        ans++;
      }
    }
  }
  cout << ans << '\n';
  ;
  return 0;
}
