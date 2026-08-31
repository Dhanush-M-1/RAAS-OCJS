#include <bits/stdc++.h>
using namespace std;
void print(int x, int base) {
  if (x == 0) return;
  print(x / base, base);
  printf("%d", x % base);
}
int main() {
  int n;
  scanf("%d", &n);
  n--;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      print(i * j, n + 1);
      printf(" ");
    }
    printf("\n");
  }
  return 0;
}
