#include <bits/stdc++.h>
using namespace std;
int n, ma, tot;
int ta;
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &ta);
    ma = max(ma, ta);
    tot += ta;
  }
  ma = max(ma, 2 * tot / n + 1);
  printf("%d\n", ma);
  return 0;
}
