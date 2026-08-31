#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, s;
  scanf("%d%d%d", &a, &b, &c);
  s = (a * c) / b - c;
  if ((a * c) % b) s++;
  printf("%d\n", s);
  return 0;
}
