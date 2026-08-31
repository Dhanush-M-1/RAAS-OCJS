#include <bits/stdc++.h>
using namespace std;
string f(int x, int b) {
  string s = "";
  while (x) {
    s += x % b + '0';
    x /= b;
  }
  reverse(s.begin(), s.end());
  return s;
}
int main() {
  int k;
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) cout << f(i * j, k) << ' ';
    cout << endl;
  }
  return 0;
}
