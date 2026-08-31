#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000000007;
template <class T>
typename T::value_type arr_sum(const T &v, int n) {
  typename T::value_type sum = 0;
  for (int i = (0); i < (n); ++i) sum += v[i];
  return sum;
}
struct Sync_stdio {
  Sync_stdio() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
  }
} _sync_stdio;
vector<vector<int>> up;
vector<vector<int>> g;
vector<int> used;
void dfs(int t, int p = 0) {
  used[t] = 1;
  up[t][0] = p;
  for (int i = (1); i < (up[t].size()); ++i) {
    up[t][i] = up[up[t][i - 1]][i - 1];
  }
  for (auto i : g[t]) {
    if (used[i]) {
      continue;
    }
    dfs(i, t);
  }
}
void up_init(vector<int> &pre) {
  int n = pre.size() + 1;
  g.resize(n);
  used.resize(n);
  up.resize(n);
  int l = 1;
  while ((1 << l) <= n) {
    ++l;
  }
  for (auto &i : up) {
    i.resize(l + 1);
  }
  for (int i = (0); i < (n - 1); ++i) {
    g[pre[i] + 1].push_back(i + 1);
  }
  for (int i = (0); i < (n); ++i) {
    if (!used[i]) {
      dfs(i, i);
    }
  }
}
int get_parent(int a, int x) {
  for (int i = (up[a].size() - 1); i > (-1); --i) {
    if (x & (1 << i)) {
      a = up[a][i];
    }
  }
  return a;
}
int main() {
  int n, r, c;
  cin >> n >> r >> c;
  vector<string> v(n);
  for (int __i = 0; __i < (n); ++__i) cin >> v[__i];
  ;
  vector<int> pre(n);
  int j = n - 1;
  int tsum = 0;
  for (int i = (n - 1); i > (-1); --i) {
    while (j >= 0 && tsum <= c) {
      tsum += (i != j) + v[j].size();
      --j;
    }
    if (j >= 0 || tsum > c) {
      ++j;
    }
    pre[i] = j;
    if (j >= 0 || tsum > c) {
      --j;
    }
    if (tsum == v[i].size()) {
      tsum = 0;
    } else {
      tsum -= 1 + v[i].size();
    }
  }
  up_init(pre);
  int maxi = 0;
  int maxc = 0;
  for (int i = (0); i < (n + 1); ++i) {
    int x = get_parent(i, r);
    if (i - x > maxc) {
      maxc = i - x;
      maxi = i;
    }
  }
  vector<string> ans(r);
  j = 0;
  for (int i = (maxi - maxc); i < (maxi); ++i) {
    if (ans[j].size() + v[i].size() + (ans[j].size() != 0) > c) {
      ++j;
    }
    if (ans[j].size() != 0) {
      ans[j] += ' ';
    }
    ans[j] += v[i];
  }
  for (auto i : ans) {
    cout << i << "\n";
  }
}
