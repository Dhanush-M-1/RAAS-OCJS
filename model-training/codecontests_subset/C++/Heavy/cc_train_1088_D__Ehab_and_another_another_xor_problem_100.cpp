#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1e9 + 7;
template <class T>
inline bool MX(T &l, const T &r) {
  return l < r ? l = r, 1 : 0;
}
template <class T>
inline bool MN(T &l, const T &r) {
  return l > r ? l = r, 1 : 0;
}
bool rev = false;
long long C, D;
bool same = false;
long long query(long long a, long long b) {
  if (rev) swap(a, b);
  cout << "? " << a + C << " " << b + D << endl;
  long long x;
  cin >> x;
  if (rev) x *= -1;
  if (x == 0) same = true;
  return x;
}
void add(long long a, long long b) {
  if (rev) swap(a, b);
  C += a;
  D += b;
}
signed main() {
  if (query(0, 0) == -1) rev = true;
  for (int i = int(30) - 1; i >= (0); --i) {
    if (same) {
      rev = false;
      if (query(1 << i, 0) == 1)
        ;
      else
        add(1 << i, 1 << i);
      continue;
    }
    long long ans = query(1 << i, 1 << i);
    if (ans == 0) {
      i--;
      same = true;
      continue;
    }
    if (ans == 1) {
      ans = query(1 << i, 0);
      if (ans == 1) {
      } else if (ans == 0) {
      } else {
        add(1 << i, 1 << i);
      }
    } else {
      add(1 << i, 0);
      if (query(0, 0) == -1) rev ^= true;
    }
  }
  cout << "! " << C << " " << D << endl;
  ios_base::sync_with_stdio(false);
  cout << fixed << setprecision(0);
}
