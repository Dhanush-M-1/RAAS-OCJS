#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int a = 0;
  for (int i = 0; i < n; ++i)
    if (s[i] == '8') ++a;
  cout << min(n / 11, a) << endl;
  return 0;
}
