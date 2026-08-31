#include <bits/stdc++.h>
using namespace std;
string s;
int main() {
  int n;
  cin >> n;
  cin >> s;
  int m = 0;
  for (int i = 0; i < s.size(); i++)
    if (s[i] == '8') m++;
  cout << min(m, n / 11) << endl;
  return 0;
}
