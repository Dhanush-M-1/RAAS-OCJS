#include <bits/stdc++.h>
using namespace std;
const int N = 2 * 10e4 + 5;
int main() {
  int n, a, b, c;
  cin >> n >> a >> b >> c;
  n *= 2;
  if (a + 2 * b + 4 * c < n) {
    cout << "0";
    return 0;
  }
  int ans = 0;
  for (int i = 0; i <= a; i += 2) {
    for (int j = 0; j <= b; j++) {
      int r = n - i - 2 * j;
      if (r % 4 == 0 && r <= 4 * c && r >= 0) ans++;
    }
  }
  cout << ans;
  return 0;
}
