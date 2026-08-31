#include <bits/stdc++.h>
using namespace std;
template <class T>
bool uin(T &a, T b) {
  return a > b ? (a = b, true) : false;
}
template <class T>
bool uax(T &a, T b) {
  return a < b ? (a = b, true) : false;
}
const int maxn = 210000;
int fl[maxn], fr[maxn], a[maxn];
int fsum(int *f, int i) {
  int s = 0;
  for (; i >= 0; i &= i + 1, --i) s += f[i];
  return s;
}
void fadd(int *f, int i, int x) {
  for (; i < maxn; i |= i + 1) f[i] += x;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.precision(10);
  cout << fixed;
  int n, k, A, B, q;
  cin >> n >> k >> A >> B >> q;
  for (int i = 0; i < (int)(q); ++i) {
    int t;
    cin >> t;
    if (t == 1) {
      int d, t;
      cin >> d >> t;
      fadd(fl, d, -min(a[d], B));
      fadd(fr, d, -min(a[d], A));
      a[d] += t;
      fadd(fl, d, min(a[d], B));
      fadd(fr, d, min(a[d], A));
    } else {
      int p;
      cin >> p;
      cout << fsum(fl, p - 1) + fsum(fr, n) - fsum(fr, p + k - 1) << '\n';
    }
  }
  return 0;
}
