#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
int n, m, fl[N];
int vis[N], op[N];
int S[N], dep[N];
vector<int> e[N];
void dfs_JUD(int x) {
  ++op[x];
  if (op[x] > 1) return;
  vis[x] = 1;
  for (auto i : e[x])
    if (!vis[i]) dfs_JUD(i);
  vis[x] = 0;
}
bool JUD(int x) {
  for (int i = (int)(1); i <= (int)(n); i++) vis[i] = op[i] = 0;
  dfs_JUD(x);
  for (int i = (int)(1); i <= (int)(n); i++)
    if (op[i] != 1) return 0;
  return 1;
}
void jud_1(int x) {
  vis[x] = 1;
  op[x] = 0;
  for (auto i : e[x])
    if (!vis[i]) {
      dep[i] = dep[x] + 1;
      jud_1(i);
      if (dep[op[i]] < dep[op[x]]) op[x] = op[i];
      S[x] += S[i];
    } else {
      S[x]++, S[i]--;
      if (dep[i] < dep[op[x]]) op[x] = i;
    }
  vis[x] = 0;
}
void jud_2(int x) {
  vis[x] = 1;
  if (S[x] == 1) fl[x] |= fl[op[x]];
  for (auto i : e[x])
    if (!vis[i]) jud_2(i);
  vis[x] = 0;
}
int rnd() {
  int x = 0;
  for (int i = (int)(1); i <= (int)(9); i++) x = x * 10 + rand() % 10;
  return x;
}
void solve() {
  scanf("%d%d", &n, &m);
  for (int i = (int)(1); i <= (int)(n); i++) e[i].resize(0);
  for (int i = (int)(1); i <= (int)(m); i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    e[x].push_back(y);
  }
  for (int i = (int)(1); i <= (int)(n); i++) fl[i] = 0;
  int p = -1;
  for (int i = (int)(1); i <= (int)(200); i++) {
    int x = rnd() % n + 1;
    if (JUD(x)) {
      p = x;
      break;
    }
  }
  if (p == -1) {
    cout << -1 << endl;
    return;
  }
  fl[p] = 1;
  dep[0] = 1 << 30;
  for (int i = (int)(1); i <= (int)(n); i++) vis[i] = op[i] = S[i] = 0;
  jud_1(p);
  jud_2(p);
  int sum = 0;
  for (int i = (int)(1); i <= (int)(n); i++) sum += fl[i];
  if (sum * 5 < n)
    cout << -1 << endl;
  else {
    for (int i = (int)(1); i <= (int)(n); i++)
      if (fl[i]) cout << i << ' ';
    cout << endl;
  }
}
int main() {
  srand(time(NULL));
  int T;
  scanf("%d", &T);
  while (T--) solve();
}
