#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long q, p1 = -1, p2 = -1;
  cin >> q;
  long long r = q;
  for (long long i = 2; i <= sqrt(q); i++) {
    while (q % i == 0) {
      q /= i;
      if (p1 == -1)
        p1 = i;
      else if (p2 == -1)
        p2 = i;
      if (p2 != -1 and p1 * p2 != r) {
        cout << 1 << endl;
        cout << p1 * p2;
        return;
      }
    }
  }
  if (p1 != -1)
    cout << 2;
  else {
    cout << 1 << endl;
    cout << 0;
  }
}
int main() {
  long long t = 1;
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  while (t--) solve();
}
