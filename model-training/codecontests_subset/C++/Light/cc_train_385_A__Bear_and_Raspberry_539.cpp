#include <bits/stdc++.h>
using namespace std;
long double dist(pair<long double, long double> a,
                 pair<long double, long double> b) {
  return sqrt((a.first - b.first) * (a.first - b.first) +
              (a.second - b.second) * (a.second - b.second));
}
bool cmp(pair<long long, long long> a, pair<long long, long long> b) {
  return false;
}
long long GCD(long long a, long long b) {
  if (b == 0) return a;
  return GCD(b, a % b);
}
long long bigMod(long long x, long long p) {
  if (p == 0) return 1;
  if (p == 1) return x;
  if ((!(p & 1))) {
    long long temp = bigMod(x, p / 2);
    return (temp * temp) % 1000000007;
  }
  return (x * bigMod(x, p - 1)) % 1000000007;
}
long double moddist(pair<long long, long long> st,
                    pair<long long, long long> end,
                    pair<long long, long long> p) {
  long double ans = 0;
  long double f = (long double)(end.first - st.first) * (st.second - p.second);
  long double s = (long double)(st.first - p.first) * (end.second - st.second);
  ans = abs((f - s) / dist(st, end));
  return (ans <= 1e-14 ? 10000000000000000LL : ans);
}
int n;
inline bool valid(int i, int j) { return (i >= 0 && j >= 0 && i < n && j < n); }
int main() {
  ios::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  int c, x, y = 0, maxi = 0;
  cin >> n >> c;
  for (int i = 0; i < int(n); i++) cin >> x, maxi = max(maxi, y - x), y = x;
  return cout << (maxi - c > 0 ? maxi - c : 0) << endl, 0;
  ;
}
