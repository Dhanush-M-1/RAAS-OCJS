#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ull = unsigned long long;
using pii = pair<int, int>;
using pll = pair<ll, ll>;
template <class T>
inline bool Min(T &a, T b) {
  return a > b ? (a = b, true) : false;
}
template <class T>
inline bool Max(T &a, T b) {
  return a < b ? (a = b, true) : false;
}
inline int ni() {
  int a;
  scanf("%d", &a);
  return a;
}
inline ll nl() {
  ll a;
  scanf("%lld", &a);
  return a;
}
inline double nd() {
  double a;
  scanf("%lf", &a);
  return a;
}
inline void pi(int a) { printf("%d ", a); }
inline void pl(ll a) { printf("%lld ", a); }
inline void pd(double a) { printf("%.12lf ", a); }
const int N = 2e5 + 100;
const int BL = 1000;
ll maxA[N / BL + 1];
ll maxB[N / BL + 1];
ll xs[N];
int n, k, a, b, q;
void add(int day, int amount) {
  if (xs[day] + amount <= a)
    maxA[day / BL] += amount;
  else if (xs[day] <= a and xs[day] + amount > a)
    maxA[day / BL] += a - xs[day];
  if (xs[day] + amount <= b)
    maxB[day / BL] += amount;
  else if (xs[day] <= b and xs[day] + amount > b)
    maxB[day / BL] += b - xs[day];
  xs[day] += amount;
}
ll get(int p) {
  int s = p - 1;
  int e = p + k;
  ll res = 0;
  for (int i = 0; i <= s;) {
    if (i % BL == 0 and i + BL - 1 <= s) {
      res += maxB[i / BL];
      i += BL;
    } else {
      res += min(xs[i], 1LL * b);
      i++;
    }
  }
  int ee = n - 1;
  for (int i = e; i <= ee;) {
    if (i % BL == 0 and i + BL - 1 <= ee) {
      res += maxA[i / BL];
      i += BL;
    } else {
      res += min(1LL * a, xs[i]);
      i++;
    }
  }
  return res;
}
void solve() {
  n = ni();
  k = ni();
  a = ni();
  b = ni();
  q = ni();
  for (int i = 0; i < (int)(q); ++i) {
    int t = ni();
    if (t == 1) {
      int d = ni();
      int m = ni();
      add(d - 1, m);
    } else {
      int p = ni();
      ll res = get(p - 1);
      printf("%lld\n", res);
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  srand((int)clock());
  solve();
  return 0;
}
