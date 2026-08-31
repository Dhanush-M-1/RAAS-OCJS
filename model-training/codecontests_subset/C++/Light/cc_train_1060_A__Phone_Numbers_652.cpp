#include <bits/stdc++.h>
using namespace std;
int n, A, B, Ans;
char s[105];
int main() {
  scanf("%d%s", &n, s + 1);
  for (int i = 1; i <= n; i++)
    if (s[i] == '8')
      A++;
    else
      B++;
  while (A && n >= 11) Ans++, A--, n -= 11;
  printf("%d\n", Ans);
  return 0;
}
