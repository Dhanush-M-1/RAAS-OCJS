#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e17 + 9;
long long n, l, r;
void calc(long long ly, long long faltl, long long faltr) {
  if (ly == n) {
    r = 1;
  } else if (faltl >= 2 * n - ly * 2) {
    calc(ly + 1, faltl - 2 * n + ly * 2, faltr);
  } else {
    long long ind = ly + 1;
    long long guard = 0;
    for (long long i = 0; i < 2 * n - ly * 2 && faltl > 0; i++) {
      if (i % 2) ind++;
      faltl--;
      guard = i + 1;
    }
    for (long long i = guard; i < 2 * n - ly * 2 && faltr > 0; i++) {
      if (i % 2)
        cout << ind++ << " ";
      else
        cout << ly << " ";
      faltr--;
    }
    if (faltr > 0 && ly < n - 1) {
      calc(ly + 1, faltl, faltr);
    } else {
      r = faltr;
    }
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long t;
  cin >> t;
  while (t--) {
    cin >> n >> l >> r;
    calc(1, l - 1, r - l + 1);
    if (r == 1)
      cout << 1 << '\n';
    else
      cout << '\n';
  }
  return 0;
}
