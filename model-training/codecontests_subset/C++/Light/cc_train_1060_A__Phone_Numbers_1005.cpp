#include <bits/stdc++.h>
using namespace std;
signed main() {
  int n, cnt = 0;
  char s[105];
  cin >> n;
  scanf("%s", s);
  for (int i = 0; i < n; i++) cnt += s[i] == '8';
  cout << min(cnt, n / 11);
}
