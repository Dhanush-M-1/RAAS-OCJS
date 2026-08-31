#include <bits/stdc++.h>
using namespace std;
int main() {
  string ss;
  vector<int> s;
  cin >> ss;
  for (int i = 0; i < ss.size(); i += 2) {
    s.push_back(ss[i] - '0');
  }
  sort(s.begin(), s.end());
  for (int i = 0; i < s.size() - 1; i++) {
    cout << s[i] << "+";
  }
  cout << s[s.size() - 1] << endl;
  return 0;
}
