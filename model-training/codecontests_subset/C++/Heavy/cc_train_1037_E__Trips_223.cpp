#include <bits/stdc++.h>
using namespace std;
const int N = 200010, M = 400010, mod = 1e9 + 7;
int n, m, k;
int h[N], e[M], ne[M], idx;
int a[N], b[N], ans[N];
int ind[N], oud[N], cnt;
bool stn[N], stm[M];
struct Edge {
  int a, b;
} edge[M];
void add(int a, int b) { e[idx] = b, ne[idx] = h[a], h[a] = idx++; }
queue<int> q;
void delet_node() {
  while (!q.empty()) {
    int t = q.front();
    q.pop();
    for (int i = h[t]; ~i; i = ne[i]) {
      if (stm[i]) continue;
      int j = e[i];
      ind[j]--;
      if (ind[j] < k && !stn[j]) {
        q.push(j), stn[j] = 1, cnt--;
      }
    }
  }
}
void topsort() {
  for (int i = 1; i <= n; i++) {
    if (ind[i] < k) q.push(i), cnt--, stn[i] = 1;
  }
  delet_node();
  for (int i = m; i >= 1; i--) {
    ans[i] = cnt;
    int a = edge[i].a, b = edge[i].b;
    if (!stn[a] && !stn[b]) ind[a]--, ind[b]--;
    stm[--idx] = 1, stm[--idx] = 1;
    if (ind[a] < k && !stn[a]) q.push(a), stn[a] = 1, cnt--;
    if (ind[b] < k && !stn[b]) q.push(b), stn[b] = 1, cnt--;
    delet_node();
  }
  for (int i = 1; i <= m; i++) cout << ans[i] << endl;
}
int main() {
  memset(h, -1, sizeof h);
  scanf("%d%d%d", &n, &m, &k);
  cnt = n;
  for (int i = 1; i <= m; i++) {
    int a, b;
    scanf("%d%d", &a, &b);
    edge[i] = {a, b};
    add(a, b), add(b, a);
    ind[a]++, ind[b]++;
  }
  topsort();
}
