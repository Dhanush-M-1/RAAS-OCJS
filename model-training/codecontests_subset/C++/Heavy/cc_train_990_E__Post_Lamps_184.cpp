#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx")
using namespace std;
bool is_prime(long long n) {
  for (long long i = 2; i * i <= n; ++i) {
    if (n % i == 0) {
      return false;
    }
  }
  return true;
}
vector<long long> fact(long long n) {
  vector<long long> ans;
  for (int i = 2; i * i <= n; i++) {
    if (n % i == 0) {
      ans.push_back(i);
      while (n % i == 0) {
        n /= i;
      }
    }
  }
  if (n > 1) ans.push_back(n);
  return ans;
}
long long getPow(long long a, long long b) {
  long long res = 1ll, tp = a;
  while (b) {
    if (b & 1ll) {
      res *= tp;
    }
    tp *= tp;
    b >>= 1ll;
  }
  return res;
}
long long vec_mult(long long x1, long long y1, long long x2, long long y2,
                   long long x3, long long y3) {
  return abs((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1));
}
void ok() {
  cout << "YES" << endl;
  exit(0);
}
void no() {
  cout << "NO" << endl;
  exit(0);
}
inline long long nxt() {
  long long x;
  cin >> x;
  return x;
}
const long long N = 3000 + 5, inf = 2e16;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0), cout.tie(0);
  long long n = nxt(), m = nxt(), k = nxt();
  vector<long long> used(n, 1);
  for (int i = 0; i < m; i++) {
    long long x = nxt();
    used[x] = 0;
  }
  vector<long long> a(k);
  for (int i = 0; i < k; i++) {
    a[i] = nxt();
  }
  if (!used[0]) {
    return cout << -1, 0;
  }
  vector<long long> pos;
  for (int i = 0; i < n; i++) {
    if (used[i]) pos.push_back(i);
  }
  auto get = [&](long long l) {
    long long ct = 0;
    long long start = 0;
    long long ind = 0;
    if (!pos.size()) return inf;
    while (true) {
      ct++;
      long long cur = start + l;
      if (cur >= n) {
        start = cur;
        break;
      }
      long long cur_ind =
          (upper_bound(pos.begin(), pos.end(), cur)) - pos.begin();
      if (cur_ind == pos.size())
        cur_ind--;
      else if (pos[cur_ind] > cur) {
        cur_ind--;
      }
      if (pos[cur_ind] == start) break;
      if (cur < n) {
        start = pos[cur_ind];
      } else {
        start = cur;
        break;
      }
    }
    if (start >= n)
      return ct;
    else
      return inf;
  };
  long long ans = inf;
  for (int i = 0; i < k; i++) {
    long long ct = get(i + 1);
    if (ct == inf) continue;
    ans = min(ans, ct * a[i]);
  }
  if (ans >= inf)
    cout << -1;
  else
    cout << ans;
  return 0;
}
