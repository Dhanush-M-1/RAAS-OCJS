#include <bits/stdc++.h>
using namespace std;
int sum[5220][5220];
int m;
vector<int> d;
bool work(int p) {
  int b = m / p, ans;
  for (int i = 1; i <= b; ++i) {
    for (int j = 1; j <= b; ++j) {
      ans = sum[i * p][j * p] - sum[(i - 1) * p][j * p] -
            sum[i * p][(j - 1) * p] + sum[(i - 1) * p][(j - 1) * p];
      if (ans && ans != p * p) return 0;
    }
  }
  return 1;
}
void show() {
  for (int i = 1; i <= m; ++i) {
    for (int j = 1; j <= m; ++j) {
      printf("%d%c", sum[i][j], j == m ? '\n' : ' ');
    }
  }
}
int main() {
  int n, x, i, j, k, w;
  scanf("%d", &n);
  m = n;
  for (i = 1; i <= n; ++i) {
    for (j = 1; j <= (n >> 2); ++j) {
      scanf("%1x", &x);
      for (k = j << 2, w = 1; w <= 4; --k, ++w) {
        sum[i][k] = x & 1, x >>= 1;
      }
    }
  }
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= n; ++j) {
      sum[i][j] += sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
    }
  }
  for (i = 2; i * i <= n; ++i) {
    if (n % i == 0) {
      d.push_back(i);
      while (n % i == 0) n /= i;
    }
  }
  if (n > 1) d.push_back(n);
  int ans = 1;
  for (int p : d) {
    while (m % (ans * p) == 0 && work(ans * p)) ans *= p;
  }
  printf("%d\n", ans);
}
