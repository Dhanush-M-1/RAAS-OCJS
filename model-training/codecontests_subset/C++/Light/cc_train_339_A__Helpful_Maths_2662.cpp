#include <bits/stdc++.h>
using namespace std;
string s;
long long i, j, c;
int main() {
  cin >> s;
  for (i = 0; i < s.size(); i = i + 2)
    for (j = i + 2; j < s.size(); j = j + 2)
      if (s[i] > s[j]) swap(s[i], s[j]);
  cout << s << endl;
  return 0;
}
