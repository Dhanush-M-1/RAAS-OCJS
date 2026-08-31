#include <bits/stdc++.h>
using namespace std;
using lint = long long int;
using pint = pair<int, int>;
using plint = pair<lint, lint>;
struct fast_ios {
  fast_ios() {
    cin.tie(0);
    ios::sync_with_stdio(false);
    cout << fixed << setprecision(20);
  };
} fast_ios_;
template <typename T>
istream &operator>>(istream &is, vector<T> &vec) {
  for (auto &v : vec) is >> v;
  return is;
}
template <typename T>
bool chmax(T &m, const T q) {
  if (m < q) {
    m = q;
    return true;
  } else
    return false;
}
template <typename T>
bool chmin(T &m, const T q) {
  if (q < m) {
    m = q;
    return true;
  } else
    return false;
}
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
template <class c>
struct rge {
  c b, e;
};
template <class c>
rge<c> range(c i, c j) {
  return rge<c>{i, j};
}
template <class c>
auto dud(c *x) -> decltype(cerr << *x, 0);
template <class c>
char dud(...);
struct deb {
  ~deb() { cerr << endl; }
  template <class c>
  typename enable_if<sizeof dud<c>(0) != 1, deb &>::type operator<<(c i) {
    cerr << boolalpha << i;
    return *this;
  }
  template <class c>
  typename enable_if<sizeof dud<c>(0) == 1, deb &>::type operator<<(c i) {
    return *this << range(begin(i), end(i));
  }
  template <class c, class b>
  deb &operator<<(pair<b, c> d) {
    return *this << "(" << d.first << ", " << d.second << ")";
  }
  template <class c>
  deb &operator<<(rge<c> d) {
    *this << "[";
    for (auto it = d.b; it != d.e; ++it) *this << ", " + 2 * (it == d.b) << *it;
    return *this << "]";
  }
};
void err(istream_iterator<string> it) { return; }
template <typename T, typename... Args>
void err(istream_iterator<string> it, T a, Args... args) {
  cerr << *it << " = " << a << endl;
  err(++it, args...);
}
void solve() {
  lint n, k;
  cin >> n >> k;
  vector<lint> time(n);
  vector<lint> alice(n);
  vector<lint> bob(n);
  priority_queue<int, vector<int>, greater<int>> abra;
  priority_queue<int, vector<int>, greater<int>> cadabra;
  priority_queue<int, vector<int>, greater<int>> mixed;
  for (int i = (0), i_end_ = (n); i < i_end_; i++) {
    lint t, a, b;
    cin >> t >> a >> b;
    time[i] = t;
    alice[i] = a;
    bob[i] = b;
    if (a == 1 && b == 1) {
      mixed.push(t);
    } else if (a == 1) {
      abra.push(t);
    } else if (b == 1) {
      cadabra.push(t);
    }
  }
  lint ret = 0;
  lint cc = 2 * k;
  lint s1 = accumulate(begin(alice), end(alice), 0LL);
  lint s2 = accumulate(begin(bob), end(bob), 0LL);
  if (s1 <= k - 1 || s2 <= k - 1) {
    cout << -1 << '\n';
    return;
  }
  while (cc) {
    bool ok = 0;
    int f = 0;
    lint t = INT_MAX;
    if (mixed.size() > 0) {
      t = mixed.top();
      ok = 1;
    }
    lint t1 = INT_MAX;
    lint t2 = INT_MAX;
    if (abra.size()) {
      t1 = abra.top();
      ++f;
    }
    if (cadabra.size()) {
      t2 = cadabra.top();
      ++f;
    }
    if (!ok && f <= 1) break;
    if (t <= t1 + t2) {
      ret += t;
      mixed.pop();
    } else {
      ret += t1 + t2;
      abra.pop();
      cadabra.pop();
    }
    cc -= 2;
  }
  cout << ret << '\n';
}
int main() {
  int T = 1;
  for (int tt = 1; tt <= T; ++tt) {
    solve();
  }
  return 0;
}
lint pow_mod(lint base, lint expo) {
  lint ret = 1;
  for (; expo;) {
    if (expo & 1) ret = (ret * base) % 1000000007;
    expo = (expo >> 1);
    base = (base * base) % 1000000007;
  }
  return ret;
}
