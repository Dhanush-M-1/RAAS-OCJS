#include <bits/stdc++.h>
using namespace std;
int n, cnt;
char ch;
int main() {
  scanf("%d", &n);
  ch = getchar();
  for (int i = 1; i <= n; ++i) {
    ch = getchar();
    if (ch == '8') cnt++;
  }
  printf("%d", min(cnt, n / 11));
}
