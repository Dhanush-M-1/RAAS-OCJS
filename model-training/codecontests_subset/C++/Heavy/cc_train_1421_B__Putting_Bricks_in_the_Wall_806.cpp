#include <bits/stdc++.h>
using namespace std;
namespace IO {
const int SIZE = (1 << 20) + 1;
char ibuf[SIZE], *iS, *iT, obuf[SIZE], *oS = obuf, *oT = obuf + SIZE - 1;
char _st[55];
int _qr = 0;
inline char gc() {
  return (iS == iT ? iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
          (iS == iT ? EOF : *iS++) : *iS++);
}
inline void qread() {}
template <class T1, class... T2>
inline void qread(T1& IEE, T2&... ls) {
  register T1 __ = 0, ___ = 1;
  register char ch;
  while (!isdigit(ch = gc())) ___ = (ch == '-') ? -___ : ___;
  do {
    __ = (__ << 1) + (__ << 3) + (ch ^ 48);
  } while (isdigit(ch = gc()));
  __ *= ___;
  IEE = __;
  qread(ls...);
  return;
}
template <class T>
inline void qreadarr(T beg, T end) {
  while (beg != end) {
    qread(*beg);
    beg++;
  }
}
inline void flush() {
  fwrite(obuf, 1, oS - obuf, stdout);
  oS = obuf;
  return;
}
inline void putc_(char _x) {
  *oS++ = _x;
  if (oS == oT) flush();
}
inline void qwrite() {}
template <class T1, class... T2>
inline void qwrite(T1 IEE, T2... ls) {
  if (!IEE) putc_('0');
  if (IEE < 0) putc_('-'), IEE = -IEE;
  while (IEE) _st[++_qr] = IEE % 10 + '0', IEE /= 10;
  while (_qr) putc_(_st[_qr--]);
  qwrite(ls...);
  return;
}
inline void putstr_(const char* IEE) {
  int p = 0;
  while (IEE[p] != '\0') {
    putc_(IEE[p++]);
  }
}
inline void puts_(const char* IEE) {
  putstr_(IEE);
  putc_('\n');
}
template <class T>
inline void qwritearr(T beg, T end, const char* IEE = {" "},
                      const char* EE = {"\n"}) {
  while (beg != end) {
    qwrite(*beg);
    beg++;
    putstr_(IEE);
  }
  putstr_(EE);
}
struct Flusher_ {
  ~Flusher_() { flush(); }
} io_flusher;
}  // namespace IO
using namespace IO;
const int N = 205;
char str[N][N];
void Solve() {
  int n;
  cin >> n;
  for (register int(i) = 1; (i) <= n; (i)++) cin >> str[i] + 1;
  if (str[1][2] != str[2][1]) {
    if (str[1][2] == '1') {
      if (str[n][n - 1] == str[n - 1][n]) {
        if (str[n][n - 1] == '1') {
          cout << 1 << endl;
          cout << 1 << " " << 2 << endl;
        } else {
          cout << 1 << endl;
          cout << 2 << " " << 1 << endl;
        }
      } else {
        cout << 2 << endl;
        cout << 2 << " " << 1 << endl;
        if (str[n][n - 1] == '1')
          cout << n << " " << n - 1 << endl;
        else
          cout << n - 1 << " " << n << endl;
      }
    } else {
      if (str[n][n - 1] == str[n - 1][n]) {
        if (str[n][n - 1] == '1') {
          cout << 1 << endl;
          cout << 2 << " " << 1 << endl;
        } else {
          cout << 1 << endl;
          cout << 1 << " " << 2 << endl;
        }
      } else {
        cout << 2 << endl;
        cout << 1 << " " << 2 << endl;
        if (str[n][n - 1] == '1')
          cout << n << " " << n - 1 << endl;
        else
          cout << n - 1 << " " << n << endl;
      }
    }
  } else {
    if (str[n][n - 1] == str[n - 1][n]) {
      if (str[n][n - 1] != str[1][2])
        cout << 0 << endl;
      else {
        cout << 2 << endl;
        cout << 1 << " " << 2 << endl;
        cout << 2 << " " << 1 << endl;
      }
    } else {
      if (str[n][n - 1] == str[1][2]) {
        cout << 1 << endl;
        cout << n << " " << n - 1 << endl;
      } else {
        cout << 1 << endl;
        cout << n - 1 << " " << n << endl;
      }
    }
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) Solve();
  return 0;
}
