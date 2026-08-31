#include <bits/stdc++.h>
using namespace std;
const int N = 5e3 + 500;
int G[N][N], sum[N][N], n;
char s[20000];
bool valid(int index) {
  int now = index * index;
  for (int i = 1; i + index - 1 <= n; i += index) {
    for (int j = 1; j + index - 1 <= n; j += index) {
      int li = i + index - 1;
      int lj = j + index - 1;
      int ss =
          sum[li][lj] - sum[i - 1][lj] - sum[li][j - 1] + sum[i - 1][j - 1];
      if (ss != 0 && ss != now) return false;
    }
  }
  return true;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%s", s + 1);
    int num;
    for (int j = 1; j <= n / 4; j++) {
      if (s[j] >= 'A' && s[j] <= 'F')
        num = s[j] - 'A' + 10;
      else
        num = s[j] - '0';
      for (int k = (j - 1) * 4 + 4; k >= (j - 1) * 4 + 1; k--) {
        G[i][k] = num % 2;
        num /= 2;
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + G[i][j];
    }
  }
  int ans = 1;
  for (int i = 2; i * i <= n; i++) {
    if (n % i == 0) {
      if (valid(i)) ans = max(ans, i);
      if (i * i != n) {
        if (valid(n / i)) ans = max(ans, n / i);
      }
    }
  }
  if (valid(n)) ans = max(ans, n);
  printf("%d\n", ans);
}
