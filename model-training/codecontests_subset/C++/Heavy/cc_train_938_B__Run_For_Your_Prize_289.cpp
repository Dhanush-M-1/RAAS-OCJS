#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T sqr(const T &x) {
  return x * x;
}
inline long long sqr(int x) { return sqr<long long>(x); }
template <class T>
T binpow(const T &a, long long n) {
  return n == 0 ? 1 : sqr(binpow(a, n / 2)) * (n % 2 ? a : 1);
}
long long binpow(long long a, long long n, long long modulo) {
  return n == 0 ? 1
                : sqr(binpow(a, n / 2, modulo)) % modulo * (n % 2 ? a : 1) %
                      modulo;
}
long long gcd(long long a, long long b, long long &x, long long &y) {
  if (a == 0) {
    x = 0;
    y = 1;
    return b;
  }
  long long x1, y1;
  long long d = gcd(b % a, a, x1, y1);
  x = y1 - (b / a) * x1;
  y = x1;
  return d;
}
inline long long phi(long long n) {
  long long result = n;
  for (long long i = 2; i * i <= n; ++i)
    if (n % i == 0) {
      while (n % i == 0) n /= i;
      result -= result / i;
    }
  if (n > 1) result -= result / n;
  return result;
}
inline vector<long long> inverseAll(long long m) {
  vector<long long> r(m);
  r[1] = 1;
  for (int i = 2; i < m; ++i) r[i] = (m - (m / i) * r[m % i] % m) % m;
  return r;
}
inline long long gcd(long long a, long long b) { return gcd(a, b, a, b); }
inline long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
inline long long llrand() {
  const long long lsbToFill = (sizeof(long long) << 3) - 1;
  const long long bitsFilledInIteration = __builtin_popcountll(RAND_MAX);
  long long number = 0;
  for (long long lsbFilled = 0; lsbFilled <= lsbToFill;
       lsbFilled += bitsFilledInIteration) {
    number ^= (((long long)rand()) << lsbFilled);
  }
  return number & numeric_limits<long long>::max();
}
inline long long llrand(long long begin, long long end) {
  return begin + llrand() % (end - begin);
}
struct Dinic {
  struct Edge {
    int u, v;
    long long cap, flow;
    Edge() {}
    Edge(int u, int v, long long cap) : u(u), v(v), cap(cap), flow(0) {}
  };
  int N;
  vector<Edge> E;
  vector<vector<int>> g;
  vector<int> d, pt;
  Dinic(int N) : N(N), E(0), g(N), d(N), pt(N) {}
  void AddEdge(int u, int v, long long cap) {
    if (u != v) {
      E.emplace_back(Edge(u, v, cap));
      g[u].emplace_back(E.size() - 1);
      E.emplace_back(Edge(v, u, 0));
      g[v].emplace_back(E.size() - 1);
    }
  }
  bool BFS(int S, int T) {
    queue<int> q({S});
    fill(d.begin(), d.end(), N + 1);
    d[S] = 0;
    while (!q.empty()) {
      int u = q.front();
      q.pop();
      if (u == T) break;
      for (int k : g[u]) {
        Edge &e = E[k];
        if (e.flow < e.cap && d[e.v] > d[e.u] + 1) {
          d[e.v] = d[e.u] + 1;
          q.emplace(e.v);
        }
      }
    }
    return d[T] != N + 1;
  }
  long long DFS(int u, int T, long long flow = -1) {
    if (u == T || flow == 0) return flow;
    for (int &i = pt[u]; i < g[u].size(); ++i) {
      Edge &e = E[g[u][i]];
      Edge &oe = E[g[u][i] ^ 1];
      if (d[e.v] == d[e.u] + 1) {
        long long amt = e.cap - e.flow;
        if (flow != -1 && amt > flow) amt = flow;
        if (long long pushed = DFS(e.v, T, amt)) {
          e.flow += pushed;
          oe.flow -= pushed;
          return pushed;
        }
      }
    }
    return 0;
  }
  long long MaxFlow(int S, int T) {
    long long total = 0;
    while (BFS(S, T)) {
      fill(pt.begin(), pt.end(), 0);
      while (long long flow = DFS(S, T)) total += flow;
    }
    return total;
  }
};
vector<long long> Dijkstra(const vector<list<pair<int, long long>>> &g, int s) {
  vector<long long> d(int((g).size()), numeric_limits<long long>::max() / 2LL);
  priority_queue<pair<long long, int>> q;
  d[s] = 0;
  q.emplace(-0, s);
  while (!q.empty()) {
    while (q.top().first > d[q.top().second]) {
      q.pop();
    }
    int v = q.top().second;
    q.pop();
    for (const auto &cw : g[v]) {
      if (d[v] + cw.second < d[cw.first]) {
        d[cw.first] = d[v] + cw.second;
        q.emplace(-d[cw.first], cw.first);
      }
    }
  }
  return d;
}
struct BinarySearchIterator
    : public std::iterator<std::forward_iterator_tag, bool> {
  long long value;
  typename iterator_traits<BinarySearchIterator>::difference_type operator-(
      const BinarySearchIterator &it) const {
    return value - it.value;
  }
  BinarySearchIterator &operator++() {
    ++value;
    return *this;
  }
  bool operator!=(const BinarySearchIterator &it) const {
    return value != it.value;
  }
  bool operator*() const { return true; }
};
template <int ALPHA>
class AhoCorasick {
 public:
  static const int ILLEGAL_INDEX;
  static const int ROOT;
  struct Node {
    bool leaf;
    int parent;
    int parentCharacter;
    int link;
    int next[ALPHA];
    int go[ALPHA];
    int outputFunction;
    Node(int parent = ILLEGAL_INDEX, int parentCharacter = ALPHA)
        : leaf(false),
          parent(parent),
          parentCharacter(parentCharacter),
          link(ILLEGAL_INDEX),
          outputFunction(ILLEGAL_INDEX) {
      fill_n(next, ALPHA, ILLEGAL_INDEX);
      fill_n(go, ALPHA, ILLEGAL_INDEX);
    }
  };
  vector<Node> tree = vector<Node>(1);
  AhoCorasick() {}
  AhoCorasick(int maxStatesNumber) { tree.reserve(maxStatesNumber); }
  template <class Iterator>
  void add(int length, const Iterator begin) {
    int vertex = ROOT;
    for (int i = 0; i < length; ++i) {
      if (ILLEGAL_INDEX == tree[vertex].next[begin[i]]) {
        tree[vertex].next[begin[i]] = int((tree).size());
        tree.push_back(Node(vertex, begin[i]));
      }
      vertex = tree[vertex].next[begin[i]];
    }
    tree[vertex].leaf = true;
  }
  int getLink(int vertex) {
    assert(0 <= vertex && vertex < tree.size());
    if (ILLEGAL_INDEX == tree[vertex].link) {
      if (ROOT == vertex || ROOT == tree[vertex].parent) {
        tree[vertex].link = ROOT;
      } else {
        tree[vertex].link =
            go(getLink(tree[vertex].parent), tree[vertex].parentCharacter);
      }
    }
    return tree[vertex].link;
  }
  int go(int vertex, int character) {
    assert(0 <= character && character < ALPHA);
    assert(0 <= vertex && vertex < tree.size());
    if (ILLEGAL_INDEX == tree[vertex].go[character]) {
      if (ILLEGAL_INDEX == tree[vertex].next[character]) {
        tree[vertex].go[character] =
            ROOT == vertex ? ROOT : go(getLink(vertex), character);
      } else {
        tree[vertex].go[character] = tree[vertex].next[character];
      }
    }
    return tree[vertex].go[character];
  }
  int getOutputFunction(int vertex) {
    assert(0 <= vertex && vertex < tree.size());
    if (ILLEGAL_INDEX == tree[vertex].outputFunction) {
      if (tree[vertex].leaf || ROOT == vertex) {
        tree[vertex].outputFunction = vertex;
      } else {
        tree[vertex].outputFunction = getOutputFunction(getLink(vertex));
      }
    }
    return tree[vertex].outputFunction;
  }
};
template <int ALPHA>
const int AhoCorasick<ALPHA>::ILLEGAL_INDEX = -1;
template <int ALPHA>
const int AhoCorasick<ALPHA>::ROOT = 0;
int main(int argc, const char *argv[]) {
  ios::sync_with_stdio(false);
  cin.tie(0);
  srand((unsigned int)time(NULL));
  int n;
  while (cin >> n) {
    vector<int> a(n);
    for (int i = (0); i < (n); ++i) {
      cin >> a[i];
    }
    int answer = min(a[n - 1] - 1, (int)1e6 - a[0]);
    for (int i = (0); i < (n - 1); ++i) {
      answer = min(answer, max((int)1e6 - a[i + 1], a[i] - 1));
    }
    cout << answer << endl;
  }
  return 0;
}
