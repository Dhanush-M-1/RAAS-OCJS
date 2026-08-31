#include <bits/stdc++.h>
using namespace std;
int cnt[100005];
int main() {
  int n;
  scanf("%d", &n);
  if (n == 2) {
    printf("YES\n");
    return 0;
  }
  if (n == 3) {
    printf("NO\n");
    return 0;
  }
  for (int i = 0; i < n - 1; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    cnt[u]++;
    cnt[v]++;
  }
  for (int i = 1; i <= n; i++) {
    if (cnt[i] == 2) {
      printf("NO\n");
      return 0;
    }
  }
  printf("YES\n");
  return 0;
}
