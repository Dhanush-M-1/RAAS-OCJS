#include <bits/stdc++.h>
using namespace std;
const double EPS = 1e-7;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  ;
  int n, k, a, maxi = 0;
  cin >> n >> k;
  while (n--) {
    cin >> a;
    if (k % a == 0) maxi = max(maxi, a);
  }
  cout << ceil((double)k / maxi) << endl;
  return 0;
}
