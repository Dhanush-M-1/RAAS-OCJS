#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
int a[maxn], n, s, b[maxn], num[maxn], len;
int ufs[maxn], meme[maxn];
inline int find(int u) {
  if (ufs[u] == u)
    return u;
  else
    return ufs[u] = find(ufs[u]);
}
inline void join(int u, int v, int e) {
  u = find(u), v = find(v);
  if (u == v) return;
  ufs[v] = u;
  meme[u] = e;
}
vector<vector<int> > mema;
vector<pair<int, int> > adj[maxn];
vector<int> curm;
inline void dfs(int u) {
  while (adj[u].size()) {
    int v = adj[u].back().first, id = adj[u].back().second;
    adj[u].pop_back();
    dfs(v);
    curm.push_back(id);
  }
}
int main() {
  cin >> n >> s;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    num[++len] = a[i];
  }
  sort(num + 1, num + len + 1);
  len = unique(num + 1, num + len + 1) - num - 1;
  for (int i = 1; i <= n; i++) {
    a[i] = lower_bound(num + 1, num + len + 1, a[i]) - num;
    b[i] = a[i];
    ufs[i] = i;
  }
  sort(b + 1, b + n + 1);
  int cnt = 0;
  for (int i = 1; i <= n; i++) {
    if (a[i] != b[i]) {
      cnt++;
      join(a[i], b[i], i);
    }
  }
  if (cnt > s) {
    cout << "-1" << endl;
    return 0;
  }
  if (cnt == 0) {
    cout << "0" << endl;
    return 0;
  }
  if (s - cnt > 1) {
    for (int i = 1; i <= len; i++) {
      if (ufs[i] == i && meme[i] != 0) {
        curm.push_back(meme[i]);
        if (curm.size() == s - cnt) break;
      }
    }
    if (curm.size() > 1) {
      mema.push_back(curm);
      int lstv = a[curm.back()];
      for (int i = curm.size() - 1; i >= 1; i--) {
        a[curm[i]] = a[curm[i - 1]];
      }
      a[curm[0]] = lstv;
    }
  }
  for (int i = 1; i <= n; i++) {
    if (a[i] != b[i]) {
      adj[a[i]].push_back(make_pair(b[i], i));
    }
  }
  for (int i = 1; i <= len; i++) {
    if (adj[i].size() != 0) {
      curm.clear();
      dfs(i);
      mema.push_back(curm);
    }
  }
  cout << mema.size() << endl;
  for (int i = 0; i < mema.size(); i++) {
    cout << mema[i].size() << endl;
    for (int j = 0; j < mema[i].size(); j++) {
      printf("%d ", mema[i][j]);
    }
    cout << endl;
  }
  return 0;
}
