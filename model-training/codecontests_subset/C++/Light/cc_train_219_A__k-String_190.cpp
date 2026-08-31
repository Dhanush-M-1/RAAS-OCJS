#include <bits/stdc++.h>
using namespace std;
set<char> ans;
int n;
string s, t;
int a[27];
int main() {
  cin >> n >> s;
  for (int i = 0; i < s.size(); i++) {
    a[s[i] - 'a']++;
  }
  for (int i = 0; i < 26; i++) {
    if (a[i] % n != 0) {
      cout << -1;
      exit(0);
    } else {
      for (int j = 0; j < a[i] / n; j++) {
        t += char(i + 'a');
      }
    }
  }
  for (int i = 0; i < n; i++) cout << t;
  return 0;
}
