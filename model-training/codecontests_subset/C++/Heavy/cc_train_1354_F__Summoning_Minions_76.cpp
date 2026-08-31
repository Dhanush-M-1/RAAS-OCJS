#include <bits/stdc++.h>
using namespace std;
long long inf;
const double eps = 1e-8;
const double pi = acos(-1.0);
template <class T, class T2>
long long chkmin(T &a, T2 b) {
  return a > b ? a = b, 1 : 0;
}
template <class T, class T2>
long long chkmax(T &a, T2 b) {
  return a < b ? a = b, 1 : 0;
}
template <class T>
T sqr(T a) {
  return a * a;
}
template <class T, class T2>
T mmin(T a, T2 b) {
  return a < b ? a : b;
}
template <class T, class T2>
T mmax(T a, T2 b) {
  return a > b ? a : b;
}
template <class T>
T aabs(T a) {
  return a < 0 ? -a : a;
}
template <class T>
long long dcmp(T a, T b) {
  return a > b;
}
template <long long *a>
long long cmp_a(long long first, long long second) {
  return a[first] < a[second];
}
struct __INIT__ {
  __INIT__() { memset(&inf, 0x3f, sizeof(inf)); }
} __INIT___;
namespace io {
const long long SIZE = (1 << 21) + 1;
char ibuf[SIZE], *iS, *iT, obuf[SIZE], *oS = obuf, *oT = oS + SIZE - 1, c,
                                       qu[55];
long long f, qr;
inline void flush() {
  fwrite(obuf, 1, oS - obuf, stdout);
  oS = obuf;
}
inline void putc(char first) {
  *oS++ = first;
  if (oS == oT) flush();
}
template <typename A>
inline bool read(A &first) {
  for (f = 1, c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                              (iS == iT ? EOF : *iS++))
                            : *iS++);
       c < '0' || c > '9';
       c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                       (iS == iT ? EOF : *iS++))
                     : *iS++))
    if (c == '-')
      f = -1;
    else if (c == EOF)
      return 0;
  for (first = 0; c <= '9' && c >= '0';
       c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                       (iS == iT ? EOF : *iS++))
                     : *iS++))
    first = first * 10 + (c & 15);
  first *= f;
  return 1;
}
inline bool read(char &first) {
  while ((first = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                               (iS == iT ? EOF : *iS++))
                            : *iS++)) == ' ' ||
         first == '\n' || first == '\r')
    ;
  return first != EOF;
}
inline bool read(char *first) {
  while ((*first = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                                (iS == iT ? EOF : *iS++))
                             : *iS++)) == '\n' ||
         *first == ' ' || *first == '\r')
    ;
  if (*first == EOF) return 0;
  while (!(*first == '\n' || *first == ' ' || *first == '\r' || *first == EOF))
    *(++first) = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                              (iS == iT ? EOF : *iS++))
                           : *iS++);
  *first = 0;
  return 1;
}
template <typename A, typename... B>
inline bool read(A &first, B &...second) {
  return read(first) && read(second...);
}
template <typename A>
inline bool write(A first) {
  if (!first) putc('0');
  if (first < 0) putc('-'), first = -first;
  while (first) qu[++qr] = first % 10 + '0', first /= 10;
  while (qr) putc(qu[qr--]);
  return 0;
}
inline bool write(char first) {
  putc(first);
  return 0;
}
inline bool write(const char *first) {
  while (*first) {
    putc(*first);
    ++first;
  }
  return 0;
}
inline bool write(char *first) {
  while (*first) {
    putc(*first);
    ++first;
  }
  return 0;
}
template <typename A, typename... B>
inline bool write(A first, B... second) {
  return write(first) || write(second...);
}
struct Flusher_ {
  ~Flusher_() { flush(); }
} io_flusher_;
}  // namespace io
using io ::putc;
using io ::read;
using io ::write;
pair<pair<long long, long long>, long long> a[85];
long long sel[85];
long long f[85][85], las[85][85];
signed main() {
  long long t;
  read(t);
  long long n, k;
  for (; t; --t) {
    read(n, k);
    for (long long i = 1; i <= n; ++i) {
      read(a[i].first.second, a[i].first.first);
      a[i].second = i;
    }
    sort(a + 1, a + n + 1);
    memset(f, -0x3f, sizeof(f));
    long long w = 0;
    for (long long i = 1; i <= n; ++i) w += a[i].first.first * (k - 1);
    f[0][0] = w;
    for (long long i = 0; i < n; ++i) {
      for (long long j = 0; j <= i && j <= k; ++j) {
        if (chkmax(f[i + 1][j + 1], f[i][j] +
                                        a[i + 1].first.first * (j - k + 1) +
                                        a[i + 1].first.second))
          las[i + 1][j + 1] = 1;
        if (chkmax(f[i + 1][j], f[i][j])) las[i + 1][j] = 0;
      }
    }
    for (long long i = n, j = k; i; --i) {
      if (las[i][j]) {
        sel[i] = j;
        --j;
      } else
        sel[i] = 0;
    }
    write(n + n - k, '\n');
    for (long long i = 1; i <= n; ++i) {
      if (sel[i] && sel[i] < k) write(a[i].second, ' ');
    }
    for (long long i = 1; i <= n; ++i)
      if (!sel[i]) write(a[i].second, ' ', -a[i].second, ' ');
    for (long long i = 1; i <= n; ++i)
      if (sel[i] == k) write(a[i].second, '\n');
  }
  return 0;
}
