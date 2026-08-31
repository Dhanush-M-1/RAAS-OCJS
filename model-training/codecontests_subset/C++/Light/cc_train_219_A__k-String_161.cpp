#include <bits/stdc++.h>
using namespace std;
int a[27];
int main() {
  int k;
  cin >> k;
  string s;
  cin >> s;
  string c = "";
  for (int i = 0; i < s.length(); i++) {
    a[s[i] - 'a']++;
  }
  for (int i = 0; i < 26; i++) {
    if (a[i] != 0) {
      if (a[i] % k != 0) {
        cout << "-1";
        return 0;
      } else {
        int t = a[i] / k;
        while (t) {
          char r = i + 97;
          c += r;
          t--;
        }
      }
    }
  }
  while (k) {
    cout << c;
    k--;
  }
}
