#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e9 + 7;
const int N = 3e5 + 10;
int flag[N];
set<int> s[N];
int a[N];
int pos[N];
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    pos[a[i]] = i;
  }
  while (m--) {
    int x, y;
    scanf("%d%d", &x, &y);
    if (x == a[n]) continue;
    if (y == a[n]) {
      flag[x] = 1;
    }
    s[x].emplace(y);
  }
  int ans = n;
  for (int i = n - 1; i > 0; i--) {
    if (flag[a[i]]) {
      int cnt = 0;
      for (auto& x : s[a[i]]) {
        if (pos[x] < i) continue;
        if (pos[x] >= ans) continue;
        cnt++;
      }
      if (cnt != ans - i - 1)
        flag[a[i]] = 0;
      else {
        for (int j = i; j < ans; j++) {
          int x = a[j], y = a[j + 1];
          swap(a[j], a[j + 1]);
          swap(pos[x], pos[y]);
        }
        ans--;
      }
    }
  }
  printf("%d\n", n - ans);
  return 0;
}
