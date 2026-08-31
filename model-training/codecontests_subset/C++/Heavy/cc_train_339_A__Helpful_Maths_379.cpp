#include <bits/stdc++.h>
using namespace std;
int main() {
  string n;
  cin >> n;
  int a{0}, b{0}, c{0};
  for (int i = 0; i < n.size(); i++) {
    if (n[i] == '1') {
      a++;
    } else if (n[i] == '2') {
      b++;
    } else if (n[i] == '3') {
      c++;
    }
  }
  if (a + b + c > 1) {
    if (b == 0 && c == 0) {
      for (int i = 0; i < a - 1; i++) {
        cout << '1' << '+';
      }
    } else {
      for (int i = 0; i < a; i++) {
        cout << '1' << '+';
      }
    }
    if (c != 0) {
      for (int i = 0; i < b; i++) {
        cout << '2' << "+";
      }
    } else {
      for (int i = 0; i < b - 1; i++) {
        cout << '2' << "+";
      }
    }
    for (int i = 0; i < c - 1; i++) {
      cout << '3' << '+';
    }
  }
  if (c != 0) {
    cout << 3;
  } else if (b != 0) {
    cout << 2;
  } else if (a != 0) {
    cout << 1;
  }
  return 0;
}
