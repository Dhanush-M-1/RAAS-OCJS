#include <bits/stdc++.h>
using namespace std;
const int sz = 100010;
vector<long long> v(sz, 0), prefix(sz, 0), suffix(sz, 0);
string s;
int main() {
  int n;
  string s, temp = "";
  cin >> s;
  for (int i = 0; i < s.length(); i += 2) {
    temp.push_back(s[i]);
  }
  sort(temp.begin(), temp.end());
  int k = 0;
  for (int i = 0; i < s.length(); i += 2, ++k) {
    s[i] = temp[k];
  }
  cout << s;
  return 0;
}
