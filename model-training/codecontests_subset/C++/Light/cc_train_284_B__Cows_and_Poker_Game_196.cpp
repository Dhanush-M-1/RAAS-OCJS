#include <bits/stdc++.h>
using namespace std;
int main() {
  int ara[3], i, n;
  char ch;
  cin >> n;
  ara[0] = ara[1] = ara[2] = 0;
  for (i = 0; i < n; i++) {
    cin >> ch;
    if (ch == 'A')
      ara[0]++;
    else if (ch == 'I')
      ara[1]++;
    else
      ara[2]++;
  }
  if (ara[1] > 1) {
    cout << 0 << endl;
  } else if (ara[1]) {
    cout << 1 << endl;
  } else {
    cout << ara[0] << endl;
  }
  return 0;
}
