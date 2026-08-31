#include <bits/stdc++.h>
long long int a[1000005];
long long int b[1000005];
int main() {
  long long int n;
  long long int i = 0;
  long long int j = 0;
  long long int k;
  long long int p;
  long long int temp1 = 0;
  long long int temp2 = 0;
  scanf("%lld", &n);
  for (p = 0; p < n; p++) {
    scanf("%lld", &k);
    if (k <= 500000)
      a[i++] = k;
    else if (k > 500000)
      b[j++] = k;
  }
  if (i != 0) {
    temp1 = a[0] - 1;
    for (p = 1; p < i; p++) {
      temp1 += a[p] - a[p - 1];
    }
  }
  if (j != 0) {
    temp2 = 1000000 - b[j - 1];
    for (p = j - 1; p >= 1; p--) {
      temp2 += b[p] - b[p - 1];
    }
  }
  if (temp1 > temp2)
    printf("%lld\n", temp1);
  else
    printf("%lld\n", temp2);
  return 0;
}
