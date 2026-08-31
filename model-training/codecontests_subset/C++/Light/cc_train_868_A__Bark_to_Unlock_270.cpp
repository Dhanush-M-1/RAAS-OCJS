#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[5];
  int i, n, j;
  char p[105][5];
  cin >> s;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> p[i];
  }
  for (i = 0; i < n; i++) {
    if (s[0] == p[i][0] && s[1] == p[i][1]) {
      printf("YES\n");
      return 0;
    }
    if (p[i][1] == s[0]) {
      for (j = 0; j < n; j++) {
        if (p[j][0] == s[1]) {
          printf("YES\n");
          return 0;
        }
      }
    }
  }
  printf("NO\n");
}
