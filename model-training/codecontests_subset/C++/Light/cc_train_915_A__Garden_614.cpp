#include <bits/stdc++.h>
int main() {
  int n, k;
  int a[100];
  int res[100];
  int most;
  scanf("%d%d", &n, &k);
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  for (int i = 0; i < n; i++) {
    if (k % a[i] == 0) {
      res[i] = k / a[i];
    } else
      res[i] = 0;
  }
  most = 0;
  for (int i = 0; i < n; i++) {
    if (most == 0) {
      if (res[i] != 0) most = res[i];
    } else {
      if (res[i] < most && res[i] != 0) most = res[i];
    }
  }
  printf("%d", most);
  return 0;
}
