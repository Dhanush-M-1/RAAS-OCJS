#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f, maxn = 1e5 + 5;
struct p {
  long long x, y;
  p rotate() { return (p){y, -x}; }
  p operator-(p v) { return (p){x - v.x, y - v.y}; }
  long long operator*(p v) { return x * v.y - y * v.x; }
} a[3];
bool check(p u, p v) {
  if (!v.x && !v.y) return !u.x && !u.y;
  long long m = v.x * v.x + v.y * v.y;
  return u * v % m == 0 && u * v.rotate() % m == 0;
}
int main(void) {
  ios_base::sync_with_stdio(0);
  for (int i = 0; i < 3; i++) cin >> a[i].x >> a[i].y;
  for (int i = 0; i < 4; i++) {
    if (check(a[0] - a[1], a[2])) {
      puts("YES");
      return 0;
    }
    a[1] = a[1].rotate();
  }
  puts("NO");
  return 0;
}
