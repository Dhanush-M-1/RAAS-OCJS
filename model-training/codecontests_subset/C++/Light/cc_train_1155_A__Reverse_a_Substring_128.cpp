#include <bits/stdc++.h>
char s[300005];
int n;
int ind[200];
int main() {
  scanf("%d", &n);
  scanf("%s", s);
  for (int i = n - 1; i >= 0; i--) {
    for (char c = 'a'; c <= 'z'; c++) {
      if (c < s[i]) {
        if (ind[(int)c]) {
          return printf("YES\n%d %d", i + 1, ind[(int)c] + 1), 0;
        }
      }
    }
    ind[(int)s[i]] = i;
  }
  printf("NO");
  return 0;
}
