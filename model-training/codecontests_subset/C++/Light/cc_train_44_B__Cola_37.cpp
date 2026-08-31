#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c;
  cin >> n >> a >> b >> c;
  int ans = 0;
  for (int i = 0; i <= a; i += 2) {
    for (int j = 0; j <= b && n >= i * 0.5 + j; j++) {
      int left = n - i * 0.5 - j;
      if (left % 2 == 0 && left / 2 <= c) ans++;
    }
  }
  cout << ans;
  return 0;
}
