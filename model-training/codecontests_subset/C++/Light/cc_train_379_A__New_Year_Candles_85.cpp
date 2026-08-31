#include <bits/stdc++.h>
int main() {
  int numb1, numb2;
  scanf("%d%d", &numb1, &numb2);
  int temp1, temp2;
  int sum = 0;
  for (int i = 1; i <= 100; i++) {
    temp1 = numb1 / numb2;
    temp2 = numb1 % numb2;
    sum = sum + numb2 * temp1;
    numb1 = temp1 + temp2;
  }
  printf("%d", sum + temp2);
  return 0;
}
