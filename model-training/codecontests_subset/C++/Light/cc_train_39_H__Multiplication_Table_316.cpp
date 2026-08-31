#include <bits/stdc++.h>
using namespace std;
string Change(int x, int base) {
  string res;
  while (x) {
    res = char('0' + x % base) + res;
    x /= base;
  }
  return res;
}
int main() {
  int n;
  cin >> n;
  for (int i = 1; i < n; ++i) {
    for (int j = 1; j < n; ++j) {
      cout << Change((i) * (j), n) << " ";
    }
    cout << endl;
  }
  return 0;
}
