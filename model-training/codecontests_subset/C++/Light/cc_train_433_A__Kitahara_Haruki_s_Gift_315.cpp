#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, s = 0;
  char flag = 0;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int a;
    scanf("%d", &a);
    s += a;
    if (a == 100) flag = 1;
  }
  if (s % 200 != 0 || n == 1 || (!flag && n % 2 != 0))
    printf("NO");
  else
    printf("YES");
}
