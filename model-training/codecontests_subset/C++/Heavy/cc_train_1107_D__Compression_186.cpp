#include <bits/stdc++.h>
#pragma G++ optimize(2)
using namespace std;
const int N = 5205;
int n, sum[N][N], c[N], cnt;
bool a[N][N];
void rd(int i, int st) {
  char in = 0;
  int x;
  while (!(('0' <= in && in <= '9') || ('A' <= in && in <= 'F')))
    scanf("%c", &in);
  if ('0' <= in && in <= '9') x = in - '0';
  if ('A' <= in && in <= 'F') x = in - 'A' + 10;
  for (int j = st + 3; j >= st; j--) {
    a[i][j] = x & 1;
    x >>= 1;
  }
}
bool check(int x) {
  int z = x * x;
  for (int i = x; i <= n; i += x)
    for (int j = x; j <= n; j += x) {
      int s = sum[i][j] + sum[i - x][j - x] - sum[i][j - x] - sum[i - x][j];
      if (s != 0 && s != z) return 0;
    }
  return 1;
}
int FJ() {
  for (int i = n; i >= 2; i--)
    if (n % i == 0)
      if (check(i)) return i;
  return 1;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j += 4) rd(i, j);
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      sum[i][j] = a[i][j] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
  printf("%d", FJ());
  return 0;
}
