#include <bits/stdc++.h>
using namespace std;
const int N = 2333;
int n, m;
int w[N];
int b[N];
bool vis[N];
int a[N];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &w[i]);
    vis[i] = false;
  }
  int now = 0;
  for (int i = 1; i <= m; i++) {
    scanf("%d", &b[i]);
    if (vis[b[i]]) continue;
    a[now++] = b[i];
    vis[b[i]] = true;
  }
  int tot = 0;
  for (int i = 1; i <= m; i++) {
    int pos = 0;
    while (a[pos] != b[i]) pos++;
    for (int j = pos - 1; j >= 0; j--) {
      tot += w[a[j]];
      swap(a[j], a[j + 1]);
    }
  }
  printf("%d\n", tot);
  return 0;
}
