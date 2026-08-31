#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, n, c, arr[105], diff = 0, s;
  scanf("%d %d", &n, &c);
  for (i = 0; i < n; i++) scanf("%d", &arr[i]);
  for (i = 0; i < n - 1; i++) {
    if ((arr[i] - arr[i + 1]) > 0) {
      if ((arr[i] - arr[i + 1]) > diff) {
        diff = arr[i] - arr[i + 1];
        s = i + 1;
      }
    }
  }
  printf("%d", (diff - c > 0 ? diff - c : 0));
  return 0;
}
