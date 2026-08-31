#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, data[105], i;
  scanf("%d%d", &n, &k);
  for (i = 0; i < n; i++) scanf("%d", &data[i]);
  sort(data, data + n);
  for (i = n - 1; i >= 0; i--)
    if (k % data[i] == 0) break;
  printf("%d\n", k / data[i]);
  return 0;
}
