#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, Max;
  Max = -1;
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; i++) {
    int a;
    scanf("%d", &a);
    if (k % a == 0) Max = max(Max, a);
  }
  printf("%d\n", k / Max);
  return 0;
}
