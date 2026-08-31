#include <bits/stdc++.h>
using namespace std;
struct v {
  long long x;
  long long y;
  void rot() {
    long long nx = -y;
    long long ny = x;
    x = nx;
    y = ny;
  }
};
long long dotprod(v v1, v v2) { return v1.x * v2.x + v1.y * v2.y; }
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  v a, b, c1;
  cin >> a.x >> a.y;
  cin >> b.x >> b.y;
  cin >> c1.x >> c1.y;
  long long len = c1.x * c1.x + c1.y * c1.y;
  v c2 = c1;
  c1.rot();
  for (int i = 0; i < 6; i++) {
    a.rot();
    v B = b;
    B.x -= a.x;
    B.y -= a.y;
    long long t1 = dotprod(B, c1);
    long long t2 = dotprod(B, c2);
    if (B.x == 0 && B.y == 0) {
      cout << "YES";
      return 0;
    }
    if (len != 0 && t1 % len == 0 && t2 % len == 0) {
      cout << "YES";
      return 0;
    }
  }
  cout << "NO";
}
