#include <bits/stdc++.h>
using namespace std;
inline void fast() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
}
int main() {
  fast();
  long long q;
  cin >> q;
  while (q--) {
    long long l, r, d;
    cin >> l >> r >> d;
    long long lower = l - 1;
    long long upper = r + 1;
    if (lower > 0) {
      long long rem = lower % d;
      if (lower - rem > 0) {
        cout << d << endl;
        continue;
      }
    }
    long long rem = upper % d;
    if (rem == 0) {
      cout << upper << endl;
      continue;
    }
    cout << upper + d - rem << endl;
  }
}
