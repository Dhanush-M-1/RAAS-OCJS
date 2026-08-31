#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  string s;
  cin >> s;
  int n = (int)s.length();
  vector<int> digit;
  for (int i = 0; i < n; i += 2) {
    digit.emplace_back((int)s[i] - 48);
  }
  sort(digit.begin(), digit.end());
  for (int i = 0; i < (int)digit.size(); i++) {
    if (i != (int)digit.size() - 1) {
      cout << digit[i] << "+";
    } else {
      cout << digit[i];
    }
  }
  cout << '\n';
  return 0;
}
