#include <bits/stdc++.h>
using namespace std;
int k;
string fun(int d) {
  string a;
  while (d != 0) {
    a += '0' + d % k;
    d /= k;
  }
  reverse(a.begin(), a.end());
  return a;
}
int main() {
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      cout << fun(i * j);
      if (j != k - 1) cout << " ";
    }
    cout << endl;
  }
  return 0;
}
