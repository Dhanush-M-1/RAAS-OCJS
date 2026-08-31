#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
const int M = 2e5 + 5;
int n, m;
long long h[N];
long long ans[N];
struct Edge {
  int num;
  int next;
} edge[M];
int tot, last[N];
int du[N];
int sg[N];
queue<int> L;
int node[N], cnt;
int mem[N];
void Add(int i, int j) {
  tot++;
  edge[tot].num = j;
  edge[tot].next = last[i];
  last[i] = tot;
}
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%lld", &h[i]);
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    Add(u, v);
    du[v]++;
  }
  for (int i = 1; i <= n; i++)
    if (du[i] == 0) {
      L.push(i);
      node[++cnt] = i;
    }
  while (!L.empty()) {
    int u = L.front();
    L.pop();
    for (int k = last[u]; k != 0; k = edge[k].next) {
      int v = edge[k].num;
      du[v]--;
      if (du[v] == 0) {
        L.push(v);
        node[++cnt] = v;
      }
    }
  }
  for (int i = n; i >= 1; i--) {
    int u = node[i];
    for (int k = last[u]; k != 0; k = edge[k].next) {
      int v = edge[k].num;
      mem[sg[v]] = i;
    }
    while (mem[sg[u]] == i) ++sg[u];
  }
  for (int i = 1; i <= n; i++) ans[sg[i]] ^= h[i];
  for (int i = n; i >= 0; i--)
    if (ans[i] != 0) {
      printf("WIN\n");
      for (int j = 1; j <= n; j++) {
        if (sg[j] != i) continue;
        if ((h[j] ^ ans[i]) >= h[j]) continue;
        h[j] = h[j] ^ ans[i];
        for (int k = last[j]; k != 0; k = edge[k].next) {
          int v = edge[k].num;
          h[v] ^= ans[sg[v]];
          ans[sg[v]] = 0;
        }
        break;
      }
      for (int j = 1; j <= n; j++) printf("%lld ", h[j]);
      return 0;
    }
  printf("LOSE");
}
