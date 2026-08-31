#include <bits/stdc++.h>
using namespace std;
long long n, k;
long long sum, fsum;
long long arr[1000005];
int main(void) {
  scanf("%lld", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &k);
    arr[k] = 1;
  }
  for (int i = 500000; i >= 1; i--) {
    if (arr[i]) {
      sum = i - 1;
      break;
    }
  }
  for (int i = 500001; i <= 1000000; i++) {
    if (arr[i]) {
      fsum = 1000000 - i;
      break;
    }
  }
  if (sum < fsum) sum = fsum;
  printf("%lld", sum);
}
