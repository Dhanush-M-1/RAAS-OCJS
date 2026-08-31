#include <bits/stdc++.h>
using namespace std;
int k;
int zh(int a) {
  int ans = 0, num = 0, ans2[1005] = {0};
  while (a > 0) {
    ans2[++num] = a % k;
    a /= k;
  }
  for (int i = num; i >= 1; i--) ans = ans * 10 + ans2[i];
  return ans;
}
int main() {
  scanf("%d", &k);
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) printf("%d ", zh(i * j));
    printf("\n");
  }
  return 0;
}
