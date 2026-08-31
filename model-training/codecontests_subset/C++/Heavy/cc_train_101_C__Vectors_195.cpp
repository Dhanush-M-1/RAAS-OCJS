#include <bits/stdc++.h>
using namespace std;
long long ax, ay, bx, by, cx, cy;
int main() {
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  long long dx = bx - ax, dy = by - ay, D = cx * cx + cy * cy;
  if (!D) {
    complex<double> a = complex<double>(ax, ay), b = complex<double>(bx, by),
                    I = complex<double>(0.0, 1.0);
    cout << (b == a || b == a * I || b == a * I * I || b == a * I * I * I
                 ? "YES"
                 : "NO");
    return 0;
  }
  if ((cx * dx + cy * dy) % D == 0 && (-cy * dx + cx * dy) % D == 0) {
    cout << "YES";
    return 0;
  }
  dx = bx + ay, dy = by - ax;
  if ((cx * dx + cy * dy) % D == 0 && (-cy * dx + cx * dy) % D == 0) {
    cout << "YES";
    return 0;
  }
  dx = bx + ax, dy = by + ay;
  if ((cx * dx + cy * dy) % D == 0 && (-cy * dx + cx * dy) % D == 0) {
    cout << "YES";
    return 0;
  }
  dx = bx - ay, dy = by + ax;
  if ((cx * dx + cy * dy) % D == 0 && (-cy * dx + cx * dy) % D == 0) {
    cout << "YES";
    return 0;
  }
  cout << "NO";
}
