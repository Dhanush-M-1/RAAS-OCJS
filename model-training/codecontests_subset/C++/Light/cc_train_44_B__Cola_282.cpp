#include <bits/stdc++.h>
using namespace std;
int n;
int a, b, c;
int ways;
int lacks;
int main() {
  scanf("%d %d %d %d", &n, &a, &b, &c);
  ways = 0;
  n *= 2;
  for (int i = 0; i < c + 1; i++) {
    for (int j = 0; j < b + 1; j++) {
      lacks = n - 4 * i - 2 * j;
      if (lacks <= a && lacks >= 0) {
        ways++;
        ;
      }
    }
  }
  printf("%d\n", ways);
  return 0;
}
