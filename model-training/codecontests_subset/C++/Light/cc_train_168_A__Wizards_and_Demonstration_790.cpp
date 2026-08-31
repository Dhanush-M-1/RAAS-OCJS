#include <bits/stdc++.h>
using namespace std;
int a, b, c;
int main() {
  cin >> a >> b >> c;
  int x = (a * c);
  if (x % 100 != 0) {
    x /= 100;
    x++;
  } else {
    x /= 100;
  }
  if (x > b) {
    cout << x - b;
  } else
    cout << 0;
}
