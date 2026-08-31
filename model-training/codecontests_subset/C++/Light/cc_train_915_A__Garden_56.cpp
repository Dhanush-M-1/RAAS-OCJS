#include <bits/stdc++.h>
int main() {
  int i, n, length;
  int a_num;
  int num = 100;
  scanf("%d %d", &n, &length);
  for (i = 0; i < n; i++) {
    scanf("%d", &a_num);
    if (length % a_num == 0)
      if (length / a_num < num) num = length / a_num;
  }
  printf("%d", num);
}
