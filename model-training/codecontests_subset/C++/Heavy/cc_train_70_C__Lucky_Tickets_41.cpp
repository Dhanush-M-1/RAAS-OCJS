#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 5, mod = 1e6 + 3, inf = 0x3f3f3f3f;
template <class T>
T QuickMod(T a, T b, T c) {
  T ans = 1;
  while (b) {
    if (b & 1) ans = ans * a % c;
    b >>= 1;
    a = (a * a) % c;
  }
  return ans;
}
template <class T>
T Gcd(T a, T b) {
  return b != 0 ? Gcd(b, a % b) : a;
}
template <class T>
T Lcm(T a, T b) {
  return a / Gcd(a, b) * b;
}
template <class T>
void outln(T x) {
  cout << x << endl;
}
int mx, my, w, cnt;
map<double, long long> m, n;
int rev(int k) {
  int a = 0;
  while (k) {
    a = a * 10 + k % 10;
    k /= 10;
  }
  return a;
}
int main() {
  cin >> mx >> my >> w;
  for (int i = 1; i <= mx; i++) m[1.0 * i / rev(i)]++;
  for (int i = 1; i <= my; i++) cnt += m[1.0 * rev(i) / i];
  if (cnt < w) {
    puts("-1");
    return 0;
  }
  int dx = mx, dy = 1, cnt = m[1.0], x = mx, y = my;
  double t;
  n[1.0]++;
  while (dx > 0 && dy <= my) {
    if (cnt >= w) {
      if (1ll * dx * dy < 1ll * x * y) {
        x = dx;
        y = dy;
      }
      t = 1.0 * dx / rev(dx);
      cnt -= n[t];
      m[t]--;
      dx--;
    } else {
      dy++;
      t = 1.0 * rev(dy) / dy;
      cnt += m[t];
      n[t]++;
    }
  }
  cout << x << ' ' << y << endl;
  return 0;
}
