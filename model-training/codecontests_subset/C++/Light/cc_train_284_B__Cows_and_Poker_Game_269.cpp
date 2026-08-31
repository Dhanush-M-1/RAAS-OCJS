#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n;
  cin >> n;
  string s;
  cin >> s;
  long long a = 0, b = 0, c = 0;
  for (auto i : s) {
    if (i == 'I')
      b++;
    else if (i == 'A')
      a++;
    else
      c++;
  }
  if (b >= 2) {
    return cout << 0, 0;
  }
  if (b)
    cout << 1;
  else
    cout << a;
}
