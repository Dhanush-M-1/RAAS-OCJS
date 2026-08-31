#include <bits/stdc++.h>
using namespace std;
int n, m;
int c[300005], q[300005];
set<int> s[300005];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) {
    int a;
    scanf("%d", &a);
    c[a] = i;
    q[i] = i;
  }
  for (int i = 0; i < m; i++) {
    int a, b;
    scanf("%d%d", &a, &b);
    a = c[a];
    b = c[b];
    s[a].insert(b);
  }
  int ans = 0;
  for (int i = n - 2; i >= 0; i--) {
    if (s[i].find(n - 1) == s[i].end()) continue;
    for (int j = i + 1; j < n - ans; j++) {
      if (s[i].find(q[j]) == s[i].end()) break;
      swap(q[j - 1], q[j]);
    }
    if (q[n - ans - 1] != n - 1) ans++;
  }
  printf("%d\n", ans);
  return 0;
}
