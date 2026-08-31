#include <bits/stdc++.h>
using namespace std;
int uz[4];
int main() {
  string s;
  int c;
  cin >> s;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] > 48 && s[i] < 52) {
      uz[s[i] - 48]++;
    }
  }
  c = uz[1];
  int d = uz[2];
  while (uz[1]) {
    cout << 1;
    uz[1]--;
    if (uz[1] != 0) {
      cout << "+";
    }
  }
  if (uz[2] != 0 && c != 0) cout << "+";
  while (uz[2]) {
    cout << 2;
    uz[2]--;
    if (uz[2] != 0) {
      cout << "+";
    }
  }
  bool z = 0;
  if (d != 0 || c != 0) z = 1;
  if (uz[3] != 0 && z) cout << "+";
  while (uz[3]) {
    cout << 3;
    uz[3]--;
    if (uz[3] != 0) {
      cout << "+";
    }
  }
}
