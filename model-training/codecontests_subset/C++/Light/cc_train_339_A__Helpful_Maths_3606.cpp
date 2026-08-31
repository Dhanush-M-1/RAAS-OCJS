#include <bits/stdc++.h>
using namespace std;
int main(int argc, char** argv) {
  int i, n;
  string x, y[10] = {"+"};
  cin >> x;
  sort(x.begin(), x.end());
  n = x.length() / 2;
  for (i = n; i < x.size(); i++) {
    if (i < x.length() - 1)
      cout << x[i] << "+";
    else
      cout << x[i];
  }
  return 0;
}
