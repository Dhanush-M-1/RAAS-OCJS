#include <bits/stdc++.h>
using namespace std;
int pos[1000000 + 5];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%d", &pos[i]);
  int k = lower_bound(pos, pos + n, 500000) - pos;
  if (k == n)
    printf("%d\n", pos[n - 1] - 1);
  else if (1000000 - pos[k] == 500000)
    printf("499999\n");
  else
    printf("%d\n", max(pos[k - 1] - 1, 1000000 - pos[k]));
  return 0;
}
