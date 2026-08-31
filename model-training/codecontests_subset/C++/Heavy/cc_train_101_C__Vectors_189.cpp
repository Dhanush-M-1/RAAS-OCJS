#include <bits/stdc++.h>
using namespace std;
int nextInt() {
  int x;
  scanf("%d", &x);
  return x;
}
const int BUFSIZE = 100111;
char buf[BUFSIZE + 1];
string nextString() {
  scanf("%s", buf);
  return buf;
}
long long det(long long a, long long b, long long c, long long d) {
  return a * d - b * c;
}
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
bool isSolvable(long long A1, long long B1, long long C1, long long A2,
                long long B2, long long C2) {
  if (A1 == 0 && B1 == 0 && C1 != 0 || A2 == 0 && B2 == 0 && C2 != 0) {
    return false;
  }
  long long D = det(A1, B1, A2, B2);
  long long Dx = det(C1, B1, C2, B2);
  long long Dy = det(A1, C1, A2, C2);
  if (D == 0) {
    if (A1 == 0 && B1 == 0) {
      if (A2 == 0 && B2 == 0) {
        return true;
      } else {
        return C2 % gcd(A2, B2) == 0;
      }
    } else {
      return C1 % gcd(A1, B1) == 0;
    }
  }
  return Dx % D == 0 && Dy % D == 0;
}
bool isSolvable(long long x, long long y, long long cx1, long long cx2,
                long long cy1, long long cy2, long long x2, long long y2) {
  return isSolvable(cx1, cy1, x2 - x, cx2, cy2, y2 - y);
}
int main() {
  long long x1 = nextInt();
  long long y1 = nextInt();
  long long x2 = nextInt();
  long long y2 = nextInt();
  long long cx = nextInt();
  long long cy = nextInt();
  bool res = isSolvable(x1, y1, cx, cy, cy, -cx, x2, y2) ||
             isSolvable(y1, -x1, -cx, -cy, cy, -cx, x2, y2) ||
             isSolvable(-x1, -y1, -cx, -cy, -cy, cx, x2, y2) ||
             isSolvable(-y1, x1, cx, cy, -cy, cx, x2, y2);
  cout << (res ? "YES" : "NO") << endl;
  return 0;
}
