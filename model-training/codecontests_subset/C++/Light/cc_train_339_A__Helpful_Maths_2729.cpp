#include <bits/stdc++.h>
using namespace std;
string s;
vector<char> v;
int main() {
  cin >> s;
  for (int i = (int)(0); i < (int)(s.size()); i++) {
    if (s[i] >= '0' && s[i] <= '9') {
      v.push_back(s[i]);
    }
  }
  sort(v.begin(), v.end());
  for (int i = (int)(0); i < (int)(v.size() - 1); i++) {
    cout << v[i] << "+";
  }
  cout << v[v.size() - 1];
  return 0;
}
