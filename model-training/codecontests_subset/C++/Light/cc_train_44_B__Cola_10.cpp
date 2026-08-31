#include <bits/stdc++.h>
using namespace std;
int n, a, b, c, ans;
int main() {
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= c; i++) {
    for (int j = 0; j <= b; j++) {
      int x = n - i * 2 - j;
      if (x >= 0 && a * 0.5 >= x) ans++;
    }
  }
  cout << ans;
  return 0;
}
