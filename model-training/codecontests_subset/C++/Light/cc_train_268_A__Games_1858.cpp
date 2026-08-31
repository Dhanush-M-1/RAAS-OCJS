#include <bits/stdc++.h>
struct Matchs {
  int Home;
  int Guest;
} MyMatch[31];
int main(void) {
  unsigned short int n, i, j, ans = 0;
  scanf("%hu", &n);
  for (i = 0; i < n; ++i) {
    scanf("%d %d", &MyMatch[i].Home, &MyMatch[i].Guest);
  }
  for (i = 0; i < n; ++i) {
    for (j = 0; j < n; ++j) {
      if ((MyMatch[i].Guest == MyMatch[j].Home) && (i != j)) {
        ++ans;
      }
    }
  }
  printf("%i", ans);
  return 0;
}
