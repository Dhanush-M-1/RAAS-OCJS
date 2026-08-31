#include <bits/stdc++.h>
using namespace std;
struct Point {
  long long x, y;
  Point() {}
  Point(long long x, long long y) : x(x), y(y) {}
  Point(const Point &p) : x(p.x), y(p.y) {}
  Point operator+(const Point &p) const { return Point(x + p.x, y + p.y); }
  Point operator-(const Point &p) const { return Point(x - p.x, y - p.y); }
  bool operator==(const Point &p) const { return (x == p.x && y == p.y); }
};
long long dot(Point p, Point q) { return p.x * q.x + p.y * q.y; }
long long cross(Point p, Point q) { return p.x * q.y - p.y * q.x; }
long long abs2(Point p) { return p.x * p.x + p.y * p.y; }
istream &operator>>(istream &is, Point &p) {
  is >> p.x >> p.y;
  return is;
}
ostream &operator<<(ostream &os, const Point &p) {
  return os << "(" << p.x << ", " << p.y << ") ";
}
Point RotateCW90(Point p) { return Point(p.y, -p.x); }
bool check(Point A, Point B, Point C) {
  long long det = abs2(C);
  if (det == 0) {
    return (A == B);
  }
  long long X = cross(B, C) - cross(A, C);
  long long Y = dot(B, C) - dot(A, C);
  return (X % det == 0 && Y % det == 0);
}
void run_case() {
  Point A, B, C;
  cin >> A >> B >> C;
  for (long long i = 0; i < 4; i++) {
    if (check(A, B, C)) {
      cout << "YES\n";
      return;
    }
    A = RotateCW90(A);
  }
  cout << "NO\n";
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  long long T = 1;
  for (long long t = 1; t <= T; t++) {
    run_case();
  }
  return 0;
}
