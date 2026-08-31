#include <bits/stdc++.h>
using namespace std;
const long long N = 100100, SQ = 330, LG = 25, inf = 1e17;
long long n, m, t, k, x, y, z, w, a, b;
char c = '?';
void get() {
  cout << endl;
  cin >> x;
  if (x == -2) exit(0);
}
void solve(int k, int bit) {
  if (bit == -1) return;
  long long ax = a, bx = b;
  ax += (1 << bit);
  bx += (1 << bit);
  cout << c << ' ' << ax << ' ' << bx;
  get();
  if (x == k) {
    ax = a;
    bx = b;
    ax += (1 << bit);
    cout << c << ' ' << ax << ' ' << bx;
    get();
    if (x == -1) {
      a += (1 << bit);
      b += (1 << bit);
    }
    solve(k, bit - 1);
    return;
  } else {
    if (k == 1)
      a += (1 << bit);
    else
      b += (1 << bit);
    ax = a;
    bx = b;
    cout << c << ' ' << ax << ' ' << bx;
    get();
    solve(x, bit - 1);
    return;
  }
}
int main() {
  cout << c << ' ' << 0 << ' ' << 0;
  get();
  solve(x, 29);
  cout << "! " << a << ' ' << b << endl;
  return 0;
}
