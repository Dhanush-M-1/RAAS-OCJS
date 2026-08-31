#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int i;
  int d = a * c, ans;
  if (d % b == 0) {
    ans = d / b;
    ans = ans - c;
  } else {
    ans = (d / b) + 1;
    ans = ans - c;
  }
  cout << ans << endl;
  return 0;
}
