#include <bits/stdc++.h>
using namespace std;
using INT = long long;
string a[111];
int main() {
  int n;
  string s;
  cin >> s;
  cin >> n;
  int flag = 0;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    if (a[i] == s) flag |= 3;
    if (a[i][1] == s[0]) flag |= 1;
    if (a[i][0] == s[1]) flag |= 2;
  }
  if (flag == 3) return puts("YES"), 0;
  return puts("NO"), 0;
}
