#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[1000];
  scanf("%d", &a[0]);
  int i = 1;
  while (scanf("+%d", &a[i]) == 1) i++;
  sort(&a[0], &a[i]);
  printf("%d", a[0]);
  for (int j = 1; j < i; j++) printf("+%d", a[j]);
  return 0;
}
