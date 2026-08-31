#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  scanf("%d%d%d", &a, &b, &c);
  int n = a * c;
  int m = b * c;
  m = n - m;
  if (m % b == 0)
    m = m / b;
  else
    m = m / b + 1;
  printf("%d\n", m);
  return 0;
}
