#include <bits/stdc++.h>
using namespace std;
const int maxn = 300100;
char str[maxn];
int main() {
  int n, i, j, l, r;
  scanf("%d %s", &n, str);
  l = r = -1;
  for (i = 0; i + 1 < n; i++) {
    if (str[i] > str[i + 1]) {
      l = i;
      break;
    }
  }
  if (l == -1)
    printf("NO\n");
  else {
    printf("YES\n%d %d\n", l + 1, l + 2);
  }
  return 0;
}
