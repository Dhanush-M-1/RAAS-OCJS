#include <bits/stdc++.h>
using namespace std;
int n, i, k[100] = {0};
int x[100], c;
int d, ans = 0;
int main() {
  scanf("%d", &n);
  scanf("%d", &c);
  for (i = 0; i < n; i++) {
    scanf("%d", &x[i]);
  }
  for (i = 0; i < n; i++) {
    k[i] = x[i] - x[i + 1];
  }
  for (i = 0; i < n - 1; i++) {
    ans = max(ans, k[i]);
  }
  if (ans - c < 0) {
    printf("0");
  } else {
    printf("%d", ans - c);
  }
  return 0;
}
