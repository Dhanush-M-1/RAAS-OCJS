#include <bits/stdc++.h>
using namespace std;
int main() {
  double tota, wizard, percent;
  cin >> tota >> wizard >> percent;
  double amount = tota * (percent / 100.0);
  amount = ceil(amount);
  if (amount <= wizard)
    cout << 0 << endl;
  else {
    int ans = amount - wizard;
    cout << ans << endl;
  }
  return 0;
}
