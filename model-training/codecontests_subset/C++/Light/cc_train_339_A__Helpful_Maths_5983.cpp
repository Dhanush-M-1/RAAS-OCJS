#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int i = 0, x = 0;
  vector<int> no;
  while (i < s.size()) {
    if (s[i] == '1')
      x = 1;
    else if (s[i] == '2')
      x = 2;
    else if (s[i] == '3')
      x = 3;
    no.push_back(x);
    i += 2;
  }
  sort(no.begin(), no.end());
  i = 0;
  while (i < no.size()) {
    cout << no[i];
    if (i != (no.size() - 1)) cout << '+';
    ++i;
  }
}
