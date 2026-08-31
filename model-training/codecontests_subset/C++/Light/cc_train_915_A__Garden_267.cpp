#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  int n;
  scanf("%d %d", &n, &k);
  int i;
  int t = 270000000;
  for (i = 0; i < n; i++) {
    int r;
    scanf("%d", &r);
    if (k % r == 0)
      if (k / r < t) t = k / r;
  }
  printf("%d", t);
}
