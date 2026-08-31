#include <bits/stdc++.h>
using namespace std;
int n;
int main() {
  int a, b, c;
  cin >> n >> a >> b >> c;
  n *= 2;
  long long ans = 0;
  for (int i = 0; i <= a; i++) {
    for (int j = 0; j <= b; j++) {
      int nn = n - i * 1 - j * 2;
      if (nn < 0) continue;
      if (nn % 4 == 0) {
        if (nn / 4 <= c) ans++;
      }
    }
  }
  cout << ans << endl;
  return 0;
}
