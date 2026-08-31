#include <bits/stdc++.h>
using namespace std;
struct point {
  long long x, y;
  point(long long a = 0, long long b = 0) : x(a), y(b) {}
  long long operator*(point B) { return x * B.x + y * B.y; }
  point rota() { return point(-y, x); }
  point operator-(point B) { return point(x - B.x, y - B.y); }
  void read() { cin >> x >> y; }
};
point A, B, C;
string solve() {
  point Ct = C.rota();
  long long tam = C * C;
  for (int i = 0; i < 4; i++) {
    point D = B - A;
    if (C.x == 0 && C.y == 0) {
      if (D.x == 0 && D.y == 0) return "YES";
    } else if (D * C % tam == 0 && D * Ct % tam == 0)
      return "YES";
    A = A.rota();
  }
  return "NO";
}
int main() {
  A.read();
  B.read();
  C.read();
  cout << solve() << endl;
}
