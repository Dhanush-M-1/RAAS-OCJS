#include <bits/stdc++.h>
using namespace std;
int a, n, num1 = 0, num2 = 0;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a);
    num1 ^= a;
  }
  for (int i = 1; i <= n - 1; i++) {
    scanf("%d", &a);
    num1 ^= a;
    num2 ^= a;
  }
  printf("%d\n", num1);
  for (int i = 1; i <= n - 2; i++) {
    scanf("%d", &a);
    num2 ^= a;
  }
  printf("%d\n", num2);
}
