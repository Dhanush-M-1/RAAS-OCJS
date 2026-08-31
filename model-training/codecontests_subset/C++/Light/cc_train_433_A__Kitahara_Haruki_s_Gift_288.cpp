#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, sum, val, tw, on;
  cin >> n;
  on = 0;
  tw = 0;
  while (n--) {
    cin >> val;
    if (val == 200)
      tw += 1;
    else
      on += 1;
  }
  if (on > 1 && on % 2 == 0)
    cout << "YES" << endl;
  else if (on == 0 && tw % 2 == 0)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
