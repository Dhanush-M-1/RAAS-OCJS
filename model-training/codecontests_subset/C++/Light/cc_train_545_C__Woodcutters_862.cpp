#include <bits/stdc++.h>
int main() {
  int tree[100005], h[100005], n, i, cnt;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d %d", &tree[i], &h[i]);
  }
  if (n >= 3) {
    cnt = 2;
    for (i = 1; i < n - 1; i++) {
      if (tree[i] > tree[i - 1] + h[i]) {
        cnt++;
      } else if (tree[i + 1] > tree[i] + h[i]) {
        cnt++;
        tree[i] = tree[i] + h[i];
      }
    }
    printf("%d", cnt);
  } else {
    printf("%d", n);
  }
  return 0;
}
