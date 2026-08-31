#include <bits/stdc++.h>
using namespace std;
int a[100001];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i < n; i++) printf("%d ", i);
  printf("\n");
  for (int i = 2; i < n; i++) {
    printf("%d ", i);
    for (int j = 2; j < n; j++) {
      int res = i * j;
      int cnt = 0;
      while (res) {
        a[++cnt] = res % n;
        res /= n;
      }
      for (int ii = cnt; ii >= 1; ii--) printf("%d", a[ii]);
      printf(" ");
    }
    printf("\n");
  }
  return 0;
}
