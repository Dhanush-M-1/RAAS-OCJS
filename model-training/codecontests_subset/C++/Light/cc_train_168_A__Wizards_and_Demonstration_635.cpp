#include <bits/stdc++.h>
using namespace std;
int main() {
  long s, t, p, n, x, y;
  cin >> n >> x >> y;
  if (n == 0) {
    cout << "0" << endl;
    return 0;
  }
  if (y == 0) {
    cout << "0" << endl;
    return 0;
  }
  p = (n * y) / 100;
  s = (p * 100) / n;
  if (s != y) {
    p++;
  }
  t = p - x;
  if (t < 0) {
    t = 0;
  }
  cout << t << endl;
  return 0;
}
