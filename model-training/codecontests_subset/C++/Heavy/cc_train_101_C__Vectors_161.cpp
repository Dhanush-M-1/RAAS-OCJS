#include <bits/stdc++.h>
using namespace std;
int stmp;
struct vrt {
  long long x, y;
  vrt() {}
  vrt(long long x, long long y) : x(x), y(y) {}
  vrt operator-(const vrt& rhs) const { return vrt(x - rhs.x, y - rhs.y); }
  long long operator*(const vrt& rhs) const { return x * rhs.x + y * rhs.y; }
  long long len() const { return x * x + y * y; }
  vrt rot() {
    vrt r;
    r.y = x;
    r.x = -y;
    return r;
  }
};
vrt scan() {
  vrt a;
  cin >> a.x;
  cin >> a.y;
  return a;
}
bool solve(vrt t, vrt c) {
  long long a = t * c;
  long long b = t * c.rot();
  long long cc = c.rot().len();
  if (cc == 0) return t.x == 0 && t.y == 0;
  if (0) cout << "a " << a << " b " << b << " cc " << (int)cc << endl;
  long long aa = a;
  long long bb = b;
  return aa % cc == 0 && bb % cc == 0;
}
bool test(vrt a, vrt b, vrt c) {
  for (int(i) = 0; (i) < int(4); (i)++) {
    if (solve(b - a, c)) return 1;
    a = a.rot();
  }
  return 0;
}
int main() {
  vrt a, b, c;
  a = scan();
  b = scan();
  c = scan();
  if (test(a, b, c))
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
