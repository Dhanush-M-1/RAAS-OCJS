#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, h1 = 0, h2 = 0, x;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x;
    if (x == 100)
      h1++;
    else
      h2++;
  }
  if ((h1 + 2 * h2) % 2 != 0) {
    cout << "NO";
    return 0;
  }
  if (n % 2 == 0 && h1 % 2 != h2 % 2) {
    cout << "NO";
    return 0;
  }
  if (h1 == 0 && h2 % 2 != 0) {
    cout << "NO";
    return 0;
  }
  if (h2 == 0 && h1 % 2 != 0) {
    cout << "NO";
    return 0;
  }
  cout << "YES";
}
