#include <bits/stdc++.h>
using namespace std;
const int N = 110;
const int mod = 1e9 + 7;
int gi() {
  int x = 0, o = 1;
  char ch = getchar();
  while (!isdigit(ch) && ch != '-') ch = getchar();
  if (ch == '-') o = -1, ch = getchar();
  while (isdigit(ch)) x = x * 10 + ch - '0', ch = getchar();
  return x * o;
}
int n, m, f[N][N][2];
bool G[N][N];
vector<int> E[N][N], trs[N][2][N][2];
void inc(int &a, int b) { a = a + b >= mod ? a + b - mod : a + b; }
bool ext(deque<int> &q, deque<int>::iterator it, bool dir) {
  bool fl = 1;
  if (!dir) {
    while (it != q.begin() && fl && int(q.size()) <= n + n) {
      auto pre = prev(it);
      fl &= G[*pre][*it];
      q.insert(q.begin(), E[*pre][*it].begin(), E[*pre][*it].end());
      --it;
    }
  } else {
    while (next(it) != q.end() && fl && int(q.size()) <= n + n) {
      auto nxt = next(it);
      fl &= G[*it][*nxt];
      q.insert(q.end(), E[*it][*nxt].begin(), E[*it][*nxt].end());
      ++it;
    }
  }
  return fl && int(q.size()) <= n + n + 1;
}
int main() {
  cin >> n >> m;
  for (int i = 1, u, v; i <= m; i++) {
    u = gi();
    v = gi();
    G[u][v] = 1;
    int k = gi();
    while (k--) E[u][v].push_back(gi());
  }
  bool fl = 1;
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      if (!E[i][j].empty() && E[i][j].back() == i) {
        deque<int> seq(E[i][j].begin(), E[i][j].end());
        if (ext(seq, --seq.end(), 0)) {
          trs[seq[0]][0][j][0].push_back(int(seq.size()));
        }
      }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++) {
      auto it = find(E[i][j].begin(), E[i][j].end(), i);
      while (it != E[i][j].end() && next(it) != E[i][j].end() && *next(it) != j)
        it = find(next(it), E[i][j].end(), i);
      if (it == E[i][j].end() || next(it) == E[i][j].end()) continue;
      deque<int> seq(E[i][j].begin(), E[i][j].end());
      auto itt = seq.begin() + (it - E[i][j].begin());
      if (ext(seq, itt, 0) && ext(seq, next(itt), 1)) {
        if (!fl) {
          fl = 1;
          cout << int(seq.size()) << '\n';
          for (auto x : seq) cout << x << ' ';
          cout << '\n';
        }
        trs[seq[0]][0][seq.back()][1].push_back(int(seq.size()) - 1);
      }
    }
  if (!fl) cout << 0 << '\n' << '\n';
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      if (G[i][j] && E[i][j].empty()) trs[i][1][j][0].push_back(1);
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      if (!E[i][j].empty() && E[i][j][0] == j) {
        deque<int> seq(E[i][j].begin(), E[i][j].end());
        if (ext(seq, seq.begin(), 1)) {
          trs[i][1][seq.back()][1].push_back(int(seq.size()));
        }
      }
  for (int i = 1; i <= n; i++) f[0][i][0] = 1;
  for (int i = 0; i < n + n; i++)
    for (int u = 1; u <= n; u++)
      for (int p = 0; p < 2; p++)
        if (f[i][u][p])
          for (int v = 1; v <= n; v++)
            for (int q = 0; q < 2; q++)
              for (auto t : trs[u][p][v][q])
                if (i + t <= n + n) inc(f[i + t][v][q], f[i][u][p]);
  for (int i = 1; i <= n + n; i++) {
    int ans = 0;
    for (int u = 1; u <= n; u++) inc(ans, f[i][u][1]);
    cout << ans << '\n';
  }
  return 0;
}
