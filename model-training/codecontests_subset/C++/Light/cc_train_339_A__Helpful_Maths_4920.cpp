#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int i;
  vector<int> v1;
  for (i = 0; i < s.length(); i++) {
    if (i % 2) {
    } else {
      int d = s[i];
      v1.push_back(d - 48);
    }
  }
  sort(v1.begin(), v1.end());
  for (i = 0; i < v1.size() - 1; i++) {
    cout << v1[i] << "+";
  }
  int l = v1.size();
  cout << v1[l - 1];
}
