#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
int n, m, k, sum;
int x[N], y[N];
vector<int> Edge[N];
int del[N], deg[N];
int ans[N];
inline int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
queue<int> Q;
inline void Topsort(int Start) {
  if (del[Start] || deg[Start] >= k) return;
  while (!Q.empty()) Q.pop();
  Q.push(Start);
  del[Start] = 1, --sum;
  while (!Q.empty()) {
    int x = Q.front();
    Q.pop();
    for (vector<int>::iterator it = Edge[x].begin(); it != Edge[x].end();
         ++it) {
      int v = *it;
      if (del[v]) continue;
      --deg[v];
      if (deg[v] < k) del[v] = 1, --sum, Q.push(v);
    }
  }
}
int main() {
  n = read(), m = read(), k = read();
  for (int i = 1; i <= m; ++i) {
    x[i] = read(), y[i] = read();
    Edge[x[i]].push_back(y[i]), ++deg[x[i]];
    Edge[y[i]].push_back(x[i]), ++deg[y[i]];
  }
  sum = n;
  for (int i = 1; i <= n; ++i) Topsort(i);
  ans[m] = sum;
  for (int i = m; i >= 2; --i) {
    Edge[x[i]].pop_back();
    if (!del[y[i]]) --deg[x[i]];
    Edge[y[i]].pop_back();
    if (!del[x[i]]) --deg[y[i]];
    Topsort(x[i]), Topsort(y[i]);
    ans[i - 1] = sum;
  }
  for (int i = 1; i <= m; ++i) printf("%d\n", ans[i]);
  return 0;
}
