#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, n;
  scanf("%d %d %d", &a, &b, &c);
  n = a * c - (b * c);
  if (n % b == 0)
    printf("%d\n", n / b);
  else
    printf("%d\n", (n / b) + 1);
  return 0;
}
