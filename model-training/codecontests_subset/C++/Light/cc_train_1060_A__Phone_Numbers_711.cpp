#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x = 0, y = 0;
  string a;
  cin >> n;
  cin >> a;
  x = n / 11;
  y = count(a.begin(), a.end(), '8');
  if (y >= x) {
    cout << x;
  } else {
    cout << y;
  }
}
