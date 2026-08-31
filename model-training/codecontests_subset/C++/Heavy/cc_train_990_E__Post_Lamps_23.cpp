#include <bits/stdc++.h>
template <class T>
inline bool chmax(T& a, T b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
inline bool chmin(T& a, T b) {
  if (a > b) {
    a = b;
    return 1;
  }
  return 0;
}
constexpr long long MAX = 5100000;
constexpr long long INF = 1LL << 60;
constexpr int inf = 1 << 28;
constexpr long long mod = 1000000007LL;
using namespace std;
vector<int> last;
long long n, k, m;
long long cnt(long long len) {
  int now = 0;
  int pre = -1;
  long long res = 0;
  while (now < n) {
    if (last[now] <= pre) return INF;
    pre = last[now];
    now = last[now] + len;
    res++;
  }
  return res;
}
int main() {
  scanf("%lld %lld %lld", &n, &m, &k);
  vector<bool> flag(n, true);
  vector<int> s(m);
  for (int i = 0; i < m; i++) scanf("%d", &s[i]), flag[s[i]] = false;
  vector<int> a(k);
  for (int i = 0; i < k; i++) scanf("%d", &a[i]);
  last.resize(n);
  ;
  for (int i = 0; i < n; i++) {
    if (i == 0) {
      if (flag[i])
        last[i] = i;
      else
        last[i] = -1;
    } else {
      if (flag[i])
        last[i] = i;
      else
        last[i] = last[i - 1];
    }
  }
  long long res = INF;
  for (int i = 0; i < k; i++) {
    long long tmp = cnt(i + 1);
    if (tmp == INF) continue;
    chmin(res, a[i] * tmp);
  }
  if (res == INF) res = -1;
  cout << res << endl;
  return 0;
}
