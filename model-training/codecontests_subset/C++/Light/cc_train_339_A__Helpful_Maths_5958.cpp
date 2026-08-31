#include <bits/stdc++.h>
using namespace std;
int main() {
  int sum = 0;
  string s;
  cin >> s;
  multiset<int> n;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] >= '0' && s[i] <= '9')
      n.insert((s[i] - '0'));
    else
      sum++;
  }
  for (auto v : n) {
    cout << v;
    if (sum) {
      cout << '+';
      sum--;
    }
  }
  return 0;
}
