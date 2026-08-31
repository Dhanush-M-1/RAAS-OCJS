#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100005;
int n, root, Over;
vector<int> P[MAXN];
int main() {
  scanf("%d", &n);
  for (int i = 1, u, v; i < n; i++) {
    scanf("%d%d", &u, &v);
    P[u].push_back(v);
    P[v].push_back(u);
  }
  for (int i = 1; i <= n; i++)
    if (P[i].size() == 2) {
      printf("NO\n");
      return 0;
    }
  printf("YES\n");
}
