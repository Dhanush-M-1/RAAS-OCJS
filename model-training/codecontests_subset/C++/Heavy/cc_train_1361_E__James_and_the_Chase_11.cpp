#include <bits/stdc++.h>
using namespace std;
template <typename T, typename U>
std::istream& operator>>(std::istream& i, pair<T, U>& p) {
  i >> p.first >> p.second;
  return i;
}
template <typename T>
std::istream& operator>>(std::istream& i, vector<T>& t) {
  for (auto& v : t) {
    i >> v;
  }
  return i;
}
template <typename T, typename U>
std::ostream& operator<<(std::ostream& o, const pair<T, U>& p) {
  o << p.first << ' ' << p.second;
  return o;
}
template <typename T>
std::ostream& operator<<(std::ostream& o, const vector<T>& t) {
  if (t.empty()) o << '\n';
  for (size_t i = 0; i < t.size(); ++i) {
    o << t[i] << " \n"[i == t.size() - 1];
  }
  return o;
}
template <typename T>
using minheap = priority_queue<T, vector<T>, greater<T>>;
template <typename T>
using maxheap = priority_queue<T, vector<T>, less<T>>;
unsigned int logceil(long long first) {
  return first ? 8 * sizeof(long long) - __builtin_clzll(first) : 0;
}
namespace std {
template <typename T, typename U>
struct hash<pair<T, U>> {
  hash<T> t;
  hash<U> u;
  size_t operator()(const pair<T, U>& p) const {
    return t(p.first) ^ (u(p.second) << 7);
  }
};
}  // namespace std
template <typename T, typename F>
T bsh(T l, T h, const F& f) {
  T r = -1, m;
  while (l <= h) {
    m = (l + h) / 2;
    if (f(m)) {
      l = m + 1;
      r = m;
    } else {
      h = m - 1;
    }
  }
  return r;
}
template <typename F>
double bshd(double l, double h, const F& f, double p = 1e-9) {
  unsigned int r = 3 + (unsigned int)log2((h - l) / p);
  while (r--) {
    double m = (l + h) / 2;
    if (f(m)) {
      l = m;
    } else {
      h = m;
    }
  }
  return (l + h) / 2;
}
template <typename T, typename F>
T bsl(T l, T h, const F& f) {
  T r = -1, m;
  while (l <= h) {
    m = (l + h) / 2;
    if (f(m)) {
      h = m - 1;
      r = m;
    } else {
      l = m + 1;
    }
  }
  return r;
}
template <typename F>
double bsld(double l, double h, const F& f, double p = 1e-9) {
  unsigned int r = 3 + (unsigned int)log2((h - l) / p);
  while (r--) {
    double m = (l + h) / 2;
    if (f(m)) {
      h = m;
    } else {
      l = m;
    }
  }
  return (l + h) / 2;
}
template <typename T>
T gcd(T a, T b) {
  if (a < b) swap(a, b);
  return b ? gcd(b, a % b) : a;
}
template <typename T>
class vector2 : public vector<vector<T>> {
 public:
  vector2() {}
  vector2(size_t a, size_t b, T t = T())
      : vector<vector<T>>(a, vector<T>(b, t)) {}
};
template <typename T>
class vector3 : public vector<vector2<T>> {
 public:
  vector3() {}
  vector3(size_t a, size_t b, size_t c, T t = T())
      : vector<vector2<T>>(a, vector2<T>(b, c, t)) {}
};
template <typename T>
class vector4 : public vector<vector3<T>> {
 public:
  vector4() {}
  vector4(size_t a, size_t b, size_t c, size_t d, T t = T())
      : vector<vector3<T>>(a, vector3<T>(b, c, d, t)) {}
};
template <typename T>
class vector5 : public vector<vector4<T>> {
 public:
  vector5() {}
  vector5(size_t a, size_t b, size_t c, size_t d, size_t e, T t = T())
      : vector<vector4<T>>(a, vector4<T>(b, c, d, e, t)) {}
};
auto seed = chrono::high_resolution_clock::now().time_since_epoch().count();
std::mt19937 rng(seed);
using random_int = std::uniform_int_distribution<int>;
using random_ll = std::uniform_int_distribution<long long>;
struct TimeLimit {
  TimeLimit(double seconds) : s(seconds - 0.2), last(clock()), mx(0) {}
  operator bool() const {
    clock_t cur = clock();
    mx = max(mx, cur - last);
    last = cur;
    return clock() < s * CLOCKS_PER_SEC - 1.5 * mx;
  }
  double s;
  mutable clock_t last, mx;
};
constexpr int ATTEMPTS = 100;
class E {
 public:
  int N, M;
  vector<vector<int>> E;
  vector<bool> Visited, OnStack;
  vector<int> Stack, Order;
  vector<int> StackId;
  vector<pair<std::pair<int, int>, std::pair<int, int>>> Bad;
  bool isInteresting(int v) {
    if (Visited[v]) return OnStack[v];
    Visited[v] = true;
    OnStack[v] = true;
    Stack.push_back(v);
    for (int w : E[v]) {
      if (!isInteresting(w)) return false;
    }
    Stack.pop_back();
    OnStack[v] = false;
    return true;
  }
  void add(int i, std::pair<int, int> first) {
    if (first.first < Bad[i].first.first) {
      Bad[i].second = Bad[i].first;
      Bad[i].first = first;
    } else if (first.first < Bad[i].second.first) {
      Bad[i].second = first;
    }
  }
  void dfs(int v) {
    Order.push_back(v);
    StackId[v] = Stack.size();
    Bad[v] = {{StackId[v], v}, {StackId[v], v}};
    Visited[v] = true;
    OnStack[v] = true;
    Stack.push_back(v);
    for (int w : E[v]) {
      if (Visited[w]) {
        add(v, {StackId[w], w});
      } else {
        dfs(w);
        add(v, Bad[w].first);
        add(v, Bad[w].second);
      }
    }
    Stack.pop_back();
    OnStack[v] = false;
  }
  void solve(istream& cin, ostream& cout) {
    int T;
    cin >> T;
    for (int t = 0; t < T; ++t) {
      cin >> N >> M;
      E.clear();
      E.resize(N);
      for (int i = 0; i < M; ++i) {
        int a, b;
        cin >> a >> b;
        --a;
        --b;
        E[a].push_back(b);
      }
      int interesting = -1;
      random_int R(0, N - 1);
      for (int att = 0; att < ATTEMPTS; ++att) {
        int start = R(rng);
        Stack.clear();
        Visited.assign(N, false);
        OnStack.assign(N, false);
        if (isInteresting(start)) {
          interesting = start;
          break;
        }
      }
      if (interesting == -1) {
        cout << "-1\n";
        continue;
      }
      Stack.clear();
      StackId.resize(N);
      Visited.assign(N, false);
      OnStack.assign(N, false);
      Bad.resize(N);
      Order.clear();
      dfs(interesting);
      vector<int> IsG(N, false);
      for (int w : Order) {
        if (w == interesting) {
          IsG[w] = true;
        } else if (Bad[w].second.first >= StackId[w]) {
          IsG[w] = IsG[Bad[w].first.second];
        }
      }
      vector<int> Good;
      for (int i = 0; i < N; ++i)
        if (IsG[i]) Good.push_back(i + 1);
      if (Good.size() * 5 < N) {
        cout << "-1\n";
      } else {
        cout << Good;
      }
    }
  }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  E solver;
  std::istream& in(std::cin);
  std::ostream& out(std::cout);
  solver.solve(in, out);
  return 0;
}
