#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
void solveCP311() {
  ll n, w, y;
  cin >> n >> w >> y;
  cout << max((ll)0, (ll)ceil((ld)n * ((ld)y / (ld)100)) - w);
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
