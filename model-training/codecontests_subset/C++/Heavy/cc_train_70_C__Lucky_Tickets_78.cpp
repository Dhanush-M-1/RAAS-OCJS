#include <bits/stdc++.h>
using namespace std;
template <class T>
T sqr(const T& t) {
  return t * t;
}
template <class T>
T abs(const T& t) {
  return ((t > 0) ? (t) : (-t));
}
void initialize() {
  freopen("_.in", "r", stdin);
  freopen("_.out", "w", stdout);
}
struct Point {
  int x;
  int y;
  Point(int x_, int y_) : x(x_), y(y_) {}
};
map<pair<int, int>, vector<int> > fractions;
int rev(int a) {
  int res = 0;
  while (a > 0) {
    res = res * 10 + (a % 10);
    a /= 10;
  }
  return res;
}
int nod(int a, int b) {
  if (a == 0) return b;
  if (b == 0) return a;
  return nod(b, a % b);
}
pair<int, int> fraction(int num) {
  int a = num;
  int b = rev(a);
  int d = nod(a, b);
  a /= d;
  b /= d;
  return pair<int, int>(a, b);
}
int main() {
  int maxX, maxY, w;
  cin >> maxX >> maxY >> w;
  for (int i = 1; i <= max(maxX, maxY); ++i) {
    fractions[fraction(i)].push_back(i);
  }
  map<pair<int, int>, vector<int> >::iterator it = fractions.begin(),
                                              jt = fractions.end();
  for (; it != jt; ++it) {
    sort(it->second.begin(), it->second.end());
  }
  const long long INF = (long long)maxX * (long long)maxY + 1;
  long long bestProduct = INF;
  int rx = -1, ry = -1;
  int res = 0;
  int y = maxY;
  for (int x = 1; x <= maxX; ++x) {
    pair<int, int> f = fraction(x);
    swap(f.first, f.second);
    const vector<int>& v = fractions[f];
    res += upper_bound(v.begin(), v.end(), y) - v.begin();
    do {
      pair<int, int> fy = fraction(y);
      swap(fy.first, fy.second);
      const vector<int>& vy = fractions[fy];
      res -= upper_bound(vy.begin(), vy.end(), x) - vy.begin();
      y -= 1;
    } while (res >= w && y > 0);
    y += 1;
    pair<int, int> fy = fraction(y);
    swap(fy.first, fy.second);
    const vector<int>& vy = fractions[fy];
    res += upper_bound(vy.begin(), vy.end(), x) - vy.begin();
    if (res >= w) {
      long long product = (long long)x * (long long)y;
      if (product < bestProduct) {
        bestProduct = product;
        rx = x;
        ry = y;
      }
    }
  }
  if (bestProduct < INF) {
    cout << rx << " " << ry << endl;
  } else {
    cout << -1 << endl;
  }
  return 0;
}
