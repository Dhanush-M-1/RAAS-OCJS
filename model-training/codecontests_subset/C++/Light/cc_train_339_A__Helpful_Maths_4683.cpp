#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int n = s.length();
  string h = "";
  for (int i = 0; i < n; i += 2) {
    char c = s[i];
    h.push_back(c);
  }
  sort(h.begin(), h.end());
  if (n > 1) {
    for (int i = 0; i < h.length(); i++) {
      if (i < h.length() - 1) {
        cout << h[i] << "+";
      } else {
        cout << h[i];
      }
    }
    cout << endl;
  } else
    cout << s << endl;
  return 0;
}
