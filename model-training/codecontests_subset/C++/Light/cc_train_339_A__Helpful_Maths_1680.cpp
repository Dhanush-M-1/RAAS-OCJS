#include <bits/stdc++.h>
using namespace std;
const int MN = 10e5 + 10;
int x[MN];
int main() {
  string s;
  cin >> s;
  int j = 0;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == '1') {
      x[j] = 1;
      j++;
    } else if (s[i] == '2') {
      x[j] = 2;
      j++;
    } else if (s[i] == '3') {
      x[j] = 3;
      j++;
    }
  }
  sort(x, x + j);
  for (int i = 0; i < j; i++)
    if (j - 1 == i) {
      cout << x[i];
      return 0;
    } else
      cout << x[i] << "+";
  return 0;
}
