#include <bits/stdc++.h>
using namespace std;
const int N = 100000;
int n;
long long d, acc, last, neg;
int main() {
  scanf("%d%lld", &n, &d);
  acc = 0, last = 0, neg = 0;
  int ans = 0;
  long long x;
  for (int i = 0; i < n; i++) {
    scanf("%lld", &x);
    if (!x) {
      if (acc < 0) {
        acc = d;
        last += d;
        neg = 0;
        ans++;
      } else {
        last = min(last, acc);
      }
    } else {
      acc += x;
      if (x < 0) neg += -x;
      if (acc > d) {
        long long y = acc - d;
        if (y > last) {
          puts("-1");
          return 0;
        } else {
          last -= y;
          acc = d;
        }
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
