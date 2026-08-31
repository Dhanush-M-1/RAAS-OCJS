#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int x;
  cin >> s >> x;
  for (auto &x : s) x = tolower(x);
  for (auto &X : s) {
    int _19 = X;
    if (_19 < x + 97) X = toupper(X);
  }
  cout << s;
}
