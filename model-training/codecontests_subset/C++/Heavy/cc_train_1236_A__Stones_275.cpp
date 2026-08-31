#include <bits/stdc++.h>
using namespace std;
void solve() {
  int a, b, c;
  cin >> a >> b >> c;
  int x = a, y = b, z = c;
  int sum = 0;
  int sum1 = 0;
  if (b / 2 > a) {
    sum += a + 2 * a;
    b = b - 2 * a;
  } else {
    sum += b / 2 + b / 2 * 2;
    b = b - b / 2 * 2;
  }
  if (c / 2 > b) {
    sum += b + 2 * b;
  } else
    sum += c / 2 + c / 2 * 2;
  if (z / 2 > y) {
    sum1 += y + 2 * y;
    y = 0;
  } else {
    sum1 += z / 2 + z / 2 * 2;
    y = y - z / 2;
  }
  if (y / 2 > x) {
    sum1 += x + 2 * x;
  } else
    sum1 += y / 2 + y / 2 * 2;
  cout << max(sum, sum1) << endl;
}
int main() {
  int t;
  cin >> t;
  while (t--) solve();
  return 0;
}
