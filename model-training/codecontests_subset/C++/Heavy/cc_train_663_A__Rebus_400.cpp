#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
long long powmod(long long a, long long b) {
  long long res = 1;
  a %= mod;
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
char op, s[10];
int adfasdfsa, asdfasfda, n, m, np[110], nm[110], cr[110];
int main() {
  op = '+';
  while (1) {
    if (op == '+')
      adfasdfsa++, cr[m] = 0;
    else
      asdfasfda++, cr[m] = 1;
    m++;
    scanf("%s", s);
    scanf("%s", s);
    op = s[0];
    if (op == '=') break;
  }
  scanf("%d", &n);
  if (adfasdfsa - asdfasfda * n > n || adfasdfsa * n - asdfasfda < n) {
    puts("Impossible");
    return 0;
  }
  puts("Possible");
  for (int i = 0; i < adfasdfsa; i++) np[i] = 1;
  for (int i = 0; i < asdfasfda; i++) nm[i] = n;
  int c = n - (adfasdfsa - asdfasfda * n);
  for (int i = 0; i < adfasdfsa; i++) {
    int delta = min(c, n - np[i]);
    np[i] += delta;
    c -= delta;
  }
  for (int i = 0; i < asdfasfda; i++) {
    int delta = min(c, nm[i] - 1);
    nm[i] -= delta;
    c -= delta;
  }
  int vp = 0, vm = 0;
  for (int i = 0; i < m; i++) {
    if (cr[i] == 0)
      printf("%d ", np[vp++]);
    else
      printf("%d ", nm[vm++]);
    if (i == m - 1)
      printf("= ");
    else if (cr[i + 1] == 0)
      printf("+ ");
    else
      printf("- ");
  }
  printf("%d\n", n);
}
