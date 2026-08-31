#include <bits/stdc++.h>
using namespace std;
const int N = 20;
int k;
int a[N][N];
void out(int x) {
  int dig[10];
  int tot = 0;
  while (x) {
    dig[tot++] = x % k;
    x /= k;
  }
  for (int i = tot - 1; i >= 0; --i) {
    printf("%d", dig[i]);
  }
}
int main() {
  scanf("%d", &k);
  for (int i = 1; i < k; ++i) {
    for (int j = 1; j < k; ++j) {
      a[i][j] = i * j;
    }
  }
  for (int i = 1; i < k; ++i) {
    for (int j = 1; j < k; ++j) {
      out(a[i][j]);
      putchar((j == k - 1) ? '\n' : ' ');
    }
  }
  return 0;
}
