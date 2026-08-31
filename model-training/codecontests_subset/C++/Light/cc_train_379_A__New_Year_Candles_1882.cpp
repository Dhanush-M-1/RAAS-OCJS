#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int ans = 0;
  if (a >= b) {
    ans = a + a / b;
    a += -a + a / b + a % b;
    while (a >= b) {
      ans += a / b;
      a += -a + a / b + a % b;
    }
  } else {
    ans = a;
  }
  cout << ans << endl;
}
