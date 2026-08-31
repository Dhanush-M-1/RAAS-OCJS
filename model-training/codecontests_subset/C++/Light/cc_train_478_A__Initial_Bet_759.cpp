#include <bits/stdc++.h>
using namespace std;
int main() {
  int c1, c2, c3, c4, c5, i;
  cin >> c1 >> c2 >> c3 >> c4 >> c5;
  i = c1 + c2 + c3 + c4 + c5;
  if (i == 0) {
    cout << "-1" << endl;
  } else if (i % 5 == 0) {
    cout << (i / 5) << endl;
  } else {
    cout << "-1" << endl;
  }
  return 0;
}
