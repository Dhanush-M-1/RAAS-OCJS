#include <bits/stdc++.h>
using namespace std;
const int maxn = 100010;
int main() {
  string s;
  int n;
  cin >> s >> n;
  int i;
  for (i = 0; i < s.length(); i++) {
    if (s[i] >= 'A' && s[i] <= 'Z') {
      s[i] += 'a' - 'A';
    }
  }
  for (i = 0; i < s.length(); i++) {
    if (s[i] < n + 97) {
      s[i] = s[i] + 'A' - 'a';
    }
  }
  cout << s << endl;
  return 0;
}
