#include <bits/stdc++.h>
using namespace std;
int n;
unsigned char *f;
vector<vector<int>> subs;
int i, k;
int main() {
  char dfs_f(int x);
  void dfs_print(int x);
  scanf("%d", &n);
  if (n == 1) {
    printf("YES\n1\n");
    return 0;
  } else if (n % 2 == 0) {
    printf("NO\n");
    return 0;
  }
  f = (unsigned char *)malloc(n + 1);
  subs.resize(n + 1);
  for (i = 0; i < n; ++i) {
    scanf("%d", &k);
    subs[k].push_back(i + 1);
  }
  k = subs[0].front();
  dfs_f(k);
  printf("YES\n");
  dfs_print(k);
  return 0;
}
char dfs_f(int x) {
  f[x] = 0;
  if (subs[x].size() == 0) return 0;
  for (vector<int>::iterator it = subs[x].begin(); it != subs[x].end(); ++it)
    if (dfs_f(*it) == 0) ++f[x];
  f[x] &= 1;
  return f[x];
}
void dfs_print(int x) {
  for (vector<int>::iterator it = subs[x].begin(); it != subs[x].end(); ++it)
    if (f[*it]) dfs_print(*it);
  printf("%d\n", x);
  for (vector<int>::iterator it = subs[x].begin(); it != subs[x].end(); ++it)
    if (!f[*it]) dfs_print(*it);
}
