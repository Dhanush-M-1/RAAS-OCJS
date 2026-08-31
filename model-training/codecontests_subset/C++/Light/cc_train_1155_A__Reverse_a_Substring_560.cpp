#include <bits/stdc++.h>
using namespace std;
const long double E = 2.71828182845904523536;
const long double pi = acos(-1);
const double eps = 1e-9;
const long long mod = 1e9 + 7;
const long long inf = 1LL << 30;
const int N = 300300;
char a[N];
int main() {
  int n;
  scanf("%d", &n);
  scanf("%s", &a);
  for (int i = 0; i < n - 1; i++) {
    if (a[i + 1] < a[i]) {
      printf("YES\n");
      printf("%d %d\n", i + 1, i + 2);
      return 0;
    }
  }
  printf("NO");
  return 0;
}
