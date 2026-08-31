#include <bits/stdc++.h>
using namespace std;
int main() {
  int c1, c2, c3, c4, c5, s;
  cin >> c1 >> c2 >> c3 >> c4 >> c5;
  s = c1 + c2 + c3 + c4 + c5;
  if (s % 5 == 0) {
    if (s == 0) {
      printf("-1\n");
    } else
      printf("%d\n", s / 5);
  } else
    printf("-1\n");
  return 0;
}
