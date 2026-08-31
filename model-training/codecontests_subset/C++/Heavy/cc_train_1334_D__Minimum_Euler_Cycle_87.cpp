#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int main() {
  int t;
  ll n, st, dr;
  cin >> t;
  while (t--) {
    cin >> n >> st >> dr;
    int deAfisat = 0;
    if (dr == n * (n - 1) + 1) {
      deAfisat = 1;
      dr--;
    }
    if (st == 1 && dr == 1) {
      cout << 1 << '\n';
      continue;
    }
    if (dr < st) {
      cout << 1 << '\n';
      continue;
    }
    ll i;
    for (i = 1;; i++) {
      if (2 * (n - i) >= st) break;
      st -= 2 * (n - i);
      dr -= 2 * (n - i);
    }
    ll j = i + (st - 1) / 2 + 1;
    if (st % 2 == 0) {
      cout << j << ' ';
      dr--;
    } else {
      cout << i << ' ' << j << ' ';
      dr -= 2;
    }
    j++;
    if (j == n + 1) {
      i++;
      j = i + 1;
    }
    while (dr >= st) {
      if (dr == st) {
        cout << i << ' ';
        break;
      }
      cout << i << ' ' << j << ' ';
      dr -= 2;
      j++;
      if (j == n + 1) {
        i++;
        j = i + 1;
      }
    }
    if (deAfisat) cout << 1;
    cout << '\n';
  }
  return 0;
}
