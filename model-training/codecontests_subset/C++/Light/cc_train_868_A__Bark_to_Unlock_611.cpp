#include <bits/stdc++.h>
using namespace std;
int n, a, b;
char s[110][10], f[10];
int main() {
  int i;
  cin >> f >> n;
  for (i = 1; i <= n; i++) {
    cin >> s[i];
    if (s[i][0] == f[0] && s[i][1] == f[1]) a = b = 1;
    if (s[i][1] == f[0]) a = 1;
    if (s[i][0] == f[1]) b = 1;
  }
  if (a && b)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
