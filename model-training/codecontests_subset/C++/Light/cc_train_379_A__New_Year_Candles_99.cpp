#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  scanf("%d%d", &a, &b);
  int temp;
  temp = a;
  while (a >= b) {
    temp = temp + (a / b);
    a = (a / b) + (a % b);
  }
  printf("%d\n", temp);
  return 0;
}
