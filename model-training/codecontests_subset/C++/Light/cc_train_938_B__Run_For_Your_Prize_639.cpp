#include <bits/stdc++.h>
using namespace std;
string s;
int main() {
  ios_base::sync_with_stdio(0);
  int n;
  cin >> n;
  int maxl = 1, minr = 1e6;
  for (int i = 0; i < n; i++) {
    int t;
    cin >> t;
    if (t <= 5e5)
      maxl = max(maxl, t);
    else
      minr = min(minr, t);
  }
  cout << max(maxl - 1, (int)1e6 - minr);
  return 0;
}
