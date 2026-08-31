#include <bits/stdc++.h>
using namespace std;
const int MOD = 998244353;
void add(int &a, int b) {
  a += b;
  if (a >= MOD) {
    a -= MOD;
  }
  if (a < 0) {
    a += MOD;
  }
}
struct FenwickTree {
  int dat[100055];
  FenwickTree() { memset(dat, 0, sizeof(dat)); }
  void add(int id, int val) {
    while (id <= (int)1e5) {
      ::add(dat[id], val);
      id |= (id + 1);
    }
  }
  int get(int id) {
    int res = 0;
    while (id >= 0) {
      ::add(res, dat[id]);
      id = (id & (id + 1)) - 1;
    }
    return res;
  }
};
const int B = 317;
int n, k;
int a[100055];
FenwickTree dat[B];
int dp[100055];
vector<int> occ[100055];
int offset[B];
int cnt[100055];
void change(int l, int r, int val) {
  if (l / B == r / B) {
    for (int i = l; i <= r; i++) {
      dat[i / B].add(cnt[i], -dp[i]);
      cnt[i] += val;
      dat[i / B].add(cnt[i], +dp[i]);
    }
    return;
  }
  while (l % B != 0) {
    dat[l / B].add(cnt[l], -dp[l]);
    cnt[l] += val;
    dat[l / B].add(cnt[l], +dp[l]);
    l++;
  }
  while (r % B != B - 1) {
    dat[r / B].add(cnt[r], -dp[r]);
    cnt[r] += val;
    dat[r / B].add(cnt[r], +dp[r]);
    r--;
  }
  while (l <= r) {
    offset[l / B] += val;
    l += B;
  }
}
int query() {
  int res = 0;
  for (int i = 0; i < B; i++) {
    int ub = k - offset[i];
    add(res, dat[i].get(ub));
  }
  return res;
}
int main() {
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
  }
  for (int i = 0; i <= n; i++) {
    occ[i].push_back(0);
  }
  dat[0].add(0, 1);
  dp[0] = 1;
  for (int i = 1; i <= n; i++) {
    if (occ[a[i]].size() > 1) {
      change(occ[a[i]].end()[-2], occ[a[i]].back() - 1, -1);
    }
    occ[a[i]].push_back(i);
    change(occ[a[i]].end()[-2], occ[a[i]].back() - 1, 1);
    dp[i] = query();
    dat[i / B].add(0, dp[i]);
  }
  cout << dp[n];
}
