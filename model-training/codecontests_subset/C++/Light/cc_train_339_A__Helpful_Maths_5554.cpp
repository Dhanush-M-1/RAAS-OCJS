#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, x = "";
  int c = 0;
  cin >> a;
  for (int i = 0; i < a.size(); i++) {
    if (a[i] == '+') {
      c++;
    } else
      x += a[i];
  }
  sort(x.begin(), x.end());
  for (int i = 0; i < (a.size() - c); i++) {
    if (i == (a.size() - c - 1))
      cout << x[i] << endl;
    else
      cout << x[i] << "+";
  }
  return 0;
}
