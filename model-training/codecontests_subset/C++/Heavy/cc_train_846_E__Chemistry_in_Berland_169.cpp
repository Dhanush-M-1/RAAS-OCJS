#include <bits/stdc++.h>
using namespace std;
struct Edge {
  int to;
  long long int k;
};
int N;
long long int as[114514];
long long int bs[114514];
vector<Edge> es[114514];
long long int sum;
void dfs(int v, int p, long long int k2) {
  long long int k = 0;
  for (Edge &e : es[v]) {
    int u = e.to;
    if (u == p) {
      k = e.k;
      continue;
    }
    dfs(u, v, e.k);
  }
  if (v == p) return;
  if (as[v] > bs[v]) {
    if (as[v] - bs[v] > sum) return;
    long long int req = (as[v] - bs[v]) * k;
    bs[p] -= req;
    bs[v] = as[v];
  } else {
    long long int cnt = (bs[v] - as[v]) / k2;
    bs[p] += cnt;
    bs[v] -= cnt * k2;
  }
}
int main() {
  scanf("%d", &N);
  for (int i = 0; i < N; i++) {
    scanf("%lld", &bs[i]);
    sum += bs[i];
  }
  for (int i = 0; i < N; i++) {
    scanf("%lld", &as[i]);
  }
  for (int i = 1; i < N; i++) {
    int x;
    long long int k;
    scanf("%d%lld", &x, &k);
    --x;
    es[i].emplace_back(Edge{x, k});
    es[x].emplace_back(Edge{i, 1});
  }
  dfs(0, 0, 0);
  for (int i = 0; i < N; i++) {
    if (as[i] > bs[i]) {
      puts("NO");
      return 0;
    }
  }
  puts("YES");
}
