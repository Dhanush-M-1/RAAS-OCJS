#include <bits/stdc++.h>
using namespace std;
const int N = 111;
char s[N];
int main() {
  int n;
  scanf("%d %s", &n, s);
  int ans = 0;
  for (int i = 0; i < n; i++)
    if (s[i] == '8') ans++;
  ans = min(ans, n / 11);
  printf("%d\n", ans);
  return 0;
}
