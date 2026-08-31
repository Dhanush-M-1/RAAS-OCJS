#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int ic = 0, ac = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'I') {
      ic++;
    } else {
      if (s[i] == 'A') {
        ac++;
      }
    }
  }
  if (ic >= 2) {
    cout << 0 << endl;
    return 0;
  } else if (ic == 1) {
    cout << 1 << endl;
    return 0;
  } else {
    cout << ac << endl;
  }
  return 0;
}
