#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cout.tie(0);
  cin.tie(0);
  int n, i, j, k, x, y, z;
  string s;
  cin >> n >> s;
  x = 0;
  for (i = 0; s[i]; ++i) x += (s[i] == '8');
  cout << min(x, n / 11) << endl;
  return 0;
}
