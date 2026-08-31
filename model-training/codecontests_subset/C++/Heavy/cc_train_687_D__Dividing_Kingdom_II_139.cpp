#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T bigmod(T p, T e, T M) {
  long long ret = 1;
  for (; e > 0; e >>= 1) {
    if (e & 1) ret = (ret * p) % M;
    p = (p * p) % M;
  }
  return (T)ret;
}
template <class T>
inline T gcd(T a, T b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
template <class T>
inline T modinverse(T a, T M) {
  return bigmod(a, M - 2, M);
}
int pre[1001], fl[1001];
int Find(int x) {
  if (x == pre[x]) return x;
  return pre[x] = Find(pre[x]);
}
pair<pair<int, int>, pair<int, int> > pp[1000001];
int ar[1001][1001], cnt[1001];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, m, q;
  cin >> n >> m >> q;
  for (int i = (1); i < (m + 1); ++i) {
    cin >> pp[i].second.first >> pp[i].second.second;
    cin >> pp[i].first.first;
    pp[i].first.second = i;
  }
  sort(pp + 1, pp + m + 1);
  while (q--) {
    for (int i = (1); i < (n + 1); ++i) cnt[i] = 0;
    for (int i = (1); i < (n + 1); ++i) {
      ar[i][++cnt[i]] = i;
      pre[i] = i;
      fl[i] = 0;
    }
    int l, r;
    cin >> l >> r;
    int res = 1000000009ll;
    for (int i = m; i >= 1; i--) {
      if (pp[i].first.second < l || pp[i].first.second > r) continue;
      int x = pp[i].second.first, y = pp[i].second.second,
          c = pp[i].first.first;
      int px = Find(x), py = Find(y);
      if (px == py) {
        if (fl[x] == fl[y]) {
          res = c;
          break;
        }
      } else {
        if (cnt[px] < cnt[py]) {
          swap(px, py);
          swap(x, y);
        }
        int d = (fl[x] == fl[y]);
        for (int k = (1); k < (cnt[py] + 1); ++k) {
          if (d) fl[ar[py][k]] ^= 1;
          ar[px][++cnt[px]] = ar[py][k];
        }
        pre[py] = px;
      }
    }
    if (res == 1000000009ll)
      cout << -1 << endl;
    else
      cout << res << endl;
  }
}
