#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, phNum, eCount = 0;
  cin >> n;
  string s;
  cin >> s;
  if (n > 10) {
    for (int i = 0; s[i]; i++) {
      if (s[i] == '8') {
        eCount++;
      }
    }
    if (eCount == 0) {
      cout << 0 << endl;
      return 0;
    }
    phNum = n / 11;
    if (phNum > eCount) {
      cout << eCount << endl;
    } else {
      cout << phNum << endl;
    }
  } else {
    cout << 0 << endl;
  }
  return 0;
}
