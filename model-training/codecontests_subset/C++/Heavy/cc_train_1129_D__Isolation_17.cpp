#include <bits/stdc++.h>
using namespace std;
const int SIZE = 500;
int n, k;
vector<int> dp;
vector<int> pos;
vector<int> offset;
vector<vector<int>> sum;
const int MOD = 998244353;
int plusM(int lhs, int rhs) {
  int res = lhs + rhs;
  return res >= MOD ? res - MOD : res;
}
int minusM(int lhs, int rhs) {
  return lhs >= rhs ? lhs - rhs : lhs + MOD - rhs;
}
void inc(int bid, int a, int b) {
  int l = bid * SIZE, r = (bid + 1) * SIZE;
  if (a <= l && r <= b) {
    offset[bid]--;
  } else {
    int lb = max(l, a);
    int ub = min(r, b);
    for (int i = lb; i < ub; i++) {
      sum[bid][pos[i]] = minusM(sum[bid][pos[i]], dp[i]);
      pos[i]++;
    }
  }
}
void dec(int bid, int a, int b) {
  int l = bid * SIZE, r = (bid + 1) * SIZE;
  if (a <= l && r <= b) {
    offset[bid]++;
  } else {
    int lb = max(l, a);
    int ub = min(r, b);
    for (int i = lb; i < ub; i++) {
      sum[bid][pos[i] - 1] = plusM(sum[bid][pos[i] - 1], dp[i]);
      pos[i]--;
    }
  }
}
int calc(int bid) {
  int pos = offset[bid] + k;
  return sum[bid][min(pos, (int)sum[bid].size() - 1)];
}
void makeBlock(int bid) {
  sum[bid].resize(2 * n + 4);
  offset[bid] = n + 1;
  int l = bid * SIZE, r = (bid + 1) * SIZE;
  for (int i = l; i < r; i++) {
    pos[i] += offset[bid];
    sum[bid][pos[i]] = plusM(sum[bid][pos[i]], dp[i]);
  }
  for (int i = 1; i < sum[bid].size(); i++) {
    sum[bid][i] = plusM(sum[bid][i], sum[bid][i - 1]);
  }
}
int main() {
  cin >> n >> k;
  vector<int> a(n);
  for (int i = 0; i < n; i++) cin >> a[i], a[i]--;
  dp.resize(n + 1);
  pos.resize(n);
  int B = n / SIZE + 1;
  offset.resize(B);
  sum.resize(B);
  vector<vector<int>> prev(n, vector<int>(2, -1));
  dp[0] = 1;
  pos[0] = 0;
  for (int i = 1; i <= n; i++) {
    int bid = i / SIZE;
    int sz = prev[a[i - 1]].size();
    int pre2 = prev[a[i - 1]][sz - 2];
    int pre1 = prev[a[i - 1]][sz - 1];
    for (int j = 0; j < bid; j++) dec(j, pre2 + 1, pre1 + 1);
    for (int j = 0; j < bid; j++) inc(j, pre1 + 1, i);
    int l = max(bid * SIZE, pre2 + 1);
    int r = min(i, pre1 + 1);
    for (int j = l; j < r; j++) pos[j]--;
    l = max(bid * SIZE, pre1 + 1);
    r = i;
    for (int j = l; j < r; j++) pos[j]++;
    int sum = 0;
    for (int j = 0; j < bid; j++) sum = plusM(sum, calc(j));
    for (int j = bid * SIZE; j < i; j++)
      if (pos[j] <= k) sum = plusM(sum, dp[j]);
    dp[i] = sum;
    prev[a[i - 1]].push_back(i - 1);
    if ((i + 1) % SIZE == 0) {
      makeBlock(bid);
    }
  }
  cout << dp[n] << endl;
  return 0;
}
