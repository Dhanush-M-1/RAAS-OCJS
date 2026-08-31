#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, ans = 0;
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= a; ++i) {
    if (i / 2 > n) break;
    for (int j = 0; j <= b; ++j) {
      if (j > n - i / 2) break;
      if (i % 2 == 0 && (n - i / 2 - j) % 2 == 0 && (n - i / 2 - j) / 2 <= c)
        ++ans;
    }
  }
  cout << ans;
  return 0;
}
