#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e6 + 5;
const int inf = 0x3f3f3f3f;
unsigned long long mod = 998244353;
int main() {
  char a[5], b[102][5];
  scanf("%s", a);
  int f1 = 0, f2 = 0, flag = 0, n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    scanf("%s", b[i]);
    if (a[0] == b[i][0] && a[1] == b[i][1]) flag = 1;
    if (a[0] == b[i][1]) f1++;
    if (a[1] == b[i][0]) f2++;
  }
  if (f1 && f2)
    puts("YES");
  else if (flag)
    puts("YES");
  else
    puts("NO");
}
