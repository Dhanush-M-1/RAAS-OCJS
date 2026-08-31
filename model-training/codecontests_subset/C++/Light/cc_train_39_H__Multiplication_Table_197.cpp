#include <bits/stdc++.h>
using namespace std;
int k;
string get(int x) {
  string s;
  while (x) {
    s += char(x % k + '0');
    x /= k;
  }
  reverse(s.begin(), s.end());
  return s;
}
int main() {
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      cout << get(i * j) << " ";
    }
    cout << endl;
  }
  return 0;
}
