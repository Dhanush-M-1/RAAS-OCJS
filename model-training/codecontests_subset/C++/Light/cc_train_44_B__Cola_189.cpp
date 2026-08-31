#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c;
  int ans = 0;
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= b; i++) {
    for (int j = 0; j <= c; j++) {
      int t = n - i - 2 * j;
      if (t >= 0 && t <= 0.5 * a) ans++;
    }
  }
  cout << ans << endl;
  return 0;
}
