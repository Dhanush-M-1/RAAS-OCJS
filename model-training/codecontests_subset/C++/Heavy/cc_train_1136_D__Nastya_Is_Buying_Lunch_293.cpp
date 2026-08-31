#include <bits/stdc++.h>
using namespace std;
int p[300010];
set<int> s[300010];
int no[300010];
int cnt = 0;
int main() {
  int n, m;
  int na = 0;
  int total = 0;
  scanf("%d%d", &n, &m);
  int i, j, k;
  for (i = 0; i < n; i++) {
    scanf("%d", p + i);
  }
  na = p[n - 1];
  for (i = 0; i < m; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    s[u].insert(v);
  }
  for (i = n - 2; i >= 0; i--) {
    if (s[p[i]].find(na) != s[p[i]].end()) {
      for (j = 0; j < cnt; j++) {
        if (s[p[i]].find(no[j]) == s[p[i]].end()) {
          break;
        }
      }
      if (j >= cnt) {
        total++;
      } else {
        no[cnt++] = p[i];
      }
    } else {
      no[cnt++] = p[i];
    }
  }
  printf("%d\n", total);
}
