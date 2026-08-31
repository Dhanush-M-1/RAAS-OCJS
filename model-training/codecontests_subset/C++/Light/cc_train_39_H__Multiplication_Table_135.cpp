#include <bits/stdc++.h>
using namespace std;
int n, p[100005];
void kkk(int x, int k) {
  int cnt = 0;
  while (x) {
    p[++cnt] = x % k;
    x /= k;
  }
  for (int i = cnt; i >= 1; i--) {
    printf("%d", p[i]);
  }
}
int main(void) {
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      kkk(i * j, n);
      printf(" ");
    }
    puts("");
  }
  return 0;
}
