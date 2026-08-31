#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int ans = 0, rem = 0;
  while (a > 0) {
    ans += a;
    rem += a;
    a = rem / b;
    rem %= b;
  }
  cout << ans << '\n';
  return 0;
}
