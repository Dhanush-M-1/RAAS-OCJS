#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  unsigned int c = 0;
  unsigned int d = 0;
  unsigned int a = 0;
  unsigned int b = 0;
  int ans;
  cout << "? " << c << " " << d << endl;
  cin >> ans;
  for (long long i = 29; i >= 0; --i) {
    if (ans == 0) break;
    unsigned int mask = 1 << i;
    unsigned int tc = c | mask;
    unsigned int td = d | mask;
    int tmp;
    cout << "? " << tc << " " << td << endl;
    cin >> tmp;
    if (ans != tmp) {
      if (ans == 1) {
        a = a | mask;
        c = tc;
      } else {
        b = b | mask;
        d = td;
      }
      cout << "? " << c << " " << d << endl;
      cin >> ans;
    }
  }
  for (long long i = 29; i >= 0; --i) {
    unsigned int mask = 1 << i;
    if (((a & mask) > 0) || ((b & mask) > 0)) continue;
    unsigned int tc = c | mask;
    cout << "? " << tc << " " << d << endl;
    cin >> ans;
    if (ans == -1) {
      a = a | mask;
      b = b | mask;
    }
  }
  cout << "! " << a << " " << b << endl;
  return 0;
}
