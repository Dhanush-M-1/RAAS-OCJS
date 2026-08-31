#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    int n;
    cin >> n;
    int a[n];
    for (int i = 0; i < n; i++) {
      scanf("%d", &a[i]);
    }
    if (a[0] + a[1] > a[n - 1]) {
      printf("-1");
      printf("\n");
    } else {
      printf("1");
      printf(" ");
      printf("2");
      printf(" ");
      printf("%d", n);
      printf("\n");
    }
  }
  return 0;
}
