#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s;
  cin >> n >> s;
  int c = 0;
  for (int i = 0; i < n; ++i) {
    if (s[i] == '8') c++;
  }
  int res = n / 11;
  res = min(res, c);
  cout << res;
  return 0;
}
