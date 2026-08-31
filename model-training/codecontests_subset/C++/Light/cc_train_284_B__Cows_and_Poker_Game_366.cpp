#include <bits/stdc++.h>
using namespace std;
long long int gcd(long long int a, long long int b) {
  if (a % b == 0) return b;
  gcd(b, a % b);
}
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  long long int n, t, d = 0, f = 0, d2 = 0;
  char str[200010];
  scanf("%lld", &n);
  scanf("%s", str);
  for (long long int i = 0; i < n; i++) {
    if (str[i] == 'A')
      d++;
    else if (str[i] == 'I')
      d2++;
  }
  if (d2 == 1)
    printf("1");
  else if (d2 > 1)
    printf("0");
  else
    printf("%lld", d);
  printf("\n");
  return 0;
}
