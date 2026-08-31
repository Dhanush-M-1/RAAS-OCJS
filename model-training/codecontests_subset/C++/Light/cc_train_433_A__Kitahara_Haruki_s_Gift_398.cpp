#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a1 = 0, a2 = 0;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    int w;
    cin >> w;
    if (w == 100)
      ++a1;
    else
      ++a2;
  }
  if (a1 % 2 != 0 || (a2 % 2 != 0 && a1 == 0))
    cout << "NO"
         << "\n";
  else
    cout << "YES"
         << "\n";
  return 0;
}
