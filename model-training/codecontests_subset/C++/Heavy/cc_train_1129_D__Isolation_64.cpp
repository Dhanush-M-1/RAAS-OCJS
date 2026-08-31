#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#pragma GCC optimize("unroll-loops")
using namespace std;
const int arr = 2e5 + 10;
const int ar = 2e3 + 10;
const long double pi = acos(-1);
const long double eps = 1e-10;
const long long md = 1e9 + 7;
void add(int& a, int b) {
  a += b;
  if (a >= (long long)(998244353)) {
    a -= (long long)(998244353);
  }
  if (a < 0) {
    a += (long long)(998244353);
  }
}
int n, k;
int sum_block[((int)(1e5 + 10) >> 8) + 2][(int)(1e5 + 10)];
int push_block[((int)(1e5 + 10) >> 8) + 2];
int last_value[(int)(1e5 + 10)];
int dp[(int)(1e5 + 10)];
pair<int, int> last_seg[(int)(1e5 + 10)];
int ans;
inline bool in(int a, int b, int c) { return a <= b && b < c; }
inline void inc_pos(int pos) {
  if (last_value[pos] + push_block[pos >> 8] == k) {
    add(ans, -dp[pos]);
  }
  add(sum_block[pos >> 8][last_value[pos]], -dp[pos]);
  last_value[pos]++;
  add(sum_block[pos >> 8][last_value[pos]], +dp[pos]);
}
inline void dec_pos(int pos) {
  if (last_value[pos] + push_block[pos >> 8] == k + 1) {
    add(ans, +dp[pos]);
  }
  add(sum_block[pos >> 8][last_value[pos]], -dp[pos]);
  last_value[pos]--;
  add(sum_block[pos >> 8][last_value[pos]], +dp[pos]);
}
void inc(int l, int r) {
  if ((r >> 8) - (l >> 8) + 1 <= 2) {
    for (int i = l; i <= r; i++) {
      inc_pos(i);
    }
  } else {
    while ((l & 255) != 0) {
      inc_pos(l);
      l++;
    }
    while ((r & 255) != 255) {
      inc_pos(r);
      r--;
    }
    for (int i = (l >> 8); i <= (r >> 8); i++) {
      if (in(0, k - push_block[i], (int)(1e5 + 10))) {
        add(ans, -sum_block[i][k - push_block[i]]);
      }
      push_block[i]++;
    }
  }
}
void dec(int l, int r) {
  if ((r >> 8) - (l >> 8) + 1 <= 2) {
    for (int i = l; i <= r; i++) {
      dec_pos(i);
    }
  } else {
    while ((l & 255) != 0) {
      dec_pos(l);
      l++;
    }
    while ((r & 255) != 255) {
      dec_pos(r);
      r--;
    }
    for (int i = (l >> 8); i <= (r >> 8); i++) {
      if (in(0, k + 1 - push_block[i], (int)(1e5 + 10))) {
        add(ans, +sum_block[i][k + 1 - push_block[i]]);
      }
      push_block[i]--;
    }
  }
}
int a[(int)(1e5 + 10)];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  sum_block[0][0] = 1;
  last_value[0] = 0;
  dp[0] = 1;
  ans = 1;
  map<int, int> last;
  for (int i = 1; i <= n; i++) {
    if (!last.count(a[i])) {
      inc(0, i - 1);
      last_seg[i] = make_pair(0, i - 1);
    } else {
      auto L = last_seg[last[a[i]]];
      dec(L.first, L.second);
      inc(last[a[i]], i - 1);
      last_seg[i] = make_pair(last[a[i]], i - 1);
    }
    last[a[i]] = i;
    dp[i] = ans;
    add(ans, dp[i]);
    add(sum_block[i >> 8][0], dp[i]);
  }
  cout << dp[n] << "\n";
}
