#include <bits/stdc++.h>
using namespace std;
int aa[110];
int main() {
  int n, k;
  scanf("%d%d", &n, &k);
  for (int i = 0; i < n; i++) {
    scanf("%d", &aa[i]);
  }
  sort(aa, aa + n);
  int op;
  for (int i = n - 1; i >= 0; i--) {
    if (k % aa[i] == 0) {
      op = k / aa[i];
      break;
    }
  }
  printf("%d\n", op);
}
