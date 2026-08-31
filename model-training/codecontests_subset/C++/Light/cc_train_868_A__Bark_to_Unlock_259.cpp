#include <bits/stdc++.h>
using namespace std;
char str[10], sub[1234][1234];
int main() {
  int n;
  scanf("%s", str);
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%s", sub[i]);
  int k = -1;
  int flag = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < 2; j++) {
      if (str[0] == sub[i][j]) {
        if (j == 0 && str[1] == sub[i][1]) {
          flag = 1;
          break;
        }
      }
    }
    if (flag) break;
  }
  for (int ii = 0; ii < n; ii++) {
    if (str[0] == sub[ii][1]) {
      for (int i = 0; i < n; i++) {
        if (str[1] == sub[i][0]) {
          flag = 1;
          break;
        }
      }
    }
    if (flag) break;
  }
  if (flag)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
