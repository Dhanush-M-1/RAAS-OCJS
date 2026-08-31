#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  string t;
  for (int i = 0; i < s.length(); i++) {
    if (s[i] != '+') t.push_back(s[i]);
  }
  sort(t.begin(), t.end());
  {
    cout << t[0];
    for (int i = 1; i < t.length(); i++) cout << "+" << t[i];
  }
  return 0;
}
