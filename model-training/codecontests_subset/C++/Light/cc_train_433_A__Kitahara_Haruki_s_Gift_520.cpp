#include <bits/stdc++.h>
using namespace std;
int cnt[205];
int main() {
  int n, x;
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    scanf("%d", &x);
    cnt[x]++;
  }
  int h = cnt[100];
  int t = cnt[200];
  for (int i = 0; i <= h; ++i) {
    for (int j = 0; j <= t; ++j) {
      int a = h - i;
      int b = t - j;
      if (i + 2 * j == a + 2 * b) {
        printf("YES\n");
        return 0;
      }
    }
  }
  printf("NO\n");
  return 0;
}
