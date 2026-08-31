#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  int cnt = 0;
  getchar();
  for (int i = 1; i <= n; i++) {
    char c;
    scanf("%c", &c);
    if (c == '8') cnt++;
  }
  printf("%d\n", min(cnt, n / 11));
  return 0;
}
