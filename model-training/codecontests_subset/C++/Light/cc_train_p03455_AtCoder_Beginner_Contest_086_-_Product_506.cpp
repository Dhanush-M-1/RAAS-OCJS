#include <cstdio>

int main() {
  int a, b;
  scanf("%d%d", &a, &b);
  printf((a * b) % 2 == 0 ? "Even\n" : "Odd\n");
  return 0;
}
