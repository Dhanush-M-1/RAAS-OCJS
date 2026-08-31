#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
void solveCP311() {
  ll a, b, c;
  cin >> a >> b >> c;
  ll need = c * a;
  for (ll wait = 0;; wait++) {
    ll store = wait * b;
    bool f = 1;
    for (ll i = 1; i <= c; i++) {
      store += b;
      if (store < a) {
        f = 0;
        break;
      }
      store -= a;
    }
    if (f) {
      cout << wait;
      return;
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ll t = 1;
  while (t--) {
    solveCP311();
  }
  return 0;
}
