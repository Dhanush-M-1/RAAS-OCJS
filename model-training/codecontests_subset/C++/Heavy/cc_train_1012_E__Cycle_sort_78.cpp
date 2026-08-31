#include <bits/stdc++.h>
using namespace std;
int A[200005], B[200005], Q[200005];
pair<int, int> P[200005];
vector<int> getcycle(int x) {
  int init = x;
  vector<int> ret;
  do {
    ret.push_back(x);
    x = Q[x];
  } while (x != init);
  return ret;
}
int par[200005], pos[200005];
int root(int a) {
  if (par[a] == a) return a;
  return par[a] = root(par[a]);
}
bool join(int x, int y) {
  int a = root(x), b = root(y);
  if (a == b) return false;
  par[a] = b;
  return true;
}
int main() {
  int n, s;
  scanf("%d%d", &n, &s);
  for (int i = 0; i < n; ++i) {
    scanf("%d", &A[i]);
    B[i] = A[i];
  }
  sort(B, B + n);
  int m = 0;
  for (int i = 0; i < n; ++i) {
    if (B[i] != A[i]) {
      P[m] = {A[i], m};
      pos[m] = i + 1;
      ++m;
    }
  }
  sort(P, P + m);
  vector<pair<int, int>> merges;
  for (int i = 0; i < m; ++i) {
    if (i && P[i].first == P[i - 1].first) {
      merges.emplace_back(P[i].second, P[i - 1].second);
    }
    Q[P[i].second] = i;
  }
  vector<bool> used(m);
  iota(par, par + m, 0);
  int numcycles = 0;
  for (int i = 0; i < m; ++i) {
    if (used[i]) continue;
    ++numcycles;
    auto cyc = getcycle(i);
    for (int i = 0; i < cyc.size(); ++i) {
      used[cyc[i]] = true;
      if (i) join(cyc[i - 1], cyc[i]);
    }
  }
  for (auto merge : merges) {
    if (join(merge.first, merge.second)) {
      swap(Q[merge.first], Q[merge.second]);
      --numcycles;
    }
  }
  if (m > s) {
    printf("-1\n");
    return 0;
  }
  int l = s - m;
  vector<vector<int>> ans;
  if (l > 1 && numcycles > 1) {
    fill(used.begin(), used.end(), 0);
    vector<int> firsts;
    for (int i = 0; i < m && firsts.size() < l; ++i) {
      if (used[i]) continue;
      auto cyc = getcycle(i);
      for (int i = 0; i < cyc.size(); ++i) {
        used[cyc[i]] = true;
      }
      firsts.push_back(i);
    }
    ans.push_back(firsts);
    assert(firsts.size() >= 2);
    int qb = Q[firsts.back()];
    for (int i = firsts.size() - 1; i; --i) {
      Q[firsts[i]] = Q[firsts[i - 1]];
    }
    Q[0] = qb;
  }
  fill(used.begin(), used.end(), 0);
  for (int i = 0; i < m; ++i) {
    if (used[i]) continue;
    auto cyc = getcycle(i);
    for (int i = 0; i < cyc.size(); ++i) {
      used[cyc[i]] = true;
    }
    ans.push_back(cyc);
  }
  printf("%d\n", ans.size());
  for (auto &vec : ans) {
    printf("%d\n", vec.size());
    for (int x : vec) {
      printf("%d ", pos[x]);
    }
    printf("\n");
  }
}
