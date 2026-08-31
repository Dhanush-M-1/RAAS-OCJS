#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, x, c1 = 0, c2 = 0;
  bool flag = false;
  cin >> n;
  while (n--) {
    cin >> x;
    if (x == 100)
      ++c1;
    else
      ++c2;
  }
  if (c1 % 2 == 0) {
    if ((c1 == 0 && c2 % 2 == 0) || (c1 > 0)) flag = true;
  }
  if (flag) {
    cout << "YES";
  } else
    cout << "NO";
}
