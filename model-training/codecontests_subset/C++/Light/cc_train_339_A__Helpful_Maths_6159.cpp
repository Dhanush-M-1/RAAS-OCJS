#include <bits/stdc++.h>
using namespace std;
int a[1001], i, j, m;
char c;
int main() {
  while (c != '\n') {
    scanf("%c", &c);
    if (c == '1' || c == '2' || c == '3') {
      a[c - '0']++;
      m = max(m, c - '0');
    }
  }
  for (i = 1; i <= 3; i++)
    for (j = 1; j <= a[i]; j++) {
      printf("%d", i);
      if (i != m || j != a[i]) printf("+");
    }
  return 0;
}
