#include <bits/stdc++.h>
using namespace std;
int mas[30];
int main() {
  int n;
  scanf("%d", &n);
  string s;
  cin >> s;
  int a = 0, b = 0, c = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'A') ++a;
    if (s[i] == 'I') ++b;
    if (s[i] == 'F') ++c;
  }
  int cnt = 0;
  if (b == 1 && (a > 0 || c > 0)) cnt += b;
  if (b == 0 && (c > 0 || a > 1)) cnt += a;
  printf("%d\n", cnt);
  return 0;
}
