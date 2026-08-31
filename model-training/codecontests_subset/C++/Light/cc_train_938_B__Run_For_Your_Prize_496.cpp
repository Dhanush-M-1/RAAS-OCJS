#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6;
int main() {
  int n;
  scanf("%d", &n);
  int maximum = -maxn, m;
  while (n--) {
    scanf("%d", &m);
    maximum = max(maximum, min(m - 1, maxn - m));
  }
  printf("%d\n", maximum);
  return 0;
}
