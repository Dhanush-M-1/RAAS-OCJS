#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 7;
int d[N];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1, u, v; i < n; i++) {
    scanf("%d%d", &u, &v);
    d[u]++, d[v]++;
  }
  bool flag = true;
  for (int i = 1; i <= n; i++) {
    if (d[i] == 2) flag = false;
  }
  if (flag)
    printf("YES\n");
  else
    printf("NO\n");
}
