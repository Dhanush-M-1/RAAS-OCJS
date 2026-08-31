#include <bits/stdc++.h>
using namespace std;
struct fast_ios {
  fast_ios() {
    cin.tie(nullptr), ios::sync_with_stdio(false),
        cout << fixed << setprecision(20);
  };
} fast_ios_;
template <class T>
auto add = [](T a, T b) -> T { return a + b; };
template <class T>
auto f_max = [](T a, T b) -> T { return max(a, b); };
template <class T>
auto f_min = [](T a, T b) -> T { return min(a, b); };
template <class T>
using V = vector<T>;
using Vl = V<int>;
using VVl = V<Vl>;
template <typename T>
ostream& operator<<(ostream& os, const vector<T>& v) {
  for (int i = 0; i < (int)v.size(); i++)
    os << v[i] << (i + 1 != v.size() ? " " : "");
  return os;
}
template <typename T>
istream& operator>>(istream& is, vector<T>& v) {
  for (T& in : v) is >> in;
  return is;
}
template <class T>
bool chmax(T& a, const T& b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
bool chmin(T& a, const T& b) {
  if (b < a) {
    a = b;
    return 1;
  }
  return 0;
}
int gcd(int a, int b) {
  if (b == 0)
    return a;
  else
    return gcd(b, a % b);
}
int ceil(int a, int b) { return (a + b - 1) / b; }
int digit(int a) { return (int)log10(a); }
int e_dist(pair<int, int> a, pair<int, int> b) {
  return abs(a.first - b.first) * abs(a.first - b.first) +
         abs(a.second - b.second) * abs(a.second - b.second);
}
int m_dist(pair<int, int> a, pair<int, int> b) {
  return abs(a.first - b.first) + abs(a.second - b.second);
}
void Worshall_Floyd(VVl& g) {
  for (int k = (0), k_end_ = (((int)(g).size())); k < k_end_; ++k)
    for (int i = (0), i_end_ = (((int)(g).size())); i < i_end_; ++i)
      for (int j = (0), j_end_ = (((int)(g).size())); j < j_end_; ++j)
        chmin(g[i][j], g[i][k] + g[k][j]);
}
const int MOD1000000007 = 1000000007, MOD998244353 = 998244353, INF = 1e5;
int dx[8] = {1, 0, -1, 0, 1, -1, 1, -1}, dy[8] = {0, 1, 0, -1, -1, -1, 1, 1};
bool YN(bool flag) {
  cout << (flag ? "YES" : "NO") << '\n';
  return flag;
}
bool yn(bool flag) {
  cout << (flag ? "Yes" : "No") << '\n';
  return flag;
}
struct Edge {
  int from, to;
  int cost;
  Edge(int u, int v, int c) {
    cost = c;
    from = u;
    to = v;
  }
  bool operator<(const Edge& e) const { return cost < e.cost; }
};
struct WeightedEdge {
  int to;
  int cost;
  WeightedEdge(int v, int c = 1) {
    to = v;
    cost = c;
  }
  bool operator<(const WeightedEdge& e) const { return cost < e.cost; }
};
using WeightedGraph = V<V<WeightedEdge>>;
int hextolint(char c) {
  if ('0' <= c && c <= '9')
    return c - '0';
  else
    return (c - 'A') + 10;
}
char linttohex(int v) {
  if (v < 10)
    return '0' + v;
  else
    return 'A' + (v - 10);
}
struct UnionFind {
 public:
  UnionFind() : _n(0) {}
  UnionFind(int n) : _n(n), parent_or_size(n, -1) {}
  int merge(int a, int b) {
    assert(0 <= a && a < _n);
    assert(0 <= b && b < _n);
    int x = leader(a), y = leader(b);
    if (x == y) return x;
    if (-parent_or_size[x] < -parent_or_size[y]) std::swap(x, y);
    if (used_count) {
      if (count_in_set[x].size() < count_in_set[y].size()) {
        std::swap(count_in_set[x], count_in_set[y]);
      }
      for (auto p : count_in_set[y]) {
        count_in_set[x][p.first] += p.second;
      }
    }
    if (set_operate) {
      root_values[x] = f(root_values[y], root_values[x]);
    }
    parent_or_size[x] += parent_or_size[y];
    parent_or_size[y] = x;
    return x;
  }
  bool same(int a, int b) {
    assert(0 <= a && a < _n);
    assert(0 <= b && b < _n);
    return leader(a) == leader(b);
  }
  int leader(int a) {
    assert(0 <= a && a < _n);
    if (parent_or_size[a] < 0) return a;
    return parent_or_size[a] = leader(parent_or_size[a]);
  }
  int size(int a) {
    assert(0 <= a && a < _n);
    return -parent_or_size[leader(a)];
  }
  std::vector<std::vector<int>> groups() {
    std::vector<int> leader_buf(_n), group_size(_n);
    for (int i = 0; i < _n; i++) {
      leader_buf[i] = leader(i);
      group_size[leader_buf[i]]++;
    }
    std::vector<std::vector<int>> result(_n);
    for (int i = 0; i < _n; i++) {
      result[i].reserve(group_size[i]);
    }
    for (int i = 0; i < _n; i++) {
      result[leader_buf[i]].push_back(i);
    }
    result.erase(
        std::remove_if(result.begin(), result.end(),
                       [&](const std::vector<int>& v) { return v.empty(); }),
        result.end());
    return result;
  }
  void set_operate_and_value(std::vector<int> array,
                             function<int(int, int)> _f) {
    f = _f;
    root_values = array;
    set_operate = true;
  }
  int get_set_value(int a) { return root_values[leader(a)]; }
  void regist_count(int a, int label) {
    if (!used_count) {
      used_count = true;
      count_in_set.assign(_n, std::map<int, int>());
    }
    count_in_set[leader(a)][label]++;
  }
  int get_count(int a, int label) {
    if (!used_count) return -1;
    return count_in_set[leader(a)][label];
  }

 private:
  int _n;
  std::vector<int> parent_or_size;
  std::vector<std::map<int, int>> count_in_set;
  bool used_count = false;
  std::vector<int> root_values;
  function<int(int, int)> f;
  bool set_operate = false;
};
int N;
int main() {
  cin >> N;
  V<string> arr(N);
  cin >> arr;
  V<string> _arr;
  for (int j = (0), j_end_ = (N); j < j_end_; ++j) {
    string _s = "";
    for (int i = (0), i_end_ = (N / 4); i < i_end_; ++i) {
      int sum = 0;
      for (int k = (0), k_end_ = (4); k < k_end_; ++k) {
        int v = hextolint(arr[i * 4 + k][j / 4]);
        if (v & (8 >> (j % 4))) {
          sum += 8 >> k;
        }
      }
      _s += linttohex(sum);
    }
    _arr.push_back(_s);
  }
  {
    UnionFind tree(N), _tree(N);
    for (int i = (0), i_end_ = (N); i < i_end_; ++i) {
      for (int j = (i + 1), j_end_ = (N); j < j_end_; ++j) {
        if (tree.same(i, j)) continue;
        if (arr[i] == arr[j]) tree.merge(i, j);
      }
    }
    for (int i = (0), i_end_ = (N); i < i_end_; ++i) {
      for (int j = (i + 1), j_end_ = (N); j < j_end_; ++j) {
        if (_tree.same(i, j)) continue;
        if (_arr[i] == _arr[j]) _tree.merge(i, j);
      }
    }
    int ans = 1;
    for (int x = (1), x_end_ = (N + 1); x < x_end_; ++x) {
      if (N % x != 0) continue;
      bool flag = true;
      for (int i = (0), i_end_ = (N / x); i < i_end_; ++i) {
        for (int k = (0), k_end_ = (x); k < k_end_; ++k) {
          if (!tree.same(i * x, i * x + k)) flag = false;
        }
      }
      for (int i = (0), i_end_ = (N / x); i < i_end_; ++i) {
        for (int k = (0), k_end_ = (x); k < k_end_; ++k) {
          if (!_tree.same(i * x, i * x + k)) flag = false;
        }
      }
      if (flag) chmax(ans, x);
    }
    cout << ans << '\n';
  }
}
