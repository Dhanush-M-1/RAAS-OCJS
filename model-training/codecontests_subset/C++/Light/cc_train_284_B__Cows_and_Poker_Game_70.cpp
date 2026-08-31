#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int I = 0, F = 0, A = 0;
  for (auto ch : s) {
    if (ch == 'A')
      A += 1;
    else if (ch == 'I')
      I += 1;
    else
      F += 1;
  }
  if (I == 0) {
    cout << A << endl;
    return 0;
  }
  if (I > 0) {
    if (I == 1)
      cout << 1 << endl;
    else
      cout << 0 << endl;
  }
  return 0;
}
