#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  char s;
  int a = 0, i = 0;
  for (int j = 0; j < n; j++) {
    cin >> s;
    if (s == 'A') {
      a++;
    } else if (s == 'I') {
      i++;
    }
  }
  if (i == 1) {
    cout << 1 << endl;
  } else if (i == 0) {
    cout << a << endl;
  } else {
    cout << 0 << endl;
  }
  return 0;
}
