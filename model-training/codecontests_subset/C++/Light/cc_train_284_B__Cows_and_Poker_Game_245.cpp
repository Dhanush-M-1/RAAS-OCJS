#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  while (scanf("%d", &n) != EOF) {
    char s;
    int a = 0, b = 0, i;
    getchar();
    for (i = 0; i < n; i++) {
      s = getchar();
      if (s == 'A') a++;
      if (s == 'I') b++;
    }
    if (b == 0) printf("%d\n", a);
    if (b == 1) printf("1\n");
    if (b > 1) printf("0\n");
  }
  return 0;
}
