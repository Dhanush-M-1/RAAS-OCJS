#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  vector<int> a;
  cin >> s;
  for (int i = 0; i < s.length(); i += 2) a.push_back(s[i] - '0');
  sort(a.begin(), a.end());
  for (int i = 0; i < int(a.size() - 1); i++) cout << a[i] << "+";
  cout << a[a.size() - 1];
  return 0;
}
