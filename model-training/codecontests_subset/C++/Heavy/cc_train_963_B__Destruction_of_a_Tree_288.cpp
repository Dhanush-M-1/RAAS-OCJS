#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const int maxn = 200000 + 10;
const long long mod = 1e9 + 9;
vector<int> gra[maxn];
bool ispos[maxn];
bool dfs(int u, int pre) {
  bool ans = 1;
  int sz = gra[u].size();
  for (int i = 0; i < sz; i++) {
    int v = gra[u][i];
    if (v == pre) continue;
    ispos[v] = dfs(v, u);
    if (ispos[v]) ans ^= 1;
  }
  return ans;
}
void print(int u, int pre) {
  int sz = gra[u].size();
  for (int i = 0; i < sz; i++) {
    int v = gra[u][i];
    if (v == pre) continue;
    if (!ispos[v]) print(v, u);
  }
  printf("%d\n", u);
  for (int i = 0; i < sz; i++) {
    int v = gra[u][i];
    if (v == pre) continue;
    if (ispos[v]) print(v, u);
  }
}
int main() {
  int n, rt;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int u;
    scanf("%d", &u);
    if (!u) {
      rt = i;
    } else {
      gra[u].push_back(i);
      gra[i].push_back(u);
    }
  }
  bool flag = dfs(rt, 0);
  if (flag) {
    printf("YES\n");
    print(rt, 0);
  } else {
    printf("NO\n");
  }
  return 0;
}
