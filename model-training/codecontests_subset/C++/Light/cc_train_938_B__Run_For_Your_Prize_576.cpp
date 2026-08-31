#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i;
  int a[100005];
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
  }
  sort(a + 1, a + 1 + n);
  int time1 = 0, time2 = 1000000;
  for (i = 1; i <= n; i++) {
    if (a[i] <= 500000) {
      time1 = a[i];
    }
  }
  for (i = n; i >= 1; i--) {
    if (a[i] > 500000) {
      time2 = a[i];
    }
  }
  time1 = time1 - 1;
  time2 = 1000000 - time2;
  printf("%d\n", max(time1, time2));
  return 0;
}
