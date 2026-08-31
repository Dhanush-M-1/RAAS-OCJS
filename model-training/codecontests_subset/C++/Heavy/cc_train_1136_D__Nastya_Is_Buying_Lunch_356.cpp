#include <bits/stdc++.h>
using namespace std;
void du(int& d) {
  char t = getchar();
  bool Mark = false;
  for (; t < '0' || t > '9'; t = getchar())
    if (t == '-') Mark = !Mark;
  for (d = 0; t >= '0' && t <= '9'; t = getchar()) d = d * 10 + t - '0';
  if (Mark) d = -d;
}
const int maxn = 1e6 + 100;
int pup[maxn];
int re[maxn];
set<int> Q[maxn];
int main() {
  int n, m;
  du(n);
  du(m);
  int i;
  for (i = 1; i <= n; i++) du(pup[i]);
  int u, v;
  for (i = 1; i <= m; i++) {
    du(u);
    du(v);
    Q[v].insert(u);
  }
  vector<int> sheet;
  for (i = n - 1; i >= 1; i--) {
    bool mark;
    mark = Q[pup[n]].count(pup[i]);
    if (mark) {
      for (auto& v : sheet) {
        mark = mark && Q[v].count(pup[i]);
      }
    }
    if (!mark) sheet.push_back(pup[i]);
  }
  int ans = n - 1 - sheet.size();
  cout << ans;
}
