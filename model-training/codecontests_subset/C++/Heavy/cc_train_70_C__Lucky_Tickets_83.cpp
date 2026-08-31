#include <bits/stdc++.h>
using namespace std;
template <typename T>
T abs(T a) {
  return a < 0 ? -a : a;
}
template <typename T>
T sqr(T a) {
  return a * a;
}
const int INF = (int)1e9;
const long double EPS = 1e-9;
const long double PI = 3.1415926535897932384626433832795;
int gcd(int a, int b) { return (a == 0) ? b : gcd(b % a, a); }
struct rat {
  int a, b;
  rat(int ca, int cb) : a(ca), b(cb) {
    int g = gcd(a, b);
    a /= g;
    b /= g;
  }
};
bool operator<(const rat& a, const rat& b) {
  return a.a * 1ll * b.b < b.a * 1ll * a.b;
}
int rev[100500];
inline int getRev(int a) {
  if (rev[a] == -1) {
    int b = a;
    int res = 0;
    do {
      res = 10 * res + (b % 10);
      b /= 10;
    } while (b > 0);
    rev[a] = res;
  }
  return rev[a];
}
int maxX, maxY, w;
map<rat, int> mx, my;
int main() {
  pair<int, int> ans(-1, -1);
  memset(rev, -1, sizeof(rev));
  cin >> maxX >> maxY >> w;
  for (int y = 1; y <= maxY; ++y) my[rat(y, getRev(y))]++;
  int y = maxY;
  int cur = 0;
  for (int x = 1; x <= maxX; ++x) {
    rat rx(x, getRev(x));
    mx[rx]++;
    swap(rx.a, rx.b);
    cur += my[rx];
    while (y > 0 && cur >= w) {
      if (ans.first == -1 || ans.first * 1ll * ans.second > x * 1ll * y) {
        ans = pair<int, int>(x, y);
      }
      rat ry(y, getRev(y));
      my[ry]--;
      swap(ry.a, ry.b);
      cur -= mx[ry];
      y--;
    }
  }
  if (ans.first == -1) {
    puts("-1");
    return 0;
  }
  cout << ans.first << " " << ans.second << endl;
  return 0;
}
