#include <bits/stdc++.h>
using namespace std;
int main(void) {
  string a, b;
  cin >> a;
  for (char i : a) {
    if (i != '+') b += i;
  }
  sort(b.begin(), b.end());
  for (int i = 0; i < b.size() - 1; i++) {
    cout << b[i] << "+";
  }
  cout << b[b.size() - 1];
}
