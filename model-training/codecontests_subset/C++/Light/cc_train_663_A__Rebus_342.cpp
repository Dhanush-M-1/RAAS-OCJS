#include <bits/stdc++.h>
using namespace std;
int arr[200];
int coef[200];
int main() {
  int p = 1, m = 0;
  char ch;
  coef[1] = 1;
  int tt = 1;
  int len = 0;
  while (1) {
    char qq[5], ch;
    scanf("%s", qq);
    ch = qq[0];
    if (ch == '?') ++len;
    if (ch == '+') coef[len + 1] = 1, ++p;
    if (ch == '-') coef[len + 1] = -1, ++m;
    if (ch == '=') break;
  }
  int tar;
  cin >> tar;
  int sum = (p - m) * tar;
  for (int j = 1; j <= len; j++) arr[j] = tar;
  for (int j = 1; j <= len && sum != tar; j++) {
    arr[j] = tar;
    if (coef[j] == 1) {
      while (arr[j] > 1 && sum > tar) arr[j]--, sum--;
    } else {
      while (arr[j] > 1 && sum < tar) arr[j]--, sum++;
    }
  }
  if (sum != tar) {
    puts("Impossible");
    return 0;
  }
  puts("Possible");
  printf("%d ", arr[1]);
  for (int j = 2; j <= len; j++) {
    if (coef[j] == 1)
      printf("+ ");
    else
      printf("- ");
    printf("%d ", arr[j]);
  }
  printf("= %d", tar);
}
