#include <bits/stdc++.h>
using namespace std;
const long double eps = 1e-7;
const long long int m = 1000000007;
void solve() {
  int own, dow, len;
  cin >> own >> dow >> len;
  own -= dow;
  own *= len;
  if (own % dow)
    cout << own / dow + 1 << '\n';
  else
    cout << own / dow << '\n';
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
