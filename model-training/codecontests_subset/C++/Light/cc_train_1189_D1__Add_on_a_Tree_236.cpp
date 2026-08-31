#include <bits/stdc++.h>
using namespace std;
vector<int> v[100005];
int main() {
  int t, q, n, m, x, y, i, j, k;
  scanf("%d", &n);
  for (i = 1; i < n; i++) {
    scanf("%d%d", &x, &y);
    v[x].push_back(y);
    v[y].push_back(x);
  }
  int f = 0;
  for (i = 1; i <= n; i++) {
    if (v[i].size() == 2) {
      f = 1;
      break;
    }
  }
  if (f == 0)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
