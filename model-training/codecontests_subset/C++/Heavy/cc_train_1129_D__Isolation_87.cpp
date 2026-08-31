#include <bits/stdc++.h>
#pragma GCC optimize "-O3"
using namespace std;
const int MOD = 998244353;
const int N = 120000;
const int SQRT = 200;
struct Block {
  int tl, tr;
  vector<tuple<int, int, int> > vals;
  vector<int> psum;
  int mod = 0;
  Block() = default;
  void rebuild() {
    for (auto& v : vals) {
      get<0>(v) += mod;
    }
    mod = 0;
    sort(vals.begin(), vals.end());
    psum.resize(vals.size(), 0);
    int n = psum.size();
    for (int i = 0; i < n; i++) {
      psum[i] = 0;
      if (i) {
        psum[i] = psum[i - 1];
      }
      psum[i] = (psum[i] + get<2>(vals[i])) % MOD;
    }
  }
  void change(int pos, int val) {
    for (auto& v : vals) {
      if (get<1>(v) == pos) {
        get<0>(v) = 0;
        get<2>(v) = val;
      }
    }
    rebuild();
  }
  void add(int l, int r, int x) {
    if (r < tl || l > tr) {
      return;
    }
    if (tl >= l && tr <= r) {
      mod += x;
    } else {
      for (auto& v : vals) {
        if (get<1>(v) >= l && get<1>(v) <= r) {
          get<0>(v) += x;
        }
      }
      rebuild();
    }
  }
  int calc(int k) {
    k -= mod;
    if (get<0>(vals[0]) > k) {
      return 0;
    }
    int lg = 0, rg = vals.size();
    while (rg - lg > 1) {
      int mg = (lg + rg) >> 1;
      if (get<0>(vals[mg]) <= k) {
        lg = mg;
      } else {
        rg = mg;
      }
    }
    return psum[lg];
  }
  void print() {
    for (auto& v : vals) {
      cout << get<0>(v) << " " << get<1>(v) << " " << get<2>(v) << "\n";
    }
  }
};
Block b[N];
int a[N];
int f[N];
int lst[N];
int id[N];
int lv[N];
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  int n, k;
  cin >> n >> k;
  int bptr = 1;
  b[bptr].tl = 0;
  b[bptr].tr = 0;
  for (int i = 0; i <= n; i++) {
    if (i != 0) {
      cin >> a[i];
    }
    if (b[bptr].tr - b[bptr].tl == SQRT) {
      bptr++;
      b[bptr].tl = b[bptr].tr = i;
    } else {
      b[bptr].tr = i;
    }
    b[bptr].vals.emplace_back(N, i, 0);
    id[i] = bptr;
  }
  auto ad = [&](int l, int r, int x) {
    for (int i = 1; i <= bptr; i++) {
      b[i].add(l, r, x);
    }
  };
  auto gt = [&](int x) {
    int ans = 0;
    for (int i = 1; i <= bptr; i++) {
      ans = (ans + b[i].calc(x)) % MOD;
    }
    return ans;
  };
  f[0] = 1;
  b[id[0]].change(0, 1);
  for (int i = 1; i <= n; i++) {
    ad(lst[a[i]], i - 1, 1);
    if (lst[a[i]] != 0) {
      ad(lv[a[i]], lst[a[i]] - 1, -1);
    }
    lv[a[i]] = lst[a[i]];
    lst[a[i]] = i;
    f[i] = (f[i] + gt(k)) % MOD;
    b[id[i]].change(i, f[i]);
  }
  cout << f[n] << "\n";
  return 0;
}
