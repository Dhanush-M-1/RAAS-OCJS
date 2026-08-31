#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const int MOD = 1e9 + 7;
const int maxn = 1e6 + 10;
const double eps = 1e-9;
struct vec {
  long long x, y;
  vec rotate() { return (vec){y, -x}; }
  vec operator-(vec v) { return (vec){x - v.x, y - v.y}; }
  long long operator*(vec v) { return x * v.y - y * v.x; }
} a, b, c;
bool check(vec u, vec v) {
  if (!v.x && !v.y) return !u.x && !u.y;
  long long m = v.x * v.x + v.y * v.y;
  return u * v % m == 0 && u * v.rotate() % m == 0;
}
int main() {
  cin >> a.x >> a.y >> b.x >> b.y >> c.x >> c.y;
  int flag = 1;
  for (int i = 0; i < 4; i++) {
    if (check(a - b, c)) {
      puts("YES");
      flag = 0;
      break;
    }
    b = b.rotate();
  }
  if (flag) puts("NO");
  return 0;
}
