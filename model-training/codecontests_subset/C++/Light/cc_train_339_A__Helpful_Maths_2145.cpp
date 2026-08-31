#include <bits/stdc++.h>
using namespace std;
int main() {
  string s1;
  cin >> s1;
  int n = s1.length();
  vector<char> v1;
  for (int i = 0; i < n; i++) {
    if (s1[i] != '+') {
      v1.push_back(s1[i]);
    }
  }
  sort(v1.begin(), v1.end());
  int m = v1.size();
  for (int i = 0; i < m - 1; i++) {
    cout << v1[i] << "+";
  }
  cout << v1[m - 1];
  return 0;
}
