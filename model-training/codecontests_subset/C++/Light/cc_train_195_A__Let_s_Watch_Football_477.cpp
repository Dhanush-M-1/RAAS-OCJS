#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, ans, ans1;
  cin >> a >> b >> c;
  ans = (a * c) - (b * c);
  ans1 = ans / b;
  if (ans % b == 0)
    cout << ans1;
  else
    cout << ans1 + 1;
  return 0;
}
