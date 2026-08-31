#include <bits/stdc++.h>
using namespace std;
int n, i, m = 0, ans = 0;
string s;
int main() {
  scanf("%d", &n);
  cin >> s;
  for (i = 0; i < n; i++)
    if (s[i] == '8') m++;
  ans = min(n / 11, m);
  printf("%d", ans);
}
