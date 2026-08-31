#include <bits/stdc++.h>
using namespace std;
int n, cnt;
char s[200];
int main() {
  scanf("%d%s", &n, s);
  for (int i = 0; i < n; i++)
    if (s[i] == '8') cnt++;
  int ans = min(cnt, n / 11);
  printf("%d\n", ans);
}
