#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  scanf("%d", &q);
  for (int i = 0; i < q; i++) {
    int l, r, d;
    scanf("%d %d %d", &l, &r, &d);
    if ((double)l / d > 1)
      printf("%d\n", d);
    else {
      int f = ((double)r / d) + 1;
      printf("%d\n", f * d);
    }
  }
  return 0;
}
