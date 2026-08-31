#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int x = s.size() - 1;
  sort(s.begin(), s.end());
  for (int i = x / 2; i < x; i++) cout << s[i] << "+";
  cout << s[x] << endl;
  return 0;
}
