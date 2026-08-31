#include <bits/stdc++.h>
using namespace std;
struct point {
  double x, y;
  point() { x = y = 0; }
  point(double xx, double yy) {
    x = xx;
    y = yy;
  }
  point operator+(point p) { return point(x + p.x, y + p.y); }
  point operator-(point p) { return point(x - p.x, y - p.y); }
  point operator*(double a) { return point(x * a, y * a); }
  double operator*(point p) { return x * p.x + y * p.y; }
  double len2() { return (*this) * (*this); }
  double len() { return sqrt((*this).len2()); }
  bool operator==(point p) { return ((*this) - p).len() < 1e-7; }
};
int const cnt = (2 << 20);
int n, k, a, b, q;
int aa[cnt], bb[cnt];
void add_a(int d, int cc) {
  int pos = cnt / 2 + d;
  int h = min(aa[pos] + cc, a);
  int add = h - aa[pos];
  aa[pos] = h;
  pos /= 2;
  while (pos != 0) {
    aa[pos] += add;
    pos /= 2;
  }
}
void add_b(int d, int cc) {
  int pos = cnt / 2 + d;
  int h = min(bb[pos] + cc, b);
  int add = h - bb[pos];
  bb[pos] = h;
  pos /= 2;
  while (pos != 0) {
    bb[pos] += add;
    pos /= 2;
  }
}
long long get_a(int l, int r) {
  l = cnt / 2 + l;
  r = cnt / 2 + r;
  long long ans = 0;
  while (l <= r) {
    if ((l & 1) == 1) ans += aa[l], l++;
    if ((r & 1) == 0) ans += aa[r], r--;
    l /= 2;
    r /= 2;
  }
  return ans;
}
long long get_b(int l, int r) {
  l = cnt / 2 + l;
  r = cnt / 2 + r;
  long long ans = 0;
  while (l <= r) {
    if ((l & 1) == 1) ans += bb[l], l++;
    if ((r & 1) == 0) ans += bb[r], r--;
    l /= 2;
    r /= 2;
  }
  return ans;
}
int main() {
  cout.setf(ios::fixed, ios::floatfield);
  cout.precision(2);
  cin >> n >> k >> a >> b >> q;
  for (int(i) = (0); i < (q); ++(i)) {
    int h;
    cin >> h;
    if (h == 1) {
      int di, ai;
      cin >> di >> ai;
      add_a(di, ai);
      add_b(di, ai);
    } else {
      int p;
      cin >> p;
      cout << get_b(1, p - 1) + get_a(p + k, n) << endl;
    }
  }
  return 0;
}
