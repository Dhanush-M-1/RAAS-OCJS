#include <bits/stdc++.h>
using namespace std;
int main() {
  int c1, c2, c3, c4, c5, sum = 0;
  scanf("%d%d%d%d%d", &c1, &c2, &c3, &c4, &c5);
  sum = c1 + c2 + c3 + c4 + c5;
  if (!sum || sum % 5)
    printf("-1\n");
  else
    printf("%d\n", sum / 5);
  return 0;
}
