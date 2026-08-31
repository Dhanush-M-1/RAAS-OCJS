#include <bits/stdc++.h>
using namespace std;
char s[111][3];
int main() {
  char t[3];
  scanf("%s", t);
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%s", s[i]);
  }
  for (int i = 0; i < n; i++) {
    if (t[0] == s[i][0] && t[1] == s[i][1]) {
      puts("YES");
      return 0;
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (t[0] == s[i][1] && t[1] == s[j][0]) {
        puts("YES");
        return 0;
      }
    }
  }
  puts("NO");
  return 0;
}
