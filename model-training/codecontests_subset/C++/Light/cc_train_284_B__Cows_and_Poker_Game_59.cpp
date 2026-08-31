#include <bits/stdc++.h>
using namespace std;
char c;
int n, a, i, j;
int main() {
  scanf("%d\n", &n);
  for (int j = 1; j <= n; j++) {
    scanf("%c", &c);
    switch (c) {
      case 'A':
        a++;
        break;
      case 'I':
        i++;
        break;
    }
  }
  if (i) {
    if (i == 1)
      printf("1\n");
    else
      printf("0\n");
  } else {
    printf("%d\n", a);
  }
  return 0;
}
