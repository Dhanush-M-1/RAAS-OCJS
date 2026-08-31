#include <bits/stdc++.h>
using namespace std;
template <class c>
struct rge {
  c b, e;
};
template <class c>
rge<c> range(c i, c j) {
  return rge<c>{i, j};
}
template <class c>
auto dud(c* x) -> decltype(cerr << *x, 0);
template <class c>
char dud(...);
struct debug {
  template <class c>
  debug& operator<<(const c&) {
    return *this;
  }
};
using ll = long long;
const int B = 100;
const int nax = 2e5 + 5;
int offset[nax / B];
int cnt[nax / B][B + 2];
int his[nax];
const int mod = 998244353;
void add_self(int& a, int b) {
  a += b;
  if (a >= mod) {
    a -= mod;
  }
}
int main() {
  int n, k;
  scanf("%d%d", &n, &k);
  vector<int> dp(B + n + 2);
  dp[1] = 1;
  auto ogarnij = [&](int who) {
    for (int i = 0; i <= B; ++i) {
      cnt[who][i] = 0;
    }
    int small = INT_MAX;
    for (int i = max(1, who * B); i < (who + 1) * B; ++i) {
      small = min(small, his[i]);
    }
    offset[who] += small;
    for (int i = max(1, who * B); i < (who + 1) * B; ++i) {
      his[i] -= small;
      add_self(cnt[who][his[i]], dp[i]);
    }
    for (int i = 1; i <= B; ++i) {
      add_self(cnt[who][i], cnt[who][i - 1]);
    }
  };
  auto add = [&](int L, int R, int x) {
    int left = L / B;
    int right = R / B;
    for (int i = left + 1; i < right; ++i) {
      offset[i] += x;
    }
    for (int i = L; i <= R && i / B == left; ++i) {
      his[i] += x;
    }
    ogarnij(left);
    if (left != right) {
      for (int i = R; i / B == right; --i) {
        his[i] += x;
      }
      ogarnij(right);
    }
  };
  ogarnij(0);
  vector<int> last(n + 1), sec_last(n + 1);
  for (int me = 1; me <= n; ++me) {
    int x;
    scanf("%d", &x);
    if (last[x]) {
      add(sec_last[x] + 1, last[x], -1);
    }
    add(last[x] + 1, me, 1);
    sec_last[x] = last[x];
    last[x] = me;
    int Z = 0;
    for (int who = 0; who <= me / B; ++who) {
      int up_to = min(k - offset[who], B);
      if (up_to >= 0) {
        add_self(Z, cnt[who][up_to]);
      }
    }
    dp[me + 1] = Z;
    ogarnij((me + 1) / B);
  }
  printf("%d\n", dp[n + 1]);
}
