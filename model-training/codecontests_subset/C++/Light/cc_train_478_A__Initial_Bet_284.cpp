#include <bits/stdc++.h>
using namespace std;
int i, n, m, j, c1, c2, c3, c4, c5;
int main() {
  scanf("%d %d %d %d %d", &c1, &c2, &c3, &c4, &c5);
  if ((c1 + c2 + c3 + c4 + c5) % 5 != 0 || c1 + c2 + c3 + c4 + c5 == 0)
    printf("-1");
  else
    printf("%d", (c1 + c2 + c3 + c4 + c5) / 5);
}
