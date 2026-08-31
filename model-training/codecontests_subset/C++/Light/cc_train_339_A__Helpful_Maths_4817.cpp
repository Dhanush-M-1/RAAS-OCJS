#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  vector<char> v;
  cin >> s;
  int l = s.size(), i;
  for (i = 0; i < l; i++) {
    if (s[i] == '1' || s[i] == '2' || s[i] == '3') v.push_back(s[i]);
  }
  sort(v.begin(), v.end());
  cout << v[0];
  for (i = 1; i < v.size(); i++) cout << "+" << v[i];
  cout << endl;
  return 0;
}
