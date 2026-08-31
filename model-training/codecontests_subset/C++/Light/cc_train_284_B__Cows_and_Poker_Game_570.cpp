#include <bits/stdc++.h>
using namespace std;
int main() {
  int a;
  cin >> a;
  char b[a];
  cin >> b;
  int c = 0, d = 0;
  for (int i = 0; i < a; i++) {
    if (b[i] == 'A') {
      c++;
    }
    if (b[i] == 'I') {
      d++;
    }
  }
  if (d != 0) {
    if (d > 1) {
      cout << "0" << endl;
    } else {
      cout << "1" << endl;
    }
  } else {
    cout << c << endl;
  }
}
