#include <bits/stdc++.h>
using namespace std;
multiset<int> Set;
multiset<int>::iterator it, tmp;
int sum, n;
string s;
char c;
int main() {
  ios_base::sync_with_stdio(false);
  cin >> s;
  for (int i = 0; i < s.size(); ++i) {
    c = s[i];
    if (c != '+')
      sum = sum * 10 + (c - '0');
    else {
      Set.insert(sum);
      sum = 0;
      ++n;
    }
  }
  Set.insert(sum);
  for (it = Set.begin(); it != Set.end(); ++it) {
    cout << *it;
    --n;
    if (n >= 0) cout << '+';
  }
  return 0;
}
