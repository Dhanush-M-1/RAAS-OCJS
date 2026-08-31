#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int loc, curM;
  int ans = 1;
  while (n--) {
    cin >> loc;
    if (loc > 500000) {
      curM = 1000000 - loc;
    } else {
      curM = loc - 1;
    }
    if (ans < curM) ans = curM;
  }
  cout << ans;
  return 0;
}
