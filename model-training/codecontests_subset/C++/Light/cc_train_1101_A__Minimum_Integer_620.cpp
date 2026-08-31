#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n;
  scanf("%lld", &n);
  long long int l, r, a, i, j;
  int flag = 0;
  for (i = 0; i < n; i++) {
    long long int k;
    scanf("%lld %lld %lld", &l, &r, &a);
    if (l > a)
      printf("%lld\n", a);
    else
      printf("%lld\n", r + (a - r % a));
  }
}
