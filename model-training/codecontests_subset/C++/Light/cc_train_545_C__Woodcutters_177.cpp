#include <bits/stdc++.h>
using namespace std;
const int maxn = 100000 + 10;
int pos[maxn], dis[maxn];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d%d", &pos[i], &dis[i]);
  }
  if (n == 1) {
    printf("1\n");
    return 0;
  }
  int ans = 2;
  for (int i = 2; i < n; i++) {
    if (dis[i] < pos[i] - pos[i - 1]) {
      ans++;
      continue;
    }
    if (dis[i] < pos[i + 1] - pos[i]) {
      ans++;
      pos[i] += dis[i];
      continue;
    }
  }
  printf("%d\n", ans);
  return 0;
}
