#include <bits/stdc++.h>
using namespace std;
const int maxn = 500005;
int a[maxn], num[maxn];
vector<int> v[maxn];
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
  }
  while (m--) {
    int x, y;
    scanf("%d%d", &x, &y);
    v[y].push_back(x);
  }
  for (int i = 0; i < v[a[n]].size(); i++) {
    num[v[a[n]][i]]++;
  }
  int ans = 0;
  for (int i = n - 1; i >= 1; i--) {
    if (num[a[i]] == n - i - ans)
      ans++;
    else {
      for (int j = 0; j < v[a[i]].size(); j++) {
        num[v[a[i]][j]]++;
      }
    }
  }
  printf("%d", ans);
}
