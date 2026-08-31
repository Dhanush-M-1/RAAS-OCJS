#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, o = 0, c = 0;
  string str;
  cin >> n >> str;
  for (int i = 0; i < n; i++) {
    if (str[i] == '8')
      c++;
    else
      o++;
  }
  cout << min(c, n / 11);
  return 0;
}
