#include <bits/stdc++.h>
using namespace std;
int mod = 1000000007;
const int inf = 1034567891;
const long long LL_INF = 1234567890123456789ll;
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cout << name << " : " << arg1 << '\n';
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cout.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
template <typename T>
T GCD(T a, T b) {
  long long t;
  while (a) {
    t = a;
    a = b % a;
    b = t;
  }
  return b;
}
template <typename T>
string toString(T a) {
  return to_string(a);
}
template <typename T>
void toInt(string s, T& x) {
  stringstream str(s);
  str >> x;
}
inline int add(int x, int y) {
  x += y;
  if (x >= mod) x -= mod;
  return x;
}
inline int sub(int x, int y) {
  x -= y;
  if (x < 0) x += mod;
  return x;
}
inline int mul(int x, int y) { return (x * 1ll * y) % mod; }
inline int powr(int a, long long b) {
  int x = 1 % mod;
  while (b) {
    if (b & 1) x = mul(x, a);
    a = mul(a, a);
    b >>= 1;
  }
  return x;
}
inline int inv(int a) { return powr(a, mod - 2); }
const int N = 2e5 + 5;
int tt[N], aa[N], bb[N];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m, k;
  cin >> n >> m >> k;
  vector<pair<long long, long long> > vec[4];
  for (int i = 0; i < 4; i++) vec[i].push_back({0, 0});
  for (int i = 0; i < n; i++) {
    cin >> tt[i] >> aa[i] >> bb[i];
    int x = aa[i] * 2 + bb[i];
    vec[x].push_back({tt[i], i + 1});
  }
  int a = vec[2].size() - 1, b = vec[1].size() - 1, ab = vec[3].size() - 1,
      d = vec[0].size() - 1;
  if (a + ab < k || b + ab < k) {
    cout << -1 << '\n';
    return 0;
  }
  for (int i = 0; i < 4; i++) {
    sort(vec[i].begin(), vec[i].end());
  }
  for (int i = 1; i <= a; i++) {
    vec[2][i].first += vec[2][i - 1].first;
  }
  for (int i = 1; i <= b; i++) {
    vec[1][i].first += vec[1][i - 1].first;
  }
  for (int i = 1; i <= ab; i++) {
    vec[3][i].first += vec[3][i - 1].first;
  }
  set<pair<long long, long long> > s;
  for (int i = 1; i <= d; i++) {
    s.insert({vec[0][i].first, vec[0][i].second});
  }
  for (int i = 1; i <= ab; i++) {
    s.insert({vec[3][i].first - vec[3][i - 1].first, vec[3][i].second});
  }
  long long sum = 0;
  for (auto it : s) {
    sum += it.first;
  }
  long long ans = LL_INF, pos = 0, p1 = 0, p2 = 0;
  int id1 = a, id2 = b;
  set<pair<long long, long long> > temp;
  bool first = false;
  set<pair<long long, long long> > ready;
  for (int i = 0; i <= ab; i++) {
    int x = k - i;
    int y = m - i - 2 * x;
    if (i) {
      auto it =
          make_pair(vec[3][i].first - vec[3][i - 1].first, vec[3][i].second);
      ready.erase(it);
      if (s.count(it)) {
        sum -= it.first;
        s.erase(it);
      }
    }
    if (y < 0 || x < 0 || x > min(a, b)) continue;
    if (!first) {
      for (int j = x + 1; j <= a; j++) {
        sum += vec[2][j].first - vec[2][j - 1].first;
        s.insert({vec[2][j].first - vec[2][j - 1].first, vec[2][j].second});
      }
      for (int j = x + 1; j <= b; j++) {
        sum += vec[1][j].first - vec[1][j - 1].first;
        s.insert({vec[1][j].first - vec[1][j - 1].first, vec[1][j].second});
      }
    }
    first = true;
    while (s.size() && s.size() > y) {
      ready.insert(*s.rbegin());
      sum -= (*s.rbegin()).first;
      s.erase(*s.rbegin());
    }
    while (ready.size() && s.size() < y) {
      auto it = *ready.begin();
      sum += it.first;
      s.insert(it);
      ready.erase(it);
    }
    while (ready.size() && s.size() &&
           (*ready.begin()).first < (*s.rbegin()).first) {
      auto it1 = *ready.begin();
      auto it2 = *s.rbegin();
      sum -= it2.first;
      sum += it1.first;
      s.erase(it2);
      ready.erase(it1);
      s.insert(it1);
      ready.insert(it2);
    }
    long long cur = vec[3][i].first + vec[2][x].first + vec[1][x].first + sum;
    if (s.size() == y) {
      if (cur < ans) {
        ans = cur;
        pos = i;
        p1 = x;
        p2 = x;
      }
    }
    if (x > 0 && x <= a) {
      sum += vec[2][x].first - vec[2][x - 1].first;
      s.insert({vec[2][x].first - vec[2][x - 1].first, vec[2][x].second});
    }
    if (x > 0 && x <= b) {
      sum += vec[1][x].first - vec[1][x - 1].first;
      s.insert({vec[1][x].first - vec[1][x - 1].first, vec[1][x].second});
    }
  }
  if (ans == LL_INF) {
    cout << -1 << '\n';
    return 0;
  }
  cout << ans << '\n';
  for (int i = 1; i <= pos; i++) {
    cout << vec[3][i].second << " ";
  }
  for (int i = 1; i <= p2; i++) {
    cout << vec[1][i].second << " ";
  }
  for (int i = 1; i <= p1; i++) {
    cout << vec[2][i].second << " ";
  }
  s.clear();
  ready.clear();
  for (int i = 1; i <= d; i++) {
    s.insert({vec[0][i].first, vec[0][i].second});
  }
  for (int i = 1; i <= ab; i++) {
    s.insert({vec[3][i].first - vec[3][i - 1].first, vec[3][i].second});
  }
  sum = 0;
  for (auto it : s) {
    sum += it.first;
  }
  first = false;
  for (int i = 0; i <= ab; i++) {
    int x = k - i;
    int y = m - i - 2 * x;
    if (i) {
      auto it =
          make_pair(vec[3][i].first - vec[3][i - 1].first, vec[3][i].second);
      ready.erase(it);
      if (s.count(it)) {
        sum -= it.first;
        s.erase(it);
      }
    }
    if (y < 0 || x < 0 || x > min(a, b)) continue;
    if (!first) {
      for (int j = x + 1; j <= a; j++) {
        sum += vec[2][j].first - vec[2][j - 1].first;
        s.insert({vec[2][j].first - vec[2][j - 1].first, vec[2][j].second});
      }
      for (int j = x + 1; j <= b; j++) {
        sum += vec[1][j].first - vec[1][j - 1].first;
        s.insert({vec[1][j].first - vec[1][j - 1].first, vec[1][j].second});
      }
    }
    first = true;
    while (s.size() && s.size() > y) {
      ready.insert(*s.rbegin());
      sum -= (*s.rbegin()).first;
      s.erase(*s.rbegin());
    }
    while (ready.size() && s.size() < y) {
      auto it = *ready.begin();
      sum += it.first;
      s.insert(it);
      ready.erase(it);
    }
    while (ready.size() && s.size() &&
           (*ready.begin()).first < (*s.rbegin()).first) {
      auto it1 = *ready.begin();
      auto it2 = *s.rbegin();
      sum -= it2.first;
      sum += it1.first;
      s.erase(it2);
      ready.erase(it1);
      s.insert(it1);
      ready.insert(it2);
    }
    long long cur = vec[3][i].first + vec[2][x].first + vec[1][x].first + sum;
    if (i == pos) {
      for (auto it : s) {
        cout << it.second << " ";
      }
      cout << '\n';
      return 0;
    }
    if (x > 0 && x <= a) {
      sum += vec[2][x].first - vec[2][x - 1].first;
      s.insert({vec[2][x].first - vec[2][x - 1].first, vec[2][x].second});
    }
    if (x > 0 && x <= b) {
      sum += vec[1][x].first - vec[1][x - 1].first;
      s.insert({vec[1][x].first - vec[1][x - 1].first, vec[1][x].second});
    }
  }
  cout << '\n';
  return 0;
}
