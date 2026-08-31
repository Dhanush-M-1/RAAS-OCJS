#include <bits/stdc++.h>
using namespace std;
inline long long power(long long a, long long b) {
  long long x = 1;
  a = a % 1000000007ULL;
  while (b) {
    if (b & 1) x = (x * a) % 1000000007ULL;
    a = (a * a) % 1000000007ULL;
    b >>= 1;
  }
  return x;
}
inline long long inv(long long a) { return power(a, 1000000007ULL - 2); }
long long gcd(long long a, long long b) { return a ? gcd(b % a, a) : b; }
const int N = 1e5 + 5;
int main() {
  ios_base::sync_with_stdio(false);
  int a = 0, b = 0, c = 0, d = 0;
  int dir = 0, tmp;
  cout << "? 0 0" << endl;
  fflush(stdout);
  int res;
  cin >> dir;
  fflush(stdout);
  int i = 29;
  while (i > -1) {
    if (dir == 0) break;
    tmp = 1 << i;
    c = tmp | a;
    d = tmp | b;
    cout << "? " << c << " " << d << endl;
    fflush(stdout);
    cin >> res;
    fflush(stdout);
    if (res != dir) {
      if (dir == 1)
        a |= tmp;
      else
        b |= tmp;
      cout << "? " << a << " " << b << endl;
      fflush(stdout);
      cin >> dir;
      fflush(stdout);
    } else {
      c = tmp | a;
      d = b;
      cout << "? " << c << " " << d << endl;
      fflush(stdout);
      cin >> res;
      fflush(stdout);
      if (res == -1) {
        a |= tmp;
        b |= tmp;
      }
    }
    i--;
  }
  fflush(stdout);
  while (i > -1) {
    tmp = 1 << i;
    c = tmp | a;
    d = b;
    cout << "? " << c << " " << d << endl;
    fflush(stdout);
    cin >> res;
    fflush(stdout);
    if (res == -1) {
      a |= tmp;
      b |= tmp;
    }
    i--;
  }
  cout << "! " << a << " " << b << endl;
  return 0;
}
