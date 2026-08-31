#include <bits/stdc++.h>
#pragma GCC optimize("Ofast,unroll-loops")
#pragma GCC target( \
    "sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,avx2,tune=native")
using namespace std;
void itval(istream_iterator<string> it) {}
template <typename T, typename... Args>
void itval(istream_iterator<string> it, T a, Args... args) {
  cerr << *it << " = " << a << endl;
  itval(++it, args...);
}
const long long int MOD = 1e9 + 7;
template <typename T>
inline void print(T x) {
  cout << x << "\n";
}
template <typename T>
inline void printvec(T x) {
  for (auto a : x) cout << a << ' ';
  cout << '\n';
}
struct custom {
  bool operator()(const pair<long long int, long long int> &p1,
                  const pair<long long int, long long int> &p2) const {
    return p1.first < p2.first;
  }
};
long long int get_pow(long long int a, long long int b, long long int M = MOD) {
  long long int res = 1;
  while (b) {
    if (b & 1) res = (res * a) % M;
    a = (a * a) % M;
    b >>= 1;
  }
  return res;
}
const long long int N = 2e5 + 5, inf = 4e18;
int deg[N], done[N];
std::vector<int> adj[N], nxt[N];
vector<int> order;
void travel(int s) {
  order.push_back(s + 1);
  for (auto x : nxt[s]) travel(x);
}
void dfs(int s, int p) {
  for (auto x : adj[s]) {
    if (x != p) {
      dfs(x, s);
    }
  }
  int cnt = 0;
  vector<int> lef;
  for (auto x : adj[s]) {
    if (x == p) continue;
    if (done[x])
      cnt++;
    else
      lef.push_back(x);
  }
  if ((deg[s] - cnt) % 2 == 0) {
    order.push_back(s + 1);
    done[s] = 1;
    for (auto x : lef) travel(x);
  } else {
    for (auto x : lef) nxt[s].push_back(x);
  }
}
void solve() {
  int n, x;
  cin >> n;
  for (long long int i = (long long int)0; i < (long long int)(n); i++) {
    cin >> x;
    x--;
    if (x != -1) {
      adj[x].push_back(i);
      adj[i].push_back(x);
      deg[x]++;
      deg[i]++;
    }
  }
  if (n == 1) {
    cout << "YES\n1\n";
    return;
  }
  for (long long int i = (long long int)0; i < (long long int)(n); i++) {
    if (deg[i] == 1) {
      dfs(i, -1);
      break;
    }
  }
  if (order.size() != n) {
    cout << "NO\n";
    return;
  }
  cout << "YES\n";
  for (auto x : order) cout << x << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int test = 1;
  clock_t z = clock();
  for (long long int tes = (long long int)0; tes < (long long int)(test);
       tes++) {
    solve();
  }
  fprintf(stderr, "Total Time:%.4f\n", (double)(clock() - z) / CLOCKS_PER_SEC),
      fflush(stderr);
  return 0;
}
