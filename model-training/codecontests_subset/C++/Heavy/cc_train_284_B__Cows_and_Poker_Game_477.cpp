#include <bits/stdc++.h>
using namespace std;
long long i64 = 4611686018427387904;
long double dist(long double x1, long double y1, long double x2,
                 long double y2) {
  return sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
}
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long nok(long long a, long long b) { return (a * b) / gcd(a, b); }
long long hash(string s, unsigned long long alph, unsigned long long mod) {
  long long h = 0, p = alph;
  for (int i = 0; i < s.size(); i++) {
    h += (s[i] - 'a' + 1) * p;
    p *= alph;
    h %= i64;
  }
  return h;
}
bool F(long double ax1, long double ay1, long double ax2, long double ay2,
       long double bx1, long double by1, long double bx2, long double by2) {
  long double v1, v2, v3, v4;
  v1 = (bx2 - bx1) * (ay1 - by1) - (by2 - by1) * (ax1 - bx1);
  v2 = (bx2 - bx1) * (ay2 - by1) - (by2 - by1) * (ax2 - bx1);
  v3 = (ax2 - ax1) * (by1 - ay1) - (ay2 - ay1) * (bx1 - ax1);
  v4 = (ax2 - ax1) * (by2 - ay1) - (ay2 - ay1) * (bx2 - ax1);
  return (v1 * v2 < 0) && (v3 * v4 < 0);
}
int main() {
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  bool w = false;
  int ans = 0;
  for (int i = 0; i < n; i++) {
    char t;
    cin >> t;
    if (t == 'I') {
      if (w == true) {
        cout << 0;
        return 0;
      } else {
        w = true;
      }
    } else {
      if (t == 'A') {
        ans++;
      }
    }
  }
  if (w == true) {
    cout << 1;
  } else {
    cout << ans;
  }
}
