#include <bits/stdc++.h>
using namespace std;
const int N = 100010;
const int mod = (int)1e9 + 7;
const int MX = 1000010;
long long a[N];
int main() {
  cin.tie(0);
  cin.sync_with_stdio(0);
  long long n, d;
  cin >> n >> d;
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
  }
  int cnt = 0;
  long long mn = 0, mx = 0;
  for (int i = 0; i < n; ++i) {
    if (a[i] == 0) {
      if (mx < 0) {
        mn = 0;
        mx = d;
        cnt++;
      }
      mn = max(mn, 0ll);
    } else {
      mn += a[i];
      mx += a[i];
    }
    mx = min(mx, d);
    if (mn > d || mx < mn) {
      puts("-1");
      return 0;
    }
  }
  cout << cnt << endl;
  return 0;
}
