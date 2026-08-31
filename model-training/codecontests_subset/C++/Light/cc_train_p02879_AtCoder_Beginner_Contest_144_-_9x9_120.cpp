#include <cstdio>

int main() {
  int A, B;
  scanf("%d %d", &A, &B);

  if (A <= 9 && B <= 9) return !printf("%d\n", A*B);

  puts("-1");
}
