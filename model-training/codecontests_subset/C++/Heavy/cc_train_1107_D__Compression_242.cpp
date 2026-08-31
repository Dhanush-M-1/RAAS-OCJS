#include <bits/stdc++.h>
using namespace std;
using LL = long long;
using PII = pair<int, int>;
const int N = 5210;
char s[N][N / 4];
int sum[N][N];
int n;
bool check(int x) {
  int y = n / x;
  int S = x * x;
  for (int i = 1; i <= y; i++)
    for (int j = 1; j <= y; j++) {
      int p = i * x, q = j * x;
      int p2 = p - x, q2 = q - x;
      int s = sum[p][q] + sum[p2][q2] - sum[p2][q] - sum[p][q2];
      if (s != S && s != 0) {
        return false;
      }
    }
  return true;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%s", s[i] + 1);
  for (int i = 1; i <= n; i++) {
    int m = n / 4;
    for (int j = 1; j <= m; j++) {
      int t;
      if (s[i][j] <= '9')
        t = s[i][j] - '0';
      else
        t = 10 + s[i][j] - 'A';
      int k = (j - 1) * 4;
      sum[i][k + 1] = !!(t & 8);
      sum[i][k + 2] = !!(t & 4);
      sum[i][k + 3] = !!(t & 2);
      sum[i][k + 4] = !!(t & 1);
    }
  }
  for (int i = 1; i <= n; i++) {
    int t = 0;
    for (int j = 1; j <= n; j++) {
      t += sum[i][j];
      sum[i][j] = sum[i - 1][j] + t;
    }
  }
  for (int i = n; i >= 1; i--)
    if (n % i == 0) {
      if (check(i)) {
        printf("%d\n", i);
        break;
      }
    }
  return 0;
}
