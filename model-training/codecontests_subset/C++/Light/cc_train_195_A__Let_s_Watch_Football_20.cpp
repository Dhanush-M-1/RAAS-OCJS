#include <bits/stdc++.h>
using namespace std;
int a, b, c;
int main() {
  scanf("%d %d %d", &a, &b, &c);
  printf("%d\n", (c * (a - b) + b - 1) / b);
  return 0;
}
