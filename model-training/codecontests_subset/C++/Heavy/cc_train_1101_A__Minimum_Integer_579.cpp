#include <bits/stdc++.h>
using namespace std;
bool comp(const pair<long long, long long>& a,
          const pair<long long, long long>& b) {
  return a.second > b.second;
}
double EPSILON = numeric_limits<double>::epsilon();
bool AreSame(double a, double b) { return fabs(a - b) < EPSILON; }
struct classcomp {
  bool operator()(const pair<long long, long long>& lhs,
                  const pair<long long, long long>& rhs) const {
    return lhs.second > rhs.second;
  }
};
long long power(long long x, long long y, long long p) {
  long long res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (d >= l and d <= r) d = (r / d + 1) * d;
    cout << d << endl;
  }
  return 0;
}
