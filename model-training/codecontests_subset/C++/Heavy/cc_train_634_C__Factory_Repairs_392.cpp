#include <bits/stdc++.h>
using namespace std;
const int MAXN = 200500;
long long pref[MAXN];
long long suf[MAXN];
long long tsuf[MAXN];
long long tpref[MAXN];
long long n, k, a, b, q;
inline int f(int x) { return x & (-x); }
void upd1(int ind, long long dx) {
  for (; ind < n; ind += f(ind + 1)) tpref[ind] += dx;
}
void upd2(int ind, long long dx) {
  for (; ind < n; ind += f(ind + 1)) tsuf[ind] += dx;
}
long long get1(int ind) {
  long long res = 0;
  for (; ind >= 0; ind -= f(ind + 1)) res += tpref[ind];
  return res;
}
long long get2(int ind) {
  long long res = 0;
  for (; ind >= 0; ind -= f(ind + 1)) res += tsuf[ind];
  return res;
}
int main() {
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; ++i) {
    int c;
    cin >> c;
    if (c == 1) {
      long long cnt, d;
      cin >> d >> cnt;
      d--;
      long long val = min(b, cnt + pref[d]);
      upd1(d, val - pref[d]);
      pref[d] = val;
      val = min(a, cnt + suf[d]);
      upd2(d, val - suf[d]);
      suf[d] = val;
    } else {
      long long p;
      cin >> p;
      p--;
      long long cur = get1(p - 1) + get2(n - 1) - get2(p + k - 1);
      cout << cur << '\n';
    }
  }
  return 0;
}
