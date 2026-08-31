#include <bits/stdc++.h>
using namespace std;
int a[105];
int n;
int main() {
  while (scanf("%d", &n) != EOF) {
    int m = 0;
    for (int i = 0; i < n; i++) {
      scanf("%d", &a[i]);
      if (a[i] == 100) m++;
    }
    bool f = true;
    if ((m == 0) && (n % 2 == 1)) f = false;
    if (m % 2 == 1) f = false;
    if (f)
      printf("YES\n");
    else
      printf("NO\n");
  }
  return 0;
}
