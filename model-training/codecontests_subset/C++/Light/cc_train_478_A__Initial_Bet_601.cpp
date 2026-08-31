#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c = 0;
  for (int i = 0; i < 5; i++) {
    scanf("%d", &n);
    c += n;
  }
  if (c == 0 || c % 5) {
    c = -1;
    printf("%d\n", c);
  } else
    printf("%d\n", c / 5);
  return 0;
}
