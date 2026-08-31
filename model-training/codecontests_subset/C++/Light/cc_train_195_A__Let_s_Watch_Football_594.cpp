#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  double ans = ceil((a * c) / b - c);
  if (ans < 0) ans = 0;
  cout << ans << endl;
  return 0;
}
