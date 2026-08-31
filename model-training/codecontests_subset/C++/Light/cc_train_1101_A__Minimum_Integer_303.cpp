#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const int mod = 1000000007;
const int mx = 2000001;
const long long infL = 0xf3f3f3f3f3f3f3f;
const double eps = 1e-9;
const double pi = acos(-1.0);
int main() {
  int q, l, r, d, x1, x2;
  scanf("%d", &q);
  while (q--) {
    scanf("%d", &l), scanf("%d", &r), scanf("%d", &d);
    x1 = d;
    x2 = (r + d) / d * d;
    if (x1 >= l) x1 = x2;
    printf("%d", (int)min(x1, x2)), printf("\n");
  }
  return 0;
}
