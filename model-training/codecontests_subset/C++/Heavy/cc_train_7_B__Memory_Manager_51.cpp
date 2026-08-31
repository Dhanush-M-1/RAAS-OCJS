#include <bits/stdc++.h>
using namespace std;
template <typename Int>
inline Int read() {
  Int flag = 1;
  char c = getchar();
  while ((!isdigit(c)) && c != '-') c = getchar();
  if (c == '-') flag = -1, c = getchar();
  Int init = c & 15;
  while (isdigit(c = getchar())) init = (init << 3) + (init << 1) + (c & 15);
  return init * flag;
}
template <typename Int>
inline void write(Int x) {
  if (x < 0) putchar('-'), x = ~x + 1;
  if (x > 9) write(x / 10);
  putchar((x % 10) | 48);
}
template <typename Int>
inline void write(Int x, char nextch) {
  write(x);
  putchar(nextch);
}
struct LR {
  long long l, r, idx;
  long long length;
  LR(long long L = 0, long long R = 0, long long IDX = 0)
      : l(L), r(R), idx(IDX), length(r - l + 1) {}
  bool operator<(const LR &other) const { return l > other.l; }
};
struct Memory_Manager {
  long long from[107], size;
  long long l[107], r[107], top;
  Memory_Manager() : top(0) { memset(from, 0, sizeof(from)); }
  void alloc(long long n) {
    bool isSuccess = 0;
    for (long long i = 1; i <= size - n + 1; i++) {
      bool couldUse = 1;
      for (long long j = 0; j < n; j++) {
        if (from[i + j]) {
          couldUse = 0;
          i = i + j;
          break;
        }
      }
      if (couldUse) {
        top++;
        l[top] = i;
        r[top] = i + n - 1;
        for (long long j = l[top]; j <= r[top]; j++) {
          from[j] = top;
        }
        isSuccess = 1;
        break;
      }
    }
    if (isSuccess) {
      write(top, '\n');
    } else {
      puts("NULL");
    }
  }
  void erase(long long x) {
    if (x <= 0 || x > top || l[x] == -1) {
      puts("ILLEGAL_ERASE_ARGUMENT");
      return;
    }
    for (long long j = l[x]; j <= r[x]; j++) {
      from[j] = 0;
    }
    l[x] = -1;
  }
  void defragment() {
    priority_queue<LR> pq;
    for (long long i = 1; i <= top; i++) {
      if (l[i] != -1) {
        pq.push(LR(l[i], r[i], i));
      }
    }
    memset(from, 0, sizeof(from));
    long long Rwall = 0;
    while (!pq.empty()) {
      LR f = pq.top();
      pq.pop();
      l[f.idx] = Rwall + 1;
      r[f.idx] = Rwall + f.length;
      Rwall += f.length;
      for (long long i = l[f.idx]; i <= r[f.idx]; i++) {
        from[i] = f.idx;
      }
    }
  }
} BerlOS;
long long t, m;
char buf[20], n;
signed main() {
  t = read<long long>();
  m = read<long long>();
  BerlOS.size = m;
  while (t--) {
    scanf("%s", buf);
    switch (buf[0]) {
      case 'a':
        BerlOS.alloc(read<long long>());
        break;
      case 'e':
        BerlOS.erase(read<long long>());
        break;
      case 'd':
        BerlOS.defragment();
        break;
    }
  }
  return 0;
}
