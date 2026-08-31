#include <bits/stdc++.h>
int main(int argc, char* argv[]) {
  int n, x, y;
  scanf("%d %d %d", &n, &x, &y);
  int count = 0;
  while (1) {
    if ((x * 100) / n >= y)
      break;
    else {
      x++;
      count++;
    }
  }
  printf("%d", count);
  return 0;
}
