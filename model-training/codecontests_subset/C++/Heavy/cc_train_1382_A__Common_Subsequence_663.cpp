#include <bits/stdc++.h>
using i64 = long long;
const int maxn = 200000;
inline int Min(const int &x, const int &y) { return x < y ? x : y; }
inline int Max(const int &x, const int &y) { return x > y ? x : y; }
namespace IOManager {
constexpr int FILESZ = 131072;
char buf[FILESZ];
const char *ibuf = buf, *tbuf = buf;
struct IOManager {
  inline char gc() {
    return (ibuf == tbuf) and
                   (tbuf = (ibuf = buf) + fread(buf, 1, FILESZ, stdin),
                    ibuf == tbuf)
               ? EOF
               : *ibuf++;
  }
  template <typename _Tp>
  inline operator _Tp() {
    _Tp s = 0u;
    char c = gc();
    for (; c < 48; c = gc())
      ;
    for (; c > 47; c = gc()) s = (_Tp)(s * 10u + c - 48u);
    return s;
  }
};
}  // namespace IOManager
IOManager::IOManager io;
int a[maxn + 1];
bool e[maxn + 1];
int main() {
  for (int T = io; T; --T) {
    const int n = io, m = io;
    for (int i = 1; i <= n; ++i) e[a[i] = io] = true;
    int ans = 0;
    for (int i = 1; i <= m; ++i) {
      const int b = io;
      if (e[b]) ans = b;
    }
    if (ans == 0)
      puts("NO");
    else
      printf("YES\n1 %d\n", ans);
    for (int i = 1; i <= n; ++i) e[a[i]] = false;
  }
  return 0;
}
