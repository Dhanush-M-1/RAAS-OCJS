#include <bits/stdc++.h>
using namespace std;
int N;
vector<int> G[200000];
bool dpA[200000], dpB[200000];
void dfs(int x, int p) {
  for (int t : G[x])
    if (t != p) dfs(t, x);
  int a_only = 0, both = 0;
  for (int t : G[x])
    if (t != p) {
      bool a = dpA[t], b = dpB[t];
      if (!a && !b) return;
      if (a && !b) a_only++;
      if (a && b) both++;
    }
  if ((a_only % 2 == 0) || (both > 0)) {
    dpA[x] = true;
  }
  if ((a_only % 2 == 1) || (both > 0)) {
    dpB[x] = true;
  }
}
vector<int> perm;
void restore(int x, int p, bool par) {
  vector<int> a_only, both, b_only;
  for (int t : G[x])
    if (t != p) {
      bool a = dpA[t], b = dpB[t];
      assert(a || b);
      if (a && !b) a_only.push_back(t);
      if (a && b) both.push_back(t);
      if (!a && b) b_only.push_back(t);
    }
  for (int i = 0; i < (both.size()); i++)
    if (i != 0) restore(both[i], x, true);
  for (int v : b_only) restore(v, x, true);
  if ((a_only.size() + par) % 2 == 0) {
    if (both.size() > 0) restore(both[0], x, true);
  }
  perm.push_back(x);
  for (int v : a_only) restore(v, x, false);
  if ((a_only.size() + par) % 2 != 0) {
    assert(both.size() > 0);
    restore(both[0], x, false);
  }
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> N;
  for (int i = 0; i < (N); i++) {
    int p;
    cin >> p;
    p--;
    if (p != -1) G[i].push_back(p), G[p].push_back(i);
  }
  dfs(0, -1);
  if (dpA[0]) {
    cout << "YES\n";
    restore(0, -1, false);
    assert(perm.size() == N);
    for (int i = 0; i < (N); i++) cout << perm[i] + 1 << "\n";
  } else {
    cout << "NO\n";
  }
  return 0;
}
