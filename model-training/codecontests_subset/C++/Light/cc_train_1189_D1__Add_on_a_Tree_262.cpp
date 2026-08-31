#include <bits/stdc++.h>
using namespace std;
int const maxn = 1e5 + 5;
vector<int> p[maxn];
int main() {
  int n;
  scanf("%d", &n);
  int u, v;
  for (int i = 1; i < n; i++) {
    scanf("%d%d", &u, &v);
    p[u].push_back(v);
    p[v].push_back(u);
  }
  bool flag = 1;
  for (int i = 1; i <= n; i++)
    if (p[i].size() == 2) flag = 0;
  if (flag)
    printf("YES\n");
  else
    printf("NO\n");
}
