#include <bits/stdc++.h>
using namespace std;
int n, m;
int dfn;
vector<int> g[100010];
int intr[100010];
int dep[100010];
int vis[100010];
int uplink[100010];
int st[100010], en[100010];
bool flag;
mt19937 rng(chrono::high_resolution_clock::now().time_since_epoch().count());
inline priority_queue<pair<int, int> > dfs(int x, int TIME) {
  priority_queue<pair<int, int> > temp;
  st[x] = ++dfn;
  en[x] = n;
  vis[x] = TIME;
  for (auto ch : g[x]) {
    if (vis[ch] == TIME) {
      if (en[ch] >= st[x] && st[x] > st[ch])
        temp.push({dep[ch], ch});
      else {
        flag = false;
      }
    } else {
      dep[ch] = dep[x] + 1;
      priority_queue<pair<int, int> > temp1 = dfs(ch, TIME);
      while (!temp1.empty()) {
        if (temp1.top().first < dep[x]) temp.push(temp1.top());
        temp1.pop();
      }
    }
  }
  while (temp.size() > 2) temp.pop();
  if (temp.size() == 1) {
    uplink[x] = temp.top().second;
  } else {
    uplink[x] = -1;
    intr[x] = 0;
  }
  en[x] = dfn;
  return temp;
}
int sum;
inline void dfs1(int x) {
  if (dep[x] == 1) {
    intr[x] = 1;
    sum++;
  } else if (uplink[x] != -1) {
    sum += intr[x] = intr[uplink[x]];
  }
  for (auto ch : g[x]) {
    if (st[ch] > st[x] && en[ch] <= en[x]) {
      dfs1(ch);
    }
  }
}
int N;
inline bool tst(int x) {
  ++N;
  dfn = 0;
  dep[x] = 1;
  flag = true;
  dfs(x, N);
  if (flag) {
    sum = 0;
    dfs1(x);
  }
  return flag;
}
int main() {
  srand((unsigned)time(NULL));
  int TT;
  for (scanf("%d", &TT); TT; TT--) {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; i++) {
      intr[i] = -1;
      g[i].clear();
    }
    for (int i = 1; i <= m; i++) {
      int a, b;
      scanf("%d%d", &a, &b);
      g[a].push_back(b);
    }
    bool found = false;
    if (n <= 100) {
      for (int i = 1; i <= n; i++) {
        if (tst(i)) {
          found = true;
          break;
        }
      }
    } else {
      for (int i = 1; i <= 100; i++) {
        int x = rng() % n + 1;
        if (tst(x)) {
          found = true;
          break;
        }
      }
    }
    if (!found || sum * 5 < n)
      puts("-1");
    else {
      for (int i = 1; i <= n; i++) {
        if (intr[i] == 1) printf("%d ", i);
      }
      puts("");
    }
  }
  return 0;
}
