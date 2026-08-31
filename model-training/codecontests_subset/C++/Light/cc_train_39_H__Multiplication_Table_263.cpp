#include <bits/stdc++.h>
using namespace std;
string convert(int k, int mult) {
  string str = "";
  string str1;
  int rem;
  while (mult != 0) {
    rem = mult % k;
    str1 = to_string(rem);
    str.append(str1);
    mult /= k;
  }
  reverse(str.begin(), str.end());
  return str;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int mult, k;
  string z;
  cin >> k;
  for (int i = 0; i < (k - 1); i++) {
    for (int j = 0; j < (k - 1); j++) {
      mult = (i + 1) * (j + 1);
      z = convert(k, mult);
      cout << z << " ";
    }
    cout << "\n";
  }
  return 0;
}
