#include <bits/stdc++.h>
using namespace std;
int main() {
  int num, w1 = 0, w2 = 0, wt;
  cin >> num;
  for (int a1 = 1; a1 <= num; a1++) {
    cin >> wt;
    if (wt == 100) {
      w1++;
    } else {
      w2++;
    }
  }
  if ((w2 % 2 == 1) && (w1 == 0)) {
    cout << "NO";
  } else if ((w2 % 2 == 0) && (w1 % 2 == 0)) {
    cout << "YES";
  } else if ((w2 % 2 == 1) && (w1 % 2 == 0)) {
    cout << "YES";
  } else if ((w2 % 2 == 1) && (w1 % 2 == 1)) {
    cout << "NO";
  } else {
    cout << "NO";
  }
  return 0;
}
