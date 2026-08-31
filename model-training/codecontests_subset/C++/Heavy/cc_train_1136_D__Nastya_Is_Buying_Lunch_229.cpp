#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 10;
const int INF = 0x3f3f3f3f;
void read(int &val) {
  int x = 0;
  int bz = 1;
  char c;
  for (c = getchar(); (c < '0' || c > '9') && c != '-'; c = getchar())
    ;
  if (c == '-') {
    bz = -1;
    c = getchar();
  }
  for (; c >= '0' && c <= '9'; c = getchar()) x = x * 10 + c - 48;
  val = x * bz;
}
vector<int> a, was;
vector<vector<int>> g;
int main() {
  int n, m;
  read(n);
  read(m);
  a.resize(n);
  g.resize(n);
  was.resize(n);
  for (int i = 0; i <= n - 1; i++) {
    read(a[i]);
    a[i]--;
  }
  for (int i = 0; i <= m - 1; i++) {
    int u, v;
    read(u);
    read(v);
    u--;
    v--;
    g[u].push_back(v);
  }
  reverse(a.begin(), a.end());
  for (int i = 0; i <= n - 1; i++) was[i] = 0;
  was[a[0]] = 1;
  int cnt = 1, ans = 0;
  for (int i = 1; i <= n - 1; i++) {
    int cnt2 = 0;
    for (auto it : g[a[i]]) {
      if (was[it]) cnt2++;
    }
    if (cnt == cnt2)
      ans++;
    else {
      was[a[i]] = 1;
      cnt++;
    }
  }
  printf("%d\n", ans);
  return 0;
}
