#include <bits/stdc++.h>
using namespace std;
using ui64 = unsigned long long;
using i64 = long long;
using ui32 = unsigned int;
using Double = long double;
template <class T>
inline T Abs(const T& x) {
  return x < 0 ? -x : x;
}
template <class T>
inline T Sqr(const T& x) {
  return x * x;
}
template <class T>
void Print(const T& x);
template <>
void Print<ui64>(const ui64& x) {
  printf("%" PRIu64, x);
}
template <>
void Print<i64>(const i64& x) {
  printf("%" PRId64, x);
}
template <>
void Print<ui32>(const ui32& x) {
  printf("%" PRIu32, x);
}
template <>
void Print<int>(const int& x) {
  printf("%" PRId32, x);
}
template <>
void Print<float>(const float& x) {
  printf("%.15f", x);
}
template <>
void Print<double>(const double& x) {
  printf("%.15lf", x);
}
template <>
void Print<Double>(const Double& x) {
  Print<double>(x);
}
template <>
void Print<string>(const string& s) {
  printf("%s", s.c_str());
}
template <class T>
T Read();
template <>
ui64 Read<ui64>() {
  ui64 x;
  scanf("%" SCNu64, &x);
  return x;
}
template <>
i64 Read<i64>() {
  i64 x;
  scanf("%" SCNd64, &x);
  return x;
}
template <>
ui32 Read<ui32>() {
  ui32 x;
  scanf("%" SCNu32, &x);
  return x;
}
template <>
int Read<int>() {
  int x;
  scanf("%" SCNd32, &x);
  return x;
}
template <>
float Read<float>() {
  float x;
  scanf("%f", &x);
  return x;
}
template <>
double Read<double>() {
  double x;
  scanf("%lf", &x);
  return x;
}
template <>
Double Read<Double>() {
  return Read<double>();
}
template <>
string Read<string>() {
  static char buf[int(1e7 + 1)];
  scanf("%s", buf);
  return string(buf);
}
template <class T>
void ReadLine(T& x);
template <class T, class... Args>
void ReadLine(T& x, Args&... args);
template <class T>
void PrintLine(const T& x);
template <class T, class... Args>
void PrintLine(const T& x, Args... args);
template <class T>
void PrintVector(const vector<T>& x, char delimiter = ' ');
template <class T>
vector<T> ReadVector(size_t size);
const int maxm = 500 * 1001;
struct TEdge {
  int U;
  int V;
  int W;
};
int main() {
  int n, m, q;
  ReadLine(n, m, q);
  vector<TEdge> edges;
  vector<int> idx(m);
  for (int i = 0; i < m; ++i) {
    int u = Read<int>() - 1;
    int v = Read<int>() - 1;
    int w = Read<int>();
    edges.push_back({u, v, w});
    idx[i] = i;
  }
  sort(idx.begin(), idx.end(),
       [&](int lhs, int rhs) { return edges[lhs].W > edges[rhs].W; });
  for (; q; --q) {
    int l = Read<int>() - 1;
    int r = Read<int>() - 1;
    vector<int> color(n, 1);
    vector<int> comp(n, 0);
    for (int i = 0; i < n; ++i) {
      comp[i] = i;
    }
    int ans = -1;
    for (int id : idx) {
      if (id > r || id < l) {
        continue;
      }
      int u = edges[id].U, v = edges[id].V;
      if (comp[u] == comp[v]) {
        if (color[u] == color[v]) {
          ans = edges[id].W;
          break;
        }
      } else {
        int mask = (color[u] == color[v] ? 3 : 0);
        int curComp = comp[v];
        for (int i = 0; i < n; ++i) {
          if (comp[i] == curComp) {
            comp[i] = comp[u];
            color[i] ^= mask;
          }
        }
      }
    }
    PrintLine(ans);
  }
  return 0;
}
template <class T>
void ReadLine(T& x) {
  x = Read<T>();
}
template <class T, class... Args>
void ReadLine(T& x, Args&... args) {
  x = Read<T>();
  ReadLine(args...);
}
template <class T>
void PrintLine(const T& x) {
  Print(x);
  printf("\n");
}
template <class T, class... Args>
void PrintLine(const T& x, Args... args) {
  Print(x);
  printf(" ");
  PrintLine(args...);
}
template <class T>
void PrintVector(const vector<T>& x, char delimiter) {
  for (size_t i = 0; i < x.size(); ++i) {
    Print(x[i]);
    if (i + 1 < x.size()) {
      printf("%c", delimiter);
    }
  }
  printf("\n");
}
template <class T>
vector<T> ReadVector(size_t size) {
  vector<T> res(size);
  for (size_t i = 0; i < size; ++i) {
    res[i] = Read<T>();
  }
  return res;
}
