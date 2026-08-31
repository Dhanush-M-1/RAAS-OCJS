#include <bits/stdc++.h>
using namespace std;
int main() {
  int c1, c2, c3, c4, c5;
  scanf("%d%d%d%d%d", &c1, &c2, &c3, &c4, &c5);
  int s{c1 + c2 + c3 + c4 + c5};
  if (s % 5 || s == 0)
    puts("-1");
  else
    printf("%d\n", s / 5);
}
