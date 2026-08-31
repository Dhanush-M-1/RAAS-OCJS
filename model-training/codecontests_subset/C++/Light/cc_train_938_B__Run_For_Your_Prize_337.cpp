#include <bits/stdc++.h>
using namespace std;
int n, lpos, rpos = 1000000;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int pos;
    scanf("%d", &pos);
    if (pos <= 500000)
      lpos = max(lpos, pos);
    else
      rpos = min(rpos, pos);
  }
  printf("%d\n", max(lpos - 1, 1000000 - rpos));
}
