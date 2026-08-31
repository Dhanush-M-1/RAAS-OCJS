#include <bits/stdc++.h>
int main(int argc, const char* argv[]) {
  int a[101] = {0}, k, n;
  scanf("%d%d", &n, &k);
  int temp = 0;
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    if (k % a[i] == 0) {
      if (a[i] > temp) temp = a[i];
    }
  }
  int ans;
  ans = k / temp;
  printf("%d\n", ans);
  return 0;
}
