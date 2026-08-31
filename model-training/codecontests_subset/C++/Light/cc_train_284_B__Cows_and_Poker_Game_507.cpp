#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int flag1;
  flag1 = 0;
  int flag2 = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'I') {
      flag1++;
    }
    if (s[i] == 'A') {
      flag2++;
    }
  }
  if (flag1 == 0) {
    cout << flag2 << endl;
  } else if (flag1 == 1) {
    cout << 1 << endl;
  } else {
    cout << 0 << endl;
  }
  return 0;
}
