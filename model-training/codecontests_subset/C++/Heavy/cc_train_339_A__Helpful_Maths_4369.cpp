#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int a1 = 0, a2 = 0, a3 = 0;
  for (int i = 0; i < s.length(); i += 2) {
    if (s[i] == '1')
      a1++;
    else if (s[i] == '2')
      a2++;
    else
      a3++;
  }
  if (a1 > 0) {
    cout << 1;
    for (int i = 1; i < a1; i++) {
      cout << "+" << 1;
    }
  }
  if (a1 == 0 && a2 > 0) {
    cout << 2;
    for (int i = 1; i < a2; i++) {
      cout << "+" << 2;
    }
  } else {
    for (int i = 0; i < a2; i++) {
      cout << "+" << 2;
    }
  }
  if (a1 == 0 && a2 == 0 && a3 > 0) {
    cout << 3;
    a3--;
  }
  for (int i = 0; i < a3; i++) {
    cout << "+" << 3;
  }
}
