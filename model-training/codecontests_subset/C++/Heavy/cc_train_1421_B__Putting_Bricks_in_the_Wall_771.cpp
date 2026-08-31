#include <bits/stdc++.h>
using namespace std;
const int M = (int)2e2;
const int N = (int)1e5;
const double eps = 1e-9;
const int inf = 0x3f3f3f3f;
const long long mod = (long long)1e9 + 7;
char s[M + 5][M + 5];
void work() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%s", s[i] + 1);
  char ch[4];
  ch[0] = s[1][2], ch[1] = s[2][1];
  ch[2] = s[n][n - 1], ch[3] = s[n - 1][n];
  if (ch[0] == '0' && ch[1] == '0' && ch[2] == '0' && ch[3] == '0')
    printf("%d\n%d %d\n%d %d\n", 2, 1, 2, 2, 1);
  if (ch[0] == '0' && ch[1] == '0' && ch[2] == '0' && ch[3] == '1')
    printf("%d\n%d %d\n", 1, n, n - 1);
  if (ch[0] == '0' && ch[1] == '0' && ch[2] == '1' && ch[3] == '0')
    printf("%d\n%d %d\n", 1, n - 1, n);
  if (ch[0] == '0' && ch[1] == '0' && ch[2] == '1' && ch[3] == '1')
    printf("%d\n", 0);
  if (ch[0] == '0' && ch[1] == '1' && ch[2] == '0' && ch[3] == '0')
    printf("%d\n%d %d\n", 1, 1, 2);
  if (ch[0] == '0' && ch[1] == '1' && ch[2] == '0' && ch[3] == '1')
    printf("%d\n%d %d\n%d %d\n", 2, 1, 2, n - 1, n);
  if (ch[0] == '0' && ch[1] == '1' && ch[2] == '1' && ch[3] == '0')
    printf("%d\n%d %d\n%d %d\n", 2, 1, 2, n, n - 1);
  if (ch[0] == '0' && ch[1] == '1' && ch[2] == '1' && ch[3] == '1')
    printf("%d\n%d %d\n", 1, 2, 1);
  if (ch[0] == '1' && ch[1] == '0' && ch[2] == '0' && ch[3] == '0')
    printf("%d\n%d %d\n", 1, 2, 1);
  if (ch[0] == '1' && ch[1] == '0' && ch[2] == '0' && ch[3] == '1')
    printf("%d\n%d %d\n%d %d\n", 2, 1, 2, n, n - 1);
  if (ch[0] == '1' && ch[1] == '0' && ch[2] == '1' && ch[3] == '0')
    printf("%d\n%d %d\n%d %d\n", 2, 1, 2, n - 1, n);
  if (ch[0] == '1' && ch[1] == '0' && ch[2] == '1' && ch[3] == '1')
    printf("%d\n%d %d\n", 1, 1, 2);
  if (ch[0] == '1' && ch[1] == '1' && ch[2] == '0' && ch[3] == '0')
    printf("%d\n", 0);
  if (ch[0] == '1' && ch[1] == '1' && ch[2] == '0' && ch[3] == '1')
    printf("%d\n%d %d\n", 1, n - 1, n);
  if (ch[0] == '1' && ch[1] == '1' && ch[2] == '1' && ch[3] == '0')
    printf("%d\n%d %d\n", 1, n, n - 1);
  if (ch[0] == '1' && ch[1] == '1' && ch[2] == '1' && ch[3] == '1')
    printf("%d\n%d %d\n%d %d\n", 2, 1, 2, 2, 1);
}
int main() {
  int T;
  scanf("%d", &T);
  while (T--) work();
  return 0;
}
