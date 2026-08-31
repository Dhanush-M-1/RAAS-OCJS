#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, ans = 0;
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= b; i++) {
    for (int j = 0; j <= c; j++) {
      if (2 * (n - i - 2 * j) <= a && n >= i + 2 * j) ans++;
    }
  }
  cout << ans;
  return 0;
}
