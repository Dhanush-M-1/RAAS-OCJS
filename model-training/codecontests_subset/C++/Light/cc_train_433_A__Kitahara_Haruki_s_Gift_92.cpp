#include <bits/stdc++.h>
using namespace std;
const int MAXN = 5 * 1e4 + 10;
int main() {
  int n;
  cin >> n;
  int b, c;
  b = 0;
  c = 0;
  while (n--) {
    int a;
    cin >> a;
    if (a == 100)
      b++;
    else
      c++;
  }
  if ((2 * c + b) % 2 != 0) {
    cout << "NO\n";
    return 0;
  }
  c = c % 2;
  if (c == 1 && b >= 2) {
    c = 0;
    b -= 2;
  } else if (c == 1) {
    cout << "NO\n";
    return 0;
  }
  if (b % 2 == 0) {
    cout << "YES\n";
  } else {
    cout << "NO\n";
  }
  return 0;
}
