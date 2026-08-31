#include <bits/stdc++.h>
using namespace std;
const long long BASE = 1e9 + 7;
const long double EPS = 1e-9;
const long long EPS_INT = 1e12;
inline long long gcd(long long a, long long b) {
  long long r;
  while (b) {
    r = a % b;
    a = b;
    b = r;
  }
  return a;
}
inline long long lcm(long long a, long long b) { return a * b / gcd(a, b); }
inline long long fpow(long long a, long long n, long long p = BASE) {
  long long r = 1;
  for (; n; n >>= 1) {
    if (n & 1) r = r * a % p;
    a = a * a % p;
  }
  return r;
}
inline long long addmod(long long a, long long b, long long p = BASE) {
  a = (a + b);
  if (a > p) a -= p;
  return a;
}
inline long long submod(long long a, long long b, long long p = BASE) {
  a = (a - b);
  if (a < 0) a += p;
  return a;
}
inline long long multi(long long a, long long b, long long p = BASE) {
  return a * b % p;
}
inline long long inverse(long long a, long long p = BASE) {
  return fpow(a, p - 2, p);
}
inline long long maximize(long long& a, long long b) {
  if (a < b) a = b;
  return a;
}
inline long long minimize(long long& a, long long b) {
  if (a > b) a = b;
  return a;
}
const int MAX = (long long)1e6;
struct Point {
  long long x, y, z;
  long long id;
  long long distance(Point t) {
    long long k = (t.x - this->x) * (t.x - this->x) +
                  (t.y - this->y) * (t.y - this->y) +
                  (t.z - this->z) * (t.z - this->z);
    return k;
  }
};
struct Dis {
  long long id, distance, idMin;
};
bool cmp(Dis a, Dis b) { return a.distance < b.distance; }
Point arrA[MAX + 1];
Dis arrB[MAX + 1];
void solves();
int main() {
  if (fopen("output.out", "w")) {
  }
  if (fopen("input.inp", "r")) {
    freopen("input.inp", "r", stdin);
  } else {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
  }
  solves();
  return 0;
}
void solves() {
  long long t;
  long long a, b, c;
  cin >> t;
  while (t--) {
    long long res = 0;
    long long res2 = 0;
    cin >> a >> b >> c;
    long long a1, b1, c1;
    a1 = a;
    b1 = b;
    c1 = c;
    res += min(a, b / 2) * 3;
    if (a * 2 >= b)
      b = 0;
    else
      b -= a * 2;
    res += min(b, c / 2) * 3;
    res2 += min(b1, c1 / 2) * 3;
    if (b1 >= c1 / 2)
      b1 -= c1 / 2;
    else
      b1 = 0;
    res2 += min(a1, b1 / 2) * 3;
    cout << max(res, res2) << endl;
  }
}
