#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  vector<char> v;
  cin >> str;
  for (int i = 0; i < str.length(); i += 2) v.insert(v.end(), str[i]);
  sort(v.begin(), v.end());
  cout << v[0];
  for (int i = 1; i < v.size(); i++) cout << "+" << v[i];
  return 0;
}
