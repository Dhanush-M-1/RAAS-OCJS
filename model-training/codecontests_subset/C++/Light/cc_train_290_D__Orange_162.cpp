#include <bits/stdc++.h>
using namespace std;
int main() {
  char a[100];
  int n, i, j, k;
  while (~scanf("%s", a)) {
    scanf("%d", &n);
    char c = 'a' + n;
    for (i = 0; i < strlen(a); i++) {
      if (a[i] < c || a[i] < char(c - 'a' + 'A')) {
        if (a[i] >= 'a' && a[i] <= 'z') a[i] = char(a[i] - 'a' + 'A');
      }
      if (a[i] >= c || a[i] >= char(c - 'a' + 'A')) {
        if (a[i] >= 'A' && a[i] <= 'Z') {
          a[i] = char(a[i] - 'A' + 'a');
        }
      }
    }
    printf("%s\n", a);
  }
}
