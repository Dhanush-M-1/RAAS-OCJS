#include <bits/stdc++.h>
using namespace std;
const long long md = 1e9 + 7;
inline void add(long long &a, long long b) {
  a += b;
  if (a >= md) a -= md;
}
inline void sub(long long &a, long long b) {
  a -= b;
  if (a < 0) a += md;
}
inline long long mul(long long a, long long b) {
  return (long long)((long long)a * b % md);
}
inline long long power(long long a, long long b) {
  long long res = 1;
  while (b > 0) {
    if (b & 1) {
      res = mul(res, a);
    }
    a = mul(a, a);
    b >>= 1ll;
  }
  return res % md;
}
inline long long inv(long long a) {
  a %= md;
  if (a < 0) a += md;
  long long b = md, u = 0, v = 1;
  while (a) {
    int t = b / a;
    b -= t * a;
    swap(a, b);
    u -= t * v;
    swap(u, v);
  }
  assert(b == 1);
  if (u < 0) u += md;
  return u;
}
struct Event {
  Event(long long t, long long i, long long ty) : time(t), idx(i), type(ty) {}
  long long time, idx, type;
  bool operator<(const Event &rhs) {
    if (time == rhs.time) return type > rhs.type;
    return time < rhs.time;
  }
};
const long long INF = 1e18;
long long get(long long k, vector<long long> &rec) {
  long long r = 0, i = -1;
  long long n = rec.size();
  long long ans = 0;
  while (r < n) {
    if (rec[r] <= i) return INF;
    i = rec[r];
    r = rec[r] + k;
    ans++;
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n, m, k;
  cin >> n >> m >> k;
  vector<long long> pos(n, 1);
  vector<long long> rec(n, -1);
  for (long long i = 0; i < m; i++) {
    long long x;
    cin >> x;
    pos[x] = 0;
  }
  for (long long i = 0; i < n; i++) {
    if (pos[i])
      rec[i] = i;
    else if (i)
      rec[i] = rec[i - 1];
    else
      rec[i] = -1;
  }
  vector<long long> c(k + 1);
  for (long long i = 1; i < k + 1; i++) cin >> c[i];
  long long ans = INF;
  for (long long i = 1; i < k + 1; i++) {
    long long x = get(i, rec);
    if (x != INF) ans = min(ans, c[i] * x);
  }
  ans = ans == INF ? -1 : ans;
  cout << ans;
}
