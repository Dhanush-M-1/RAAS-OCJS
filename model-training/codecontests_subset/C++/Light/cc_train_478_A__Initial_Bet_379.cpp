#include <bits/stdc++.h>
using namespace std;
int c[10];
int main() {
  int i, j, sum = 0;
  for (i = 0; i < 5; i++) scanf("%d", &c[i]);
  for (i = 0; i < 5; i++) sum += c[i];
  if (sum % 5 || sum == 0) {
    printf("-1\n");
  } else {
    printf("%d\n", sum / 5);
  }
  return 0;
}
