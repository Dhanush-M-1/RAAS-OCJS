#include <bits/stdc++.h>
using namespace std;
vector<int> adj[3000];
bool visited[3000];
bool incycle[3000];
int find_cycle(int u, int p) {
  if (visited[u]) return u;
  visited[u] = true;
  for (int c : adj[u])
    if (c != p) {
      int x = find_cycle(c, u);
      if (x != -1) {
        incycle[u] = true;
        return x == u ? -1 : x;
      }
    }
  return -1;
}
double compute(int a, int b, int nc) {
  if (b == 0) return 1.0 / (a + 1);
  int c = nc - b;
  return 1.0 / (a + b + c) + (double)(b - 1) / ((a + b + c) * (a + c + 1)) +
         (double)(c - 1) / ((a + b + c) * (a + b + 1));
}
double dfs(int x, int a, int b, int nc) {
  visited[x] = true;
  double ans = compute(a, b, nc);
  for (int c : adj[x])
    if (!visited[c]) {
      int aa = a, bb = b;
      (incycle[x] && incycle[c] ? bb : aa)++;
      ans += dfs(c, aa, bb, nc);
    }
  return ans;
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int a, b;
    scanf("%d %d", &a, &b);
    adj[a].push_back(b);
    adj[b].push_back(a);
  }
  find_cycle(0, -1);
  int nc = count(incycle, incycle + n, true);
  double ans = 0;
  for (int i = 0; i < n; i++) {
    fill_n(visited, n, false);
    ans += dfs(i, 0, 0, nc);
  }
  printf("%.15f\n", ans);
}
