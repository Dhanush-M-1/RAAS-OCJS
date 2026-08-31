#include <bits/stdc++.h>
using namespace std;
int n, ans;
char a[5], b[10000000], c[200][5];
int main() {
  scanf("%s%d", a, &n);
  ans = 0;
  int flag = 0;
  for (int i = 1; i <= n; i++) scanf("%s", c[i]);
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      b[ans++] = c[i][0];
      b[ans++] = c[i][1];
      b[ans++] = c[j][0];
      b[ans++] = c[j][1];
    }
  }
  for (int i = 1; i <= ans; i++) {
    if (b[i - 1] == a[0] && b[i] == a[1]) {
      flag = 1;
      break;
    }
  }
  if (flag)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
