#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  sort(s.begin(), s.end());
  if (s.size() != 1)
    for (long long i = (s.size() - 1) / 2; i <= s.size() - 2; i++) {
      cout << s[i] << "+";
    }
  cout << s[s.size() - 1];
}
