#include <bits/stdc++.h>
using namespace std;
struct node {
  long long cost3 = 0;
  long long cost2 = 0;
  long long cost1a = 0, cost1b = 0, cost1c = 0;
  void add(pair<long long, long long> v) {
    if (v.first == 3) cost3 = max(cost3, v.second);
    if (v.first == 2) cost2 = max(cost2, v.second);
    if (v.first == 1) {
      if (cost1a <= v.second) {
        cost1c = cost1b;
        cost1b = cost1a;
        cost1a = v.second;
        return;
      }
      if (cost1b <= v.second) {
        cost1c = cost1b;
        cost1b = v.second;
        return;
      }
      if (cost1c < v.second) cost1c = v.second;
    }
  }
  long long ret1() { return max({cost3, cost2, cost1a}); }
  pair<long long, long long> ret2() {
    pair<long long, long long> ret = {cost1a, max(cost2, cost1b)};
    if (ret.first < ret.second) swap(ret.first, ret.second);
    return ret;
  }
  pair<long long, pair<long long, long long> > ret3() {
    return {cost1a, {cost1b, cost1c}};
  }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n, u, v, k;
  cin >> n;
  vector<node> vec(n);
  for (int i(0), ThkMk(n); i < ThkMk; ++i) {
    cin >> k;
    for (int j(0), ThkMk(k); j < ThkMk; ++j) {
      cin >> u >> v;
      vec[i].add({u, v});
    }
  }
  vector<long long> dp(10, -1);
  dp[0] = 0;
  for (int i(0), ThkMk(n); i < ThkMk; ++i) {
    long long x = vec[i].ret1();
    vector<long long> nw = dp;
    for (int k(0), ThkMk(10); k < ThkMk; ++k) {
      if (dp[k] != -1) {
        if (k == 9)
          nw[0] = max(nw[0], dp[9] + x * 2LL);
        else
          nw[k + 1] = max(nw[k + 1], dp[k] + x);
      }
    }
    x = vec[i].ret2().first;
    long long y = vec[i].ret2().second;
    if (y == 0) {
      dp = nw;
      continue;
    }
    for (int k(0), ThkMk(10); k < ThkMk; ++k) {
      if (dp[k] != -1) {
        if (k == 9) nw[1] = max(nw[1], dp[9] + x * 2LL + y);
        if (k == 8) nw[0] = max(nw[0], dp[8] + x * 2LL + y);
        if (k < 8) nw[k + 2] = max(nw[k + 2], dp[k] + x + y);
      }
    }
    x = vec[i].ret3().first;
    y = vec[i].ret3().second.first;
    long long z = vec[i].ret3().second.second;
    if (z == 0) {
      dp = nw;
      continue;
    }
    for (int k(0), ThkMk(10); k < ThkMk; ++k) {
      if (dp[k] != -1) {
        if (k == 9) nw[2] = max(nw[2], dp[9] + x * 2LL + y + z);
        if (k == 8) nw[1] = max(nw[1], dp[8] + x * 2LL + y + z);
        if (k == 7) nw[0] = max(nw[0], dp[7] + x * 2LL + y + z);
        if (k < 7) nw[k + 3] = max(nw[k + 3], dp[k] + x + y + z);
      }
    }
    dp = nw;
  }
  long long mx = dp[0];
  for (int i(1), ThkMk(10); i < ThkMk; ++i) mx = max(mx, dp[i]);
  cout << mx << '\n';
  return 0;
}
