#include <bits/stdc++.h>
using namespace std;
const long long int inf = 1e15;
const long long int M = 1e9 + 7;
long long int a1, a2, b1, b2, c1, c2;
bool ok;
void Case() {
  long long int num = (b1 - a1) * c1 + (b2 - a2) * c2;
  long long int den = c1 * c1 + c2 * c2;
  if (c1 == 0 && c2 == 0) {
    if (num != 0) return;
    if (b1 == a1 && b2 == a2) ok = true;
    return;
  } else {
    if (num % den != 0) return;
  }
  num = (b2 - a2) * c1 - (b1 - a1) * c2;
  if (c1 == 0 && c2 == 0) {
    if (num != 0) return;
  } else {
    if (num % den != 0) return;
  }
  ok = true;
}
void solve() {
  cin >> a1 >> a2;
  cin >> b1 >> b2;
  cin >> c1 >> c2;
  ok = false;
  Case();
  long long int var = a1;
  a1 = -a2, a2 = var;
  Case();
  var = a1, a1 = -a2, a2 = var;
  Case();
  var = a1, a1 = -a2, a2 = var;
  Case();
  (ok) ? (cout << "YES") : (cout << "NO");
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
}
