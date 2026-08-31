#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b;
  cin >> a;
  for (auto i : a)
    if (isdigit(i)) b += i;
  sort(b.begin(), b.end());
  for (int i = 0; i < b.size(); i++) {
    if (i != 0) cout << "+";
    cout << b[i];
  }
}
