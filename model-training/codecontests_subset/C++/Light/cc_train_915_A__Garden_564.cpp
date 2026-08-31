#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:1024000000,1024000000")
const int MAXN = 100024;
const int MOD = 1e9 + 7;
const double eps = 1e-8;
using namespace std;
int main() {
  int n, k;
  scanf("%d", &n);
  scanf("%d", &k);
  int MIN = 0x3f3f3f3f;
  for (int i = 1; i <= n; i++) {
    int a;
    scanf("%d", &a);
    if (k % a == 0) {
      int num = k / a;
      MIN = min(MIN, num);
    }
  }
  printf("%d\n", MIN);
  return 0;
}
