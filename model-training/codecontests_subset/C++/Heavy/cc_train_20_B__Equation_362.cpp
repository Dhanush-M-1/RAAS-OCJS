#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c;
  float dir, x1, x2;
  int count;
  while (cin >> a >> b >> c) {
    if (a == 0 && b == 0 && c == 0)
      cout << "-1" << endl;
    else if (a == 0) {
      if (b == 0)
        cout << "0" << endl;
      else {
        cout << "1" << endl;
        printf("%.5f\n", -(float)c / (float)b);
      }
    } else {
      dir = b * b - 4 * a * c;
      if (dir < 0)
        cout << "0" << endl;
      else {
        if (dir > 0) count = 2;
        if (dir == 0) count = 1;
        dir = sqrt(dir);
        x1 = (-b + dir) / (2 * a);
        x2 = (-b - dir) / (2 * a);
        if (x1 > x2) swap(x1, x2);
        if (count == 1) printf("%d\n%.5f\n", count, x1);
        if (count == 2) printf("%d\n%.5f\n%.5f\n", count, x1, x2);
      }
    }
  }
}
