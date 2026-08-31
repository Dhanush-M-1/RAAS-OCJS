#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int n, a, b, c, ans = 0;
  cin >> n >> a >> b >> c;
  n *= 2;
  for (int b0 = (0); b0 <= (b); ++b0)
    for (int c0 = (0); c0 <= (c); ++c0) {
      int s = n - 2 * b0 - 4 * c0;
      if (0 <= s && s <= a) ans++;
    }
  cout << ans << endl;
}
