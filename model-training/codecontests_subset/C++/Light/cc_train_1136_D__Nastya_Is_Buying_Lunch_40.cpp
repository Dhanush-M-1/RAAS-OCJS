#include <bits/stdc++.h>
using namespace std;
int a[300004];
int num[300004];
vector<int> v[300004];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i]);
  }
  int x, y;
  while (m--) {
    scanf("%d%d", &x, &y);
    v[y].push_back(x);
  }
  memset(num, 0, sizeof(num));
  for (int i = 0; i < v[a[n]].size(); ++i) {
    num[v[a[n]][i]]++;
  }
  int ans = 0;
  for (int i = n - 1; i >= 1; --i) {
    if (num[a[i]] == n - ans - i)
      ans++;
    else {
      for (int j = 0; j < v[a[i]].size(); ++j) {
        num[v[a[i]][j]]++;
      }
    }
  }
  printf("%d\n", ans);
}
