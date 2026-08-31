#include <bits/stdc++.h>
using namespace std;
void solve() {
  long double n, x;
  long double y;
  cin >> n >> x >> y;
  long long int req = 0;
  if (((n * y) / 100 - (int)(n * y) / 100) == 0) {
    req = (n * y) / 100;
  } else {
    req = (n * y) / 100;
    req += 1;
  }
  if (x >= req)
    cout << 0;
  else
    cout << req - x;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long TESTS = 1;
  while (TESTS--) {
    solve();
  }
  return 0;
}
