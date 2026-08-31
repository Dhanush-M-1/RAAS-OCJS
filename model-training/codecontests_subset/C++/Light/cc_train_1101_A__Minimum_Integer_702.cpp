#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  while (n--) {
    int l, r, a;
    cin >> l >> r >> a;
    if (l > a)
      cout << a << endl;
    else
      cout << ((r / a + 1) * a) << endl;
  }
  return 0;
}
