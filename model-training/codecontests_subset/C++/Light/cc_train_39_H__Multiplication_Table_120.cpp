#include <bits/stdc++.h>
using namespace std;
string number(int n, int radix, int j) {
  string s("");
  while (n > 0) {
    int rem = n % radix;
    rem = rem + 48;
    char x = rem;
    s = x + s;
    n = n / radix;
  }
  if ((s.length() == 1) && (j != 1)) s = " " + s;
  return s;
}
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n - 1; i++) {
    for (int j = 1; j <= n - 1; j++) {
      cout << number(i * j, n, j) << " ";
    }
    cout << endl;
  }
}
