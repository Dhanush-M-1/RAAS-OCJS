#include <bits/stdc++.h>
using namespace std;
int ans[1010];
int main() {
  int k;
  scanf("%d", &k);
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      int x = i * j, num = 0;
      while (x) {
        ans[num++] = x % k;
        x /= k;
      }
      for (int ii = num - 1; ii >= 0; ii--) printf("%d", ans[ii]);
      printf(" ");
    }
    printf("\n");
  }
  return 0;
}
