#include <bits/stdc++.h>
using namespace std;
char s[110][3];
int main() {
  int n;
  scanf("%s%d", s, &n);
  for (int i = 1; i <= n; i++) scanf("%s", s[i]);
  bool flag = 0;
  for (int i = 1; i <= n; i++) {
    if (strcmp(s[0], s[i]) == 0) {
      flag = 1;
      break;
    }
    for (int j = 1; j <= n; j++) {
      if (s[i][1] == s[0][0] && s[j][0] == s[0][1]) {
        flag = 1;
        break;
      }
    }
  }
  puts(flag ? "YES" : "NO");
  return 0;
}
