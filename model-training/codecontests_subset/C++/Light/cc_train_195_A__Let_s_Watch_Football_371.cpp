#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  scanf("%d%d%d", &a, &b, &c);
  int t = (a - b) * c / b;
  if ((a - b) * c % b != 0) ++t;
  printf("%d\n", t);
  return 0;
}
