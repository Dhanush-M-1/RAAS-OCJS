#include <bits/stdc++.h>
using namespace std;
long long q;
int main() {
  scanf("%lld", &q);
  long long x = q;
  int cnt = 0;
  long long num = 1;
  for (long long i = 2; q > 1;) {
    while (q % i == 0) {
      q /= i;
      if (cnt < 2) num *= i;
      cnt++;
    }
    i++;
    if (i * i > q) i = q;
  }
  if (cnt == 0 || cnt == 1) {
    printf("1\n0\n");
  } else if (cnt > 2) {
    printf("%d\n%lld\n", 1, num);
  } else {
    printf("2\n");
  }
  return 0;
}
