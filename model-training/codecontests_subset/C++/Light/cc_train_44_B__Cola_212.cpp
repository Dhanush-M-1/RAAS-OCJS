#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, ans = 0;
  cin >> n >> a >> b >> c;
  n = n * 2;
  for (int i = 0; i <= c && i <= n / 4; i++)
    for (int j = 0; j <= b && j <= (n - 4 * i) / 2; j++) {
      if (n - i * 4 - j * 2 <= a) ans++;
    }
  cout << ans << endl;
}
