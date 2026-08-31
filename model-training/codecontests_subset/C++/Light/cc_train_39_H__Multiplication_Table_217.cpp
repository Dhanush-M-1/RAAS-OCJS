#include <bits/stdc++.h>
using namespace std;
int n;
string trans(int x) {
  string s = "";
  while (x) {
    s += char(x % n + '0');
    x /= n;
  }
  reverse(s.begin(), s.end());
  return s;
}
int main() {
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      cout << trans(i * j) << " ";
    }
    cout << endl;
  }
  return 0;
}
