#include <bits/stdc++.h>
#pragma warning(disable : 4996)
using namespace std;
namespace Xrocks {}
using namespace Xrocks;
namespace Xrocks {
class in {
} user_input;
class out {
} output;
in& operator>>(in& X, int& Y) {
  scanf("%d", &Y);
  return X;
}
in& operator>>(in& X, char* Y) {
  scanf("%s", Y);
  return X;
}
in& operator>>(in& X, float& Y) {
  scanf("%f", &Y);
  return X;
}
in& operator>>(in& X, double& Y) {
  scanf("%lf", &Y);
  return X;
}
in& operator>>(in& X, char& C) {
  scanf("%c", &C);
  return X;
}
in& operator>>(in& X, string& Y) {
  cin >> Y;
  return X;
}
in& operator>>(in& X, long long& Y) {
  scanf("%lld", &Y);
  return X;
}
template <typename T>
in& operator>>(in& X, vector<T>& Y) {
  for (auto& x : Y) user_input >> x;
  return X;
}
template <typename T>
out& operator<<(out& X, const T& Y) {
  cout << Y;
  return X;
}
template <typename T>
out& operator<<(out& X, vector<T>& Y) {
  for (auto& x : Y) output << x << " ";
  return X;
}
out& operator<<(out& X, const int& Y) {
  printf("%d", Y);
  return X;
}
out& operator<<(out& X, const char& C) {
  printf("%c", C);
  return X;
}
out& operator<<(out& X, const string& Y) {
  printf("%s", Y.c_str());
  return X;
}
out& operator<<(out& X, const long long& Y) {
  printf("%lld", Y);
  return X;
}
out& operator<<(out& X, const float& Y) {
  printf("%f", Y);
  return X;
}
out& operator<<(out& X, const double& Y) {
  printf("%lf", Y);
  return X;
}
out& operator<<(out& X, const char Y[]) {
  printf("%s", Y);
  return X;
}
template <typename T>
T max(T A) {
  return A;
}
template <typename T, typename... args>
T max(T A, T B, args... S) {
  return max(A > B ? A : B, S...);
}
template <typename T>
T min(T A) {
  return A;
}
template <typename T, typename... args>
T min(T A, T B, args... S) {
  return min(A < B ? A : B, S...);
}
template <typename T>
void vectorize(int y, vector<T>& A) {
  A.resize(y);
}
template <typename T, typename... args>
void vectorize(int y, vector<T>& A, args&&... S) {
  A.resize(y);
  vectorize(y, S...);
}
long long fast(long long a, long long b, long long pr) {
  if (b == 0) return 1 % pr;
  long long ans = 1 % pr;
  while (b) {
    if (b & 1) ans = (ans * a) % pr;
    b >>= 1;
    a = (a * a) % pr;
  }
  return ans;
}
int readInt() {
  int n = 0;
  int ch = getchar_unlocked();
  int sign = 1;
  while (ch < '0' || ch > '9') {
    if (ch == '-') sign = -1;
    ch = getchar_unlocked();
  }
  while (ch >= '0' && ch <= '9')
    n = (n << 3) + (n << 1) + ch - '0', ch = getchar_unlocked();
  n = n * sign;
  return n;
}
long long readLong() {
  long long n = 0;
  int ch = getchar_unlocked();
  int sign = 1;
  while (ch < '0' || ch > '9') {
    if (ch == '-') sign = -1;
    ch = getchar_unlocked();
  }
  while (ch >= '0' && ch <= '9')
    n = (n << 3) + (n << 1) + ch - '0', ch = getchar_unlocked();
  n = n * sign;
  return n;
}
long long readBin() {
  long long n = 0;
  int ch = getchar_unlocked();
  int sign = 1;
  while (ch < '0' || ch > '1') {
    if (ch == '-') sign = -1;
    ch = getchar_unlocked();
  }
  while (ch >= '0' && ch <= '1')
    n = (n << 1) + (ch - '0'), ch = getchar_unlocked();
  return n;
}
long long inv_(long long val,
               long long pr = static_cast<long long>(998244353)) {
  return fast(val, pr - 2, pr);
}
}  // namespace Xrocks
class solve {
 public:
  solve() {
    int n, m, k;
    user_input >> n >> m >> k;
    vector<pair<int, int> > Edges(m);
    vector<int> Ans(m);
    vector<int> degree(n);
    vector<vector<pair<int, int> > > adj(n);
    set<pair<int, int> > Good_set;
    vector<int> in_good_set(n, true);
    for (int i = 0; i < m; i++) {
      user_input >> Edges[i].first >> Edges[i].second;
      Edges[i].first--;
      Edges[i].second--;
      adj[Edges[i].first].push_back({Edges[i].second, i});
      adj[Edges[i].second].push_back({Edges[i].first, i});
      degree[Edges[i].first]++;
      degree[Edges[i].second]++;
    }
    for (int i = 0; i < n; i++) {
      Good_set.insert({degree[i], i});
    }
    while (!Good_set.empty() && Good_set.begin()->first < k) {
      int node = Good_set.begin()->second;
      for (auto& y : adj[node]) {
        int x = y.first;
        if (in_good_set[x]) {
          Good_set.erase({degree[x], x});
          --degree[x];
          Good_set.insert({degree[x], x});
        }
      }
      Good_set.erase({degree[node], node});
      in_good_set[node] = false;
    }
    for (int i = m - 1; i >= 0; i--) {
      Ans[i] = Good_set.size();
      int u = Edges[i].first, v = Edges[i].second;
      if (in_good_set[u] && in_good_set[v]) {
        Good_set.erase({degree[u], u});
        --degree[u];
        Good_set.insert({degree[u], u});
        Good_set.erase({degree[v], v});
        --degree[v];
        Good_set.insert({degree[v], v});
        while (!Good_set.empty() && Good_set.begin()->first < k) {
          int node = Good_set.begin()->second;
          for (auto& y : adj[node]) {
            int x = y.first;
            if (y.second >= i) continue;
            if (in_good_set[x]) {
              Good_set.erase({degree[x], x});
              --degree[x];
              Good_set.insert({degree[x], x});
            }
          }
          Good_set.erase({degree[node], node});
          in_good_set[node] = false;
        }
      }
    }
    for (int i = 0; i < m; i++) {
      output << Ans[i] << "\n";
    }
  }
};
int32_t main() {
  int t = 1, i = 1;
  if (0 || 0) scanf("%d", &t);
  while (t--) {
    if (0) printf("Case #%d: ", i++);
    new solve;
  }
  output << "\n";
  return 0;
}
