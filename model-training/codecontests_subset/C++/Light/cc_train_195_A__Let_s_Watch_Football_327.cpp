#include <bits/stdc++.h>
using namespace std;
int a, b, c;
int main() {
  scanf("%d %d %d", &a, &b, &c);
  printf("%d\n", ((a - b) * c - 1) / b + 1);
  return 0;
}
