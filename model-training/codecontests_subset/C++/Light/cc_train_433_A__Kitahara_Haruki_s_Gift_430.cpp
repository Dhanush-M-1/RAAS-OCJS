#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  int two, one;
  two = one = 0;
  for (int i = 1; i <= n; ++i) {
    int x;
    cin >> x;
    if (x == 100)
      one++;
    else
      two++;
  }
  if (one % 2 == 1) {
    cout << "NO\n";
  } else if (two % 2 == 1) {
    if (one >= 2)
      cout << "YES\n";
    else
      cout << "NO\n";
  } else
    cout << "YES\n";
}
