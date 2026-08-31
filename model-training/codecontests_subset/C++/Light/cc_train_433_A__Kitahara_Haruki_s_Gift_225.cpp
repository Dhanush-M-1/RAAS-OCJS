#include <bits/stdc++.h>
using namespace std;
int a1[3] = {0};
int main() {
  int n, ans = 0;
  vector<int> vec;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    vec.push_back(x);
    ans += x / 100;
    a1[(x / 100) - 1]++;
  }
  int cn = 0;
  if (ans % 2 != 0)
    cout << "NO";
  else {
    if (a1[0] == 0) {
      if (a1[1] % 2 == 0) cn = 1;
    } else if (a1[1] == 0) {
      if (a1[0] % 2 == 0) cn = 1;
    } else {
      for (int il = 1; il <= (a1[0] + 2 * a1[1]) / 2; il++) {
        ans = a1[0] + (2 * a1[1]) - il;
        ans -= il;
        if (ans == 0) {
          cn = 1;
          break;
        }
      }
    }
    if (cn == 1)
      cout << "YES\n";
    else
      cout << "NO\n";
  }
  return 0;
}
