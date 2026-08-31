#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, num = 0;
  for (i = 1; i <= 5; i++) {
    int temp;
    scanf("%d", &temp);
    num += temp;
  }
  if (num % 5 || num == 0) {
    printf("-1\n");
  } else {
    printf("%d\n", num / 5);
  }
  return 0;
}
