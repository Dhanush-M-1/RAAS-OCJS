#include <bits/stdc++.h>
using namespace std;
int main() {
  int length, a = 0, i = 0;
  string status;
  cin >> length >> status;
  for (int x = 0; x < length; x++) {
    if (status[x] == 'A') {
      a++;
    } else if (status[x] == 'I') {
      i++;
    }
  }
  if (i == 0) {
    cout << a;
  } else {
    if (i == 1) {
      cout << 1;
    } else {
      cout << 0;
    }
  }
  return 0;
}
