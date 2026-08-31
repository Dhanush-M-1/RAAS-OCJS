#include <bits/stdc++.h>
using namespace std;
long long n;
int main() {
  long long i, j, k;
  long long pri[4];
  while (cin >> n) {
    long long m = n;
    k = 0;
    for (i = 2; i * i <= n; i++) {
      if ((n % i) == 0) {
        while ((n % i) == 0) {
          n /= i;
          k++;
          pri[k] = i;
          if (k > 2) break;
        }
      }
      if (k > 2) break;
    }
    if (n > 1) {
      k++;
      pri[k] = n;
    }
    if (k <= 1) {
      printf("1\n0\n");
    } else if (k > 2) {
      printf("1\n");
      cout << (pri[1] * pri[2]) << endl;
    } else
      printf("2\n");
  }
  return 0;
}
