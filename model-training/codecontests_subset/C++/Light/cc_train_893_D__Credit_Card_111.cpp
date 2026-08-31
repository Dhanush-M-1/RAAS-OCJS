#include <bits/stdc++.h>
using namespace std;
void exitall() {
  cout << -1;
  exit(0);
}
int main() {
  ios::sync_with_stdio(false);
  int n;
  long long d;
  cin >> n >> d;
  vector<long long> v(n);
  for (int i = 0; i < n; ++i) {
    cin >> v[i];
  }
  long long mx = 0;
  int ans = 0;
  int lst = -1;
  long long b = 0;
  for (int i = 0; i < n; ++i) {
    if (v[i] == 0) {
      if (lst >= 0) {
        if (b >= 0) continue;
        if (-b <= d - mx) {
          mx -= b;
          b = 0;
        } else {
          ans++;
          b = 0;
          lst = i;
          mx = 0;
        }
      } else {
        if (b < 0) {
          ans++;
          b = 0;
          mx = 0;
          lst = i;
        }
      }
    } else
      mx = max(mx, b = b + v[i]);
    if (b > d) {
      cout << -1;
      return 0;
    }
  }
  cout << ans;
  return 0;
}
