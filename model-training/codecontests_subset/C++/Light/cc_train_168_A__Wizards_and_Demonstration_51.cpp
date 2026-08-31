#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c;
  scanf("%lld %lld %lld", &a, &b, &c);
  for (long long i = 0;; i++) {
    long long val = b + i;
    long long t = (100 * val) / a;
    if (t >= c) {
      cout << i << endl;
      return 0;
    }
  }
}
