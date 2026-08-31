#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, n2, n3;
  while (cin >> n) {
    cin >> a >> b >> c;
    n = n * 2;
    int ans = 0;
    for (int i = c; i >= 0; i--) {
      if (4 * i > n) continue;
      n2 = n - 4 * i;
      for (int j = b; j >= 0; j--) {
        if (2 * j > n2) continue;
        n3 = n2 - 2 * j;
        if (n3 >= 0 && n3 <= a) ans++;
      }
    }
    cout << ans << endl;
  }
  return 0;
}
