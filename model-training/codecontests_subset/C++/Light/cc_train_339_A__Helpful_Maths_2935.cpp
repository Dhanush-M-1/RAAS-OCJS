#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b, c;
  cin >> a;
  for (size_t i = 0; i < a.length(); i++)
    if (a[i] != '+') {
      b += a[i];
    }
  sort(b.begin(), b.end());
  for (size_t i = 0; i < b.length(); i++) {
    c = c + b[i];
    if (c.length() < a.length()) c += '+';
  }
  cout << c;
  return 0;
}
