#include <bits/stdc++.h>
using namespace std;
class Debugger {
 public:
  template <typename T>
  Debugger &operator<<(const T &v) {
    cerr << v;
    return *this;
  }
  ~Debugger() { cerr << endl; }
};
template <typename T1, typename T2>
inline ostream &operator<<(ostream &os, const pair<T1, T2> &p) {
  return os << "(" << p.first << ", " << p.second << ")";
}
template <typename T, size_t N>
inline ostream &operator<<(ostream &os, const array<T, N> &a) {
  bool first = true;
  os << "[";
  for (auto &v : a) {
    if (!first) os << ", ";
    os << v;
    first = false;
  }
  os << "]";
  return os;
}
template <typename T>
inline ostream &operator<<(ostream &os, const vector<T> &v) {
  bool first = true;
  os << "[";
  for (unsigned int i = 0; i < v.size(); i++) {
    if (!first) os << ", ";
    os << v[i];
    first = false;
  }
  return os << "]";
}
template <typename T>
inline ostream &operator<<(ostream &os, const set<T> &v) {
  bool first = true;
  os << "{";
  for (typename set<T>::const_iterator ii = v.begin(); ii != v.end(); ++ii) {
    if (!first) os << ", ";
    os << *ii;
    first = false;
  }
  return os << "}";
}
template <typename T1, typename T2>
inline ostream &operator<<(ostream &os, const map<T1, T2> &v) {
  bool first = true;
  os << "[";
  for (typename map<T1, T2>::const_iterator ii = v.begin(); ii != v.end();
       ++ii) {
    if (!first) os << ", ";
    os << *ii;
    first = false;
  }
  return os << "]";
}
const long long MOD = 1000000000 + 7;
const int dx[] = {-1, 1, 0, 0};
const int dy[] = {0, 0, 1, -1};
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long power_mod(long long x, long long y, long long p) {
  long long ans = 1;
  x %= p;
  while (y > 0) {
    if (y & 1) ans = (ans * x) % p;
    y >>= 1;
    x = (x * x) % p;
  }
  return ans;
}
inline long long modInverse(long long n, long long p) {
  return power_mod(n, p - 2, p);
}
long long nCrModP(vector<long long> &fac, long long n, long long r,
                  long long p) {
  if (r == 0) return 1;
  return (fac[n] * modInverse(fac[r], p) % p * modInverse(fac[n - r], p) % p) %
         p;
}
template <typename T>
void print_vector(const vector<T> &v) {
  for (int i = (0); i < (((int)(v).size())); i++) {
    if (i > 0) cout << " ";
    cout << v[i];
  }
  cout << endl;
}
int n, m;
long long dp[76][76];
bool state[76][76];
pair<pair<int, int>, int> minions[76];
bool update(long long &a, long long b) {
  if (a == -1 || b > a) {
    a = b;
    return true;
  }
  return false;
}
long long calculate(int lastOne) {
  memset(dp, -1, sizeof(dp));
  memset(state, 0, sizeof(state));
  dp[0][0] = 0;
  long long a, b;
  for (int i = (1); i < (n + 1); i++) {
    if (i == lastOne) {
      for (int j = (0); j < (m); j++) dp[i][j] = dp[i - 1][j];
      continue;
    }
    a = minions[i].first.second;
    b = minions[i].first.first;
    for (int j = (0); j < (m); j++) {
      if (dp[i - 1][j] != -1) {
        if (update(dp[i][j], dp[i - 1][j] + b * (m - 1))) state[i][j] = false;
      }
      if (j > 0 && dp[i - 1][j - 1] != -1) {
        if (update(dp[i][j], dp[i - 1][j - 1] + a + b * (j - 1)))
          state[i][j] = true;
      }
    }
  }
  a = minions[lastOne].first.second;
  b = minions[lastOne].first.first;
  return dp[n][m - 1] + a + b * (m - 1);
}
void solve() {
  cin >> n >> m;
  for (int i = (1); i < (n + 1); i++) {
    cin >> minions[i].first.second >> minions[i].first.first;
    minions[i].second = i;
  }
  sort(minions + 1, minions + n + 1);
  long long mx = 0;
  int lastOne = -1;
  for (int i = (1); i < (n + 1); i++) {
    long long t = calculate(i);
    if (t > mx) {
      mx = t;
      lastOne = i;
    }
  }
  assert(lastOne != -1);
  calculate(lastOne);
  vector<int> vis(n + 1, false);
  int x = n, y = m - 1;
  while (x > 0) {
    if (state[x][y]) {
      vis[x] = true;
      y--;
    }
    x--;
  }
  vector<int> ans;
  for (int i = (1); i < (n + 1); i++) {
    if (vis[i] && i != lastOne) ans.push_back(minions[i].second);
  }
  for (int i = (1); i < (n + 1); i++) {
    if (!vis[i] && i != lastOne) {
      ans.push_back(minions[i].second);
      ans.push_back(-minions[i].second);
    }
  }
  ans.push_back(minions[lastOne].second);
  cout << ((int)(ans).size()) << endl;
  print_vector(ans);
}
int main() {
  ios_base::sync_with_stdio(false);
  srand(time(NULL));
  cin.tie(NULL);
  cout.tie(NULL);
  int cas;
  cin >> cas;
  for (int i = (0); i < (cas); i++) {
    solve();
  }
}
