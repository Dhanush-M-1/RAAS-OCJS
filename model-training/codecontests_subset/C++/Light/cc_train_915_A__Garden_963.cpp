#include <bits/stdc++.h>
using namespace std;
int main() {
  int maxDiv = 1;
  int n, k;
  scanf("%d%d", &n, &k);
  int nr;
  for (int i = 0; i < n; ++i) {
    scanf("%d", &nr);
    if (k % nr == 0 && ((maxDiv == -1) || (nr > maxDiv))) {
      maxDiv = nr;
    }
  }
  printf("%d\n", k / maxDiv);
}
