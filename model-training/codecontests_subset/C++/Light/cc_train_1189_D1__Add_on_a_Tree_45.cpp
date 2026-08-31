#include <bits/stdc++.h>
using namespace std;
vector<int> a[100010];
int main() {
  int n, m;
  scanf("%d", &n);
  int x, y;
  for (int i = 0; i < n - 1; i++) {
    scanf("%d%d", &x, &y);
    a[x].push_back(y);
    a[y].push_back(x);
  }
  if (n == 2) {
    printf("YES");
    return 0;
  }
  int f = 1;
  for (int i = 1; i <= n; i++) {
    if (a[i].size() == 2) {
      f = 0;
      break;
    }
  }
  if (f)
    printf("YES");
  else
    printf("NO");
  return 0;
}
