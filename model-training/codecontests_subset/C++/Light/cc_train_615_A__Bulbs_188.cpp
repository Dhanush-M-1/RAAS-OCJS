#include <bits/stdc++.h>
using namespace std;
int arr[1010], n, m, k, i, j, in, res;
int main() {
  scanf(" %d %d", &n, &m);
  res = 0;
  for (i = 1; i <= n; i++) {
    scanf(" %d", &k);
    for (j = 1; j <= k; j++) {
      scanf(" %d", &in);
      if (arr[in] == 0) {
        arr[in] = 1;
        res++;
      }
    }
  }
  if (res == m)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
