#include <bits/stdc++.h>
using namespace std;
void method(long long x1, long long y1, long long x3, long long y3,
            long long x2, long long y2) {
  x3 -= x1;
  y3 -= y1;
  if (x2 == 0 && y2 == 0) {
    if (x3 == 0 && y3 == 0) {
      cout << "YES" << endl;
      exit(0);
    } else
      return;
  }
  if (x2 == 0) {
    swap(x2, y2);
  }
  if ((y3 * x2 - x3 * y2) % (x2 * x2 + y2 * y2) == 0) {
    long long y = (y3 * x2 - x3 * y2) / (x2 * x2 + y2 * y2);
    if ((x3 + y * y2) % x2 == 0) {
      long long x = (x3 + y * y2) % x2;
      cout << "YES" << endl;
      exit(0);
    }
  }
}
int main() {
  int x1, y1;
  int x2, y2;
  int x3, y3;
  cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3;
  method(x1, y1, x2, y2, x3, y3);
  method(-y1, x1, x2, y2, x3, y3);
  method(-x1, -y1, x2, y2, x3, y3);
  method(y1, -x1, x2, y2, x3, y3);
  cout << "NO" << endl;
  return 0;
}
