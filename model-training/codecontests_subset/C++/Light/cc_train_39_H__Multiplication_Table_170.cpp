#include <bits/stdc++.h>
using namespace std;
int k;
int main() {
  scanf("%d", &k);
  for (int i = 1; i < k; ++i) {
    for (int j = 1; j < k; ++j) {
      int a = i * j;
      if (a / k > 0) printf("%d", a / k);
      printf("%d", a % k);
      printf(" ");
    }
    printf("\n");
  }
  return 0;
}
