#include <bits/stdc++.h>
using namespace std;
int n, d;
int main() {
  cin >> n >> d;
  int a = 0, b = 0, ans = 0, x;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    if (x == 0) {
      if (a < 0) a = 0;
      if (b < 0) b = d, ans++;
    } else {
      a += x, b += x;
      if (a > d) return cout << -1 << endl, 0;
      if (b > d) b = d;
    }
  }
  cout << ans << endl;
}
