#include <bits/stdc++.h>
namespace XX {
template <typename... Datas>
class UnionFind {
 public:
  struct Node : public Datas... {
    int _parent = -1;
    int size() { return -_parent; }
    void operator+=(Node& other) {
      int dummy[] = {(Datas::operator+=(other), 0)...};
    }
  };
  UnionFind(int size) : _data(size) {}
  Node& operator[](int idx) { return _data[(*this)(idx)]; }
  int operator()(int n) {
    if (_data[n]._parent < 0)
      return n;
    else
      return _data[n]._parent = (*this)(_data[n]._parent);
  }
  bool operator()(int a, int b) {
    int pa = (*this)(a), pb = (*this)(b);
    if (pa == pb)
      return false;
    else {
      if (_data[pa]._parent == _data[pb]._parent)
        _data[pa]._parent--;
      else if (_data[pa]._parent > _data[pb]._parent)
        std::swap(pa, pb);
      _data[pa] += _data[pb];
      _data[pb]._parent = pa;
      return true;
    }
  }

 private:
  std::vector<Node> _data;
};
}  // namespace XX
template <typename T>
struct ScanfSpecifier {};
template <>
struct ScanfSpecifier<int> {
  static constexpr const char* value = "%d";
};
template <>
struct ScanfSpecifier<double> {
  static constexpr const char* value = "%lf";
};
template <>
struct ScanfSpecifier<float> {
  static constexpr const char* value = "%f";
};
template <>
struct ScanfSpecifier<char> {
  static constexpr const char* value = "%c";
};
template <>
struct ScanfSpecifier<const char*> {
  static constexpr const char* value = "%s";
};
template <>
struct ScanfSpecifier<unsigned long> {
  static constexpr const char* value = "%lu";
};
template <>
struct ScanfSpecifier<char*> {
  static constexpr const char* value = "%s";
};
template <>
struct ScanfSpecifier<unsigned int> {
  static constexpr const char* value = "%u";
};
template <>
struct ScanfSpecifier<long long int> {
  static constexpr const char* value = "%lld";
};
template <typename T>
int RD(T& arg) {
  return std::scanf(ScanfSpecifier<T>::value, &arg);
}
template <int S>
int RD(char (&arg)[S]) {
  return std::scanf("%s", arg);
}
template <>
int RD<char*>(char*& arg) {
  return std::scanf("%s", arg);
}
template <>
int RD<char>(char& arg) {
  return std::scanf(" %c", &arg);
}
template <typename T, typename... Args>
int RD(T& arg1, Args&... args) {
  return RD(arg1) + RD(args...);
}
template <typename T>
T RD() {
  T ret;
  RD(ret);
  return ret;
}
template <typename It>
void RDV(It begin, It end) {
  while (begin != end) RD(*begin++);
}
template <typename C>
void RDV(C& c) {
  RDV(std::begin(c), std::end(c));
}
template <typename... Args>
void WT(Args... args) {
  int alc = 0;
  int dummy[] = {((alc++ ? std::printf(" ") : 0),
                  std::printf(ScanfSpecifier<Args>::value, args), 0)...};
}
template <typename... Args>
void WTL(Args... args) {
  WT(args...);
  std::printf("\n");
}
template <typename It>
void WTV(It begin, It end) {
  int alc = 0;
  while (begin != end) (alc++ ? std::printf(" ") : 0), WT(*begin++);
}
template <typename C>
void WTV(const C& c) {
  WTV(std::begin(c), std::end(c));
}
template <typename It>
void WTVL(It begin, It end) {
  WTV(begin, end);
  std::printf("\n");
}
template <typename C>
void WTVL(const C& c) {
  WTVL(std::begin(c), std::end(c));
}
namespace XX {
template <template <typename> class Compare, typename T>
inline T& UP(T& x, const T& y) {
  if (Compare<T>()(y, x)) x = y;
  return x;
}
template <typename Compare, typename T>
inline T& UP(T& x, const T& y, Compare comp) {
  if (comp(y, x)) x = y;
  return x;
}
template <typename T>
inline T& GT(T& x, const T& y) {
  return UP<std::greater>(x, y);
}
template <typename T>
inline T& LS(T& x, const T& y) {
  return UP<std::less>(x, y);
}
template <typename T>
struct Mapper {
  int operator[](const T& v) {
    int& ret = table[v];
    if (!ret) rtable[ret = table.size()] = v;
    return ret - 1;
  }
  template <typename... Args>
  int operator()(Args... args) {
    return (*this)[T(args...)];
  }
  T rev(int idx) { return rtable[idx + 1]; }
  std::map<T, int> table;
  std::map<int, T> rtable;
};
template <typename T, int S>
struct ReferenceArray {
  struct It {
    typename std::array<T*, S>::iterator it;
    T& operator*() { return **it; }
    void operator++() { it++; }
    bool operator!=(const It& other) { return it != other.it; }
  };
  int size() const { return _ptr.size(); }
  It begin() const { return {_ptr.begin()}; }
  It end() const { return {_ptr.end()}; }
  T& operator[](int idx) const { return *_ptr[idx]; }
  mutable std::array<T*, S> _ptr;
};
template <typename T, typename... Args>
ReferenceArray<T, sizeof...(Args) + 1> MAKEV(T& arg1, Args&... args) {
  return {&arg1, &args...};
}
struct Range {
  struct It {
    int num, step;
    int operator*() { return num; }
    void operator++() { num += step; }
    bool operator!=(const It& other) { return num != other.num; }
  };
  Range(int ee) : b(0), e(ee) {}
  Range(int bb, int ee) : b(bb), e(ee) {}
  It begin() { return {b, (b < e ? 1 : -1)}; }
  It end() { return {e, 0}; }
  int b, e;
};
}  // namespace XX
template <typename... Datas>
using UF = XX::UnionFind<Datas...>;
template <typename T>
T& UMAX(T& x, T y) {
  return XX::UP<std::greater>(x, y);
}
template <typename T>
T& UMIN(T& x, T y) {
  return XX::UP<std::less>(x, y);
}
using XX::UP;
using RG = XX::Range;
using XX::MAKEV;
using XX::Mapper;
using namespace std;
const int E = 2000009;
const int V = 1009;
int N, M, Q;
struct Edge {
  int idx;
  int u, v;
  int w;
  bool operator<(const Edge& other) const { return w > other.w; }
} es[E];
Edge buf[E];
struct Data {
  unsigned long long ch[16] = {};
  int amt = 1;
  void operator+=(Data& other) {
    for (int i = 0; i < 16; i++) ch[i] |= other.ch[i];
    amt += other.amt;
  }
};
int main() {
  RD(N, M, Q);
  for (int i = 1; i <= M; i++) {
    es[i].idx = i;
    RD(es[i].u, es[i].v, es[i].w);
    es[i].u--;
    es[i].v--;
  }
  sort(es + 1, es + M + 1);
  while (Q--) {
    int l, r;
    RD(l, r);
    int total = 0;
    for (int i = 1; i <= M; i++)
      if (l <= es[i].idx && es[i].idx <= r) buf[total++] = es[i];
    UF<Data> uf(N);
    bool pass[V] = {};
    int ans = -1;
    unsigned long long color[16] = {};
    for (int i = 0; i < N; i++) uf[i].ch[i >> 6] |= 1ll << (i & 63);
    auto getc = [&](int u) -> bool {
      return color[u >> 6] & (1ll << (u & 63));
    };
    auto setc = [&](int u, int b) {
      if (b)
        color[u >> 6] |= 1ll << (u & 63);
      else
        color[u >> 6] &= ~(1ll << (u & 63));
    };
    for (int i = 0; i < total; i++) {
      int u = buf[i].u, v = buf[i].v;
      if (pass[v]) swap(u, v);
      if (!pass[u]) {
        setc(u, 0);
        setc(v, 1);
        uf(u, v);
      } else if (!pass[v]) {
        setc(v, !getc(u));
        uf(u, v);
      } else if (getc(u) != getc(v))
        uf(u, v);
      else if (uf(u) == uf(v)) {
        ans = buf[i].w;
        break;
      } else {
        for (int i = 0; i < 16; i++) color[i] ^= uf[u].ch[i];
        uf(u, v);
      }
      pass[u] = pass[v] = true;
    }
    WTL(ans);
  }
}
