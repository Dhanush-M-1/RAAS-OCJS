#include <bits/stdc++.h>
using namespace std;
const int inf = 0x20202020;
const int mod = 1000000007;
template <class T>
inline void read(T& x) {
  bool fu = 0;
  char c;
  for (c = getchar(); c <= 32; c = getchar())
    ;
  if (c == '-') fu = 1, c = getchar();
  for (x = 0; c > 32; c = getchar()) x = x * 10 + c - '0';
  if (fu) x = -x;
};
template <class T>
inline void read(T& x, T& y) {
  read(x);
  read(y);
}
template <class T>
inline void read(T& x, T& y, T& z) {
  read(x);
  read(y);
  read(z);
}
template <class T>
inline void read(T& x, T& y, T& z, T& q) {
  read(x);
  read(y);
  read(z);
  read(q);
}
const int DX[] = {1, 0, -1, 0}, DY[] = {0, 1, 0, -1};
long long powmod(long long a, long long b) {
  long long res = 1;
  a %= mod;
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
long long powmod(long long a, long long b, long long mod) {
  long long res = 1;
  a %= mod;
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
int main() {
  map<int, pair<int, int> > m;
  string s;
  int t, mi, n, x = 0;
  read(t, mi);
  int a[mi + 1], noz[mi + 1];
  memset(a, 0, sizeof(a));
  memset(noz, 0, sizeof(noz));
  while (t--) {
    cin >> s;
    if (s == "alloc") {
      read(n);
      int in, flag = 0, cnt = 0;
      for (int i = 0; i < mi; i++) {
        if (a[i] == 0) {
          cnt++;
        } else {
          cnt = 0;
        }
        if (cnt == n) {
          flag = 1;
          in = i - cnt + 1;
          break;
        }
      }
      if (flag == 1) {
        for (int i = 0; i < n; i++) {
          a[in + i] = 1;
        }
        x++;
        m[x] = make_pair(in, n);
        cout << x << endl;
      } else {
        cout << "NULL\n";
      }
    } else if (s == "erase") {
      read(n);
      if (m.find(n) != m.end()) {
        int z = m[n].first, y = m[n].second;
        for (int i = z; i < z + y; i++) {
          a[i] = 0;
        }
        m.erase(n);
      } else {
        cout << "ILLEGAL_ERASE_ARGUMENT\n";
      }
    } else {
      if (a[0] == 0) {
        noz[0] = 1;
      } else {
        noz[0] = 0;
      }
      for (int i = 1; i < mi; i++) {
        if (a[i] == 0) {
          noz[i] = 1 + noz[i - 1];
        } else {
          noz[i] = noz[i - 1];
        }
      }
      memset(a, 0, sizeof(a));
      map<int, pair<int, int> >::iterator it;
      for (it = m.begin(); it != m.end(); it++) {
        it->second.first -= noz[it->second.first];
      }
      for (int i = 0; i < mi - noz[mi - 1]; i++) {
        a[i] = 1;
      }
    }
  }
  return 0;
}
