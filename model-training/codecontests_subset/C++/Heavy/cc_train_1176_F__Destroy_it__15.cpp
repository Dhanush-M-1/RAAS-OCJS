#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
const int M = 10;
long long dp[N][M];
long long val[N][4][4], dval[N][4][4];
vector<int> g[4];
void brute(int ind, int cost, int mm, int sz, long long sum, int x, int y,
           int z) {
  if (mm > 0) {
    if (val[ind][cost][sz] < sum) {
      val[ind][cost][sz] = sum;
    }
    if (dval[ind][cost][sz] < sum + mm) {
      dval[ind][cost][sz] = sum + mm;
    }
  }
  for (int c = 1; c <= 3; ++c) {
    if (c + cost > 3) {
      break;
    }
    if (c == 1 && x < g[c].size()) {
      brute(ind, cost + c, max(mm, g[c][x]), sz + 1, sum + g[c][x], x + 1, y,
            z);
    }
    if (c == 2 && y < g[c].size()) {
      brute(ind, cost + c, max(mm, g[c][y]), sz + 1, sum + g[c][y], x, y + 1,
            z);
    }
    if (c == 3 && z < g[c].size()) {
      brute(ind, cost + c, max(mm, g[c][z]), sz + 1, sum + g[c][z], x, y,
            z + 1);
    }
  }
}
void find(int ind) {
  int cost = 0, mm = 0, sz = 0;
  brute(ind, cost, mm, sz, 0, 0, 0, 0);
}
long long solveDp(int ind, int pos, int n) {
  if (ind == n) {
    return 0;
  }
  long long &ret = dp[ind][pos];
  if (ret != -1) {
    return ret;
  }
  ret = solveDp(ind + 1, pos, n);
  for (int cost = 1; cost <= 3; ++cost) {
    for (int size = 1; size <= 3; ++size) {
      if (val[ind][cost][size] == -1) {
        continue;
      }
      int npos = pos + size;
      long long add = val[ind][cost][size];
      if (npos >= 10) {
        npos -= 10;
        add = dval[ind][cost][size];
      }
      ret = max(ret, solveDp(ind + 1, npos, n) + add);
    }
  }
  return ret;
}
void solve() {
  int n;
  scanf("%d", &n);
  memset(dp, -1, sizeof dp);
  memset(val, -1, sizeof(val));
  for (int i = 0; i < n; ++i) {
    priority_queue<int, vector<int>, greater<int> > q[4];
    int sz[4] = {0, 3, 1, 1};
    int k, c, d;
    scanf("%d", &k);
    for (int j = 0; j < k; ++j) {
      scanf("%d%d", &c, &d);
      q[c].push(d);
      if (q[c].size() > sz[c]) {
        q[c].pop();
      }
    }
    for (int j = 1; j <= 3; ++j) {
      g[j].clear();
      while (!q[j].empty()) {
        g[j].push_back(q[j].top());
        q[j].pop();
      }
      sort(g[j].begin(), g[j].end());
      reverse(g[j].begin(), g[j].end());
    }
    find(i);
  }
  printf("%lld\n", solveDp(0, 0, n));
}
int main() { solve(); }
