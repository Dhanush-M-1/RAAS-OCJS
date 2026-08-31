#include <bits/stdc++.h>
using namespace std;
int n, ans;
int main() {
  scanf("%d", &n);
  char ch = getchar();
  while (ch == '\n' || ch == '\r' || !~ch) ch = getchar();
  for (int i = 1; i <= n; i++) {
    if (ch == '8') ans++;
    ch = getchar();
  }
  printf("%d\n", min(n / 11, ans));
  return 0;
}
