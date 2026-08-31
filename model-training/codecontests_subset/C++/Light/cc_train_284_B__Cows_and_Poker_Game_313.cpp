#include <bits/stdc++.h>
using namespace std;
inline double sqr(double x) { return x * x; }
int gcd(int a, int b) { return 0 == b ? a : gcd(b, a % b); }
char s[200002];
int main() {
  int f, a, i, res;
  f = a = i = res = 0;
  int n;
  scanf(" %d", &n);
  for (int(j) = (0); (j) < (n); (j)++) {
    scanf(" %c", &s[j]);
    if ('F' == s[j])
      f++;
    else if ('A' == s[j])
      a++;
    else
      i++;
  }
  if (i > 1)
    res = 0;
  else if (i == 1)
    res = 1;
  else
    res = a;
  printf("%d ", res);
  return 0;
}
