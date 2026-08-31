#include <bits/stdc++.h>
using namespace std;
string s;
int a[10], i;
int main() {
  cin >> s;
  for (int i = 0; i <= s.length() - 1; i++) {
    if (s[i] == '1') {
      a[1]++;
    } else if (s[i] == '2') {
      a[2]++;
    } else if (s[i] == '3') {
      a[3]++;
    }
  }
  while (a[1] > 0) {
    if ((a[2] > 0) || (a[1] - 1 > 0) || (a[3] > 0)) {
      cout << "1+";
    } else {
      cout << "1";
    }
    a[1]--;
  }
  while (a[2] > 0) {
    if ((a[3] > 0) || (a[2] - 1 > 0)) {
      cout << "2+";
    } else {
      cout << "2";
    }
    a[2]--;
  }
  while (a[3] > 0) {
    if (a[3] - 1 > 0) {
      cout << "3+";
    } else {
      cout << "3";
    }
    a[3]--;
  }
  return 0;
}
