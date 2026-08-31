#include <bits/stdc++.h>
struct MI {
 private:
  char bb[1 << 14];
  FILE *f;
  char *bs, *be;
  char e;
  bool o, l;

 public:
  MI() : f(stdin), bs(0), be(0) {}
  inline char get() {
    if (o) {
      o = 0;
      return e;
    }
    if (bs == be) be = (bs = bb) + fread(bb, 1, sizeof(bb), f);
    if (bs == be) {
      l = 1;
      return -1;
    };
    return *bs++;
  }
  inline void unget(char c) {
    o = 1;
    e = c;
  }
  template <class T>
  inline T read() {
    T r;
    *this > r;
    return r;
  }
  template <class T>
  inline MI &operator>(T &);
};
template <class T>
struct Q {
  const static bool U = T(-1) >= T(0);
  inline void operator()(MI &t, T &r) const {
    r = 0;
    char c;
    bool y = 0;
    if (U)
      for (;;) {
        c = t.get();
        if (c == -1) goto E;
        if (isdigit(c)) break;
      }
    else
      for (;;) {
        c = t.get();
        if (c == -1) goto E;
        if (c == '-') {
          c = t.get();
          if (isdigit(c)) {
            y = 1;
            break;
          };
        } else if (isdigit(c))
          break;
        ;
      };
    for (;;) {
      if (c == -1) goto E;
      if (isdigit(c))
        r = r * 10 + (c ^ 48);
      else
        break;
      c = t.get();
    }
    t.unget(c);
  E:;
    if (y) r = -r;
  }
};
template <>
struct Q<char> {};
template <class T>
inline MI &MI::operator>(T &t) {
  Q<T>()(*this, t);
  return *this;
}
template <class T>
std::ostream &operator<(std::ostream &out, const T &t) {
  return out << t;
}
using std::cout;
MI cin;
const int $n = 100005;
template <typename T>
inline bool gmax(T &a, const T &b) {
  return a < b && (a = b, true);
}
int n, m, p[$n], dep[$n], vis[$n], cnt[$n], rea[$n], T;
std::vector<int> outs[$n];
std::mt19937 rng(std::chrono::steady_clock::now().time_since_epoch().count());
bool check(int x) {
  static bool ex[$n];
  vis[x] = T;
  ex[x] = 1;
  for (int v : outs[x])
    if ((vis[v] == T) ? !ex[v] : !check(v)) {
      ex[x] = 0;
      return 0;
    }
  ex[x] = 0;
  return 1;
}
void dfs(int x) {
  vis[x] = T;
  rea[x] = x;
  cnt[x] = 0;
  for (int v : outs[x]) {
    if (vis[v] == T) {
      ++cnt[x];
      --cnt[v];
      if (dep[v] < dep[rea[x]]) rea[x] = v;
    } else {
      dep[v] = dep[x] + 1;
      dfs(v);
      cnt[x] += cnt[v];
      if (dep[rea[v]] < dep[rea[x]]) rea[x] = rea[v];
    }
  }
}
void load(int x) {
  gmax(cnt[x], cnt[rea[x]]);
  for (int v : outs[x])
    if (dep[v] == dep[x] + 1) load(v);
}
inline void work() {
  cin > n > m;
  for (auto __r = (n), i = (1); i <= __r; ++i) outs[i].clear();
  for (auto __r = (m), i = (1); i <= __r; ++i) {
    const auto x = (cin.read<int>()), y = (cin.read<int>());
    outs[x].push_back(y);
  }
  std::iota(p + 1, p + n + 1, 1);
  std::shuffle(p + 1, p + n + 1, rng);
  int rt = 0;
  for (auto __r = (std::min(n, 100)), i = (1); i <= __r; ++i)
    if (++T, check(p[i])) {
      rt = p[i];
      break;
    }
  if (!rt) return (void)(cout < "-1\n");
  dep[rt] = 1;
  ++T;
  dfs(rt);
  load(rt);
  int c = 0;
  for (auto __r = (n), i = (1); i <= __r; ++i) c += cnt[i] <= 1;
  if (c * 5 < n) return (void)(cout < "-1\n");
  for (auto __r = (n), i = (1); i <= __r; ++i)
    if (cnt[i] <= 1) cout < i < " \n"[!--c];
}
int main() {
  for (auto __r = ((cin.read<int>())), i = (1); i <= __r; ++i) work();
}
