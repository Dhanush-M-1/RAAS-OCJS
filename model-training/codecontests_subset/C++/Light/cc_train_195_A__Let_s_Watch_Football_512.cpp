#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  scanf("%d%d%d", &a, &b, &c);
  int n = a * c - b * c;
  if (n % b > 0)
    printf("%d\n", n / b + 1);
  else
    printf("%d\n", n / b);
  return 0;
}
