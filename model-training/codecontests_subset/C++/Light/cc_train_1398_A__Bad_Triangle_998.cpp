#include <bits/stdc++.h>
using namespace std;
const int N = 2005;
const long long M = 1e9 + 7;
const long long inf = 1e18 + 5;
int main() {
  int T;
  scanf("%d", &T);
  while (T--) {
    int n;
    scanf("%d", &n);
    int a[n];
    for (int i = 0; i < n; i++) scanf("%d", &a[i]);
    if (a[0] + a[1] <= a[n - 1]) {
      printf("1 2 %d\n", n);
    } else
      printf("%d\n", -1);
  }
}
