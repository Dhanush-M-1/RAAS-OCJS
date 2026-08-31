#include <bits/stdc++.h>
using namespace std;
int a = 0, b = 0;
int play(int id, int nw, int &cur) {
  int x, y;
  cout << "? " << cur + (1 << id) << ' ' << (1 << id) << endl;
  cin >> x;
  cout << "? " << cur + (1 << id) << ' ' << 0 << endl;
  cin >> y;
  if (x == nw &&
          (nw == -1 && y == nw || nw == 1 && y != nw || nw == 0 && y == -1) ||
      x != nw && nw == 1)
    a += (1 << id);
  if (x != nw && nw == -1 ||
      x == nw &&
          (nw == -1 && y == nw || nw == 1 && y != nw || nw == 0 && y == -1))
    b += (1 << id);
  if (x != nw) cur += (1 << id);
  if (x == nw) return x;
  return y;
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0);
  cout << "? " << 0 << ' ' << 0 << endl;
  int nw, cur = 0;
  cin >> nw;
  for (int i = 29; i >= 0; i--) nw = play(i, nw, cur);
  cout << "! " << a << ' ' << b << endl;
  return 0;
}
