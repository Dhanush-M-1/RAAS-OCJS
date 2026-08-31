#include <bits/stdc++.h>
using namespace std;
#pragma warning(disable : 4996)
const int N = 1e6 + 6;
vector<int> v[N];
int mn[N], ct[N], mx[N];
int n, k;
void dfs(int node, int h) {
  if (v[node].empty()) {
    ct[node] = 1;
    mn[node] = h - k;
    mx[node] = 1;
    return;
  }
  int x = N, y = 0;
  for (int to : v[node]) {
    dfs(to, h + 1);
    x = min(x, mn[to]);
    y += ct[to];
  }
  for (int to : v[node]) {
    mx[node] = max(mx[node], y - ct[to] + mx[to]);
  }
  if (h - 1 >= x) ct[node] = y;
  mn[node] = x;
}
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 1; i < n; i++) {
    int p;
    scanf("%d", &p);
    v[p - 1].push_back(i);
  }
  dfs(0, 0);
  printf("%d", mx[0]);
  return 0;
}
