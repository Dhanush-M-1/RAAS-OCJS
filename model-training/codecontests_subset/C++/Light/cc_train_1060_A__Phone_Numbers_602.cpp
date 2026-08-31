#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, cnt = 0;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i < n; ++i)
    if (s[i] == '8') ++cnt;
  int ret = 0;
  for (int i = 1; i <= cnt; ++i)
    if ((n - i) / 10 >= i) ret = i;
  cout << ret << endl;
  return 0;
}
