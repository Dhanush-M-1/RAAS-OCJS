#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  int x[101];
  scanf("%d%d", &n, &c);
  for (int i = 0; i < n; i++) {
    scanf("%d", &x[i]);
  }
  int maxm = x[0] - x[1];
  for (int i = 1; i < n - 1; i++) {
    maxm = max(x[i] - x[i + 1], maxm);
  }
  maxm -= c;
  if (maxm > 0)
    printf("%d\n", maxm);
  else
    printf("0\n");
  return 0;
}
