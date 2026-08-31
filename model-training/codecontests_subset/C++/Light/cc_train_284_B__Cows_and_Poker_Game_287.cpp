#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int n;
  cin >> n;
  int count = 0;
  string str;
  cin >> str;
  int A = 0;
  int F = 0;
  int I = 0;
  for (int i = 0; i < n; i++) {
    if (str[i] == 'A') {
      A++;
    } else if (str[i] == 'F') {
      F++;
    } else if (str[i] == 'I') {
      I++;
    }
  }
  if (I == 0) {
    cout << A;
    return 0;
  }
  if (I > 1) {
    cout << 0;
    return 0;
  }
  cout << I;
  return 0;
}
