#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s;
  while (cin >> n >> s) {
    int I = 0, A = 0, F = 0;
    int len = s.size();
    for (int i = 0; i < len; i++) {
      if (s[i] == 'A')
        A++;
      else if (s[i] == 'F')
        F++;
      else
        I++;
    }
    if (I >= 2) {
      cout << 0 << endl;
      continue;
    } else if (I == 1) {
      cout << 1 << endl;
      continue;
    } else {
      cout << A << endl;
      continue;
    }
  }
  return 0;
}
