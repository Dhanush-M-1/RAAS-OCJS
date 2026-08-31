#include <bits/stdc++.h>
using namespace std;
template <class T>
bool chmax(T &a, const T &b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
bool chmin(T &a, const T &b) {
  if (a > b) {
    a = b;
    return 1;
  }
  return 0;
}
template <typename T>
istream &operator>>(istream &is, vector<T> &vec) {
  for (auto &v : vec) is >> v;
  return is;
}
template <typename T>
ostream &operator<<(ostream &os, const vector<T> &vec) {
  for (int i = 0; i < vec.size(); i++) {
    os << vec[i];
    if (i + 1 != vec.size()) os << " ";
  }
  return os;
}
template <typename T>
ostream &operator<<(ostream &os, const set<T> &st) {
  for (auto itr = st.begin(); itr != st.end(); ++itr) {
    os << *itr;
    auto titr = itr;
    if (++titr != st.end()) os << " ";
  }
  return os;
}
template <typename T>
ostream &operator<<(ostream &os, const unordered_set<T> &st) {
  for (auto itr = st.begin(); itr != st.end(); ++itr) {
    os << *itr;
    auto titr = itr;
    if (++titr != st.end()) os << " ";
  }
  return os;
}
template <typename T>
ostream &operator<<(ostream &os, const multiset<T> &st) {
  for (auto itr = st.begin(); itr != st.end(); ++itr) {
    os << *itr;
    auto titr = itr;
    if (++titr != st.end()) os << " ";
  }
  return os;
}
template <typename T>
ostream &operator<<(ostream &os, const unordered_multiset<T> &st) {
  for (auto itr = st.begin(); itr != st.end(); ++itr) {
    os << *itr;
    auto titr = itr;
    if (++titr != st.end()) os << " ";
  }
  return os;
}
template <typename T1, typename T2>
ostream &operator<<(ostream &os, const pair<T1, T2> &p) {
  os << p.first << " " << p.second;
  return os;
}
template <typename T1, typename T2>
ostream &operator<<(ostream &os, const map<T1, T2> &mp) {
  for (auto itr = mp.begin(); itr != mp.end(); ++itr) {
    os << itr->first << ":" << itr->second;
    auto titr = itr;
    if (++titr != mp.end()) os << " ";
  }
  return os;
}
template <typename T1, typename T2>
ostream &operator<<(ostream &os, const unordered_map<T1, T2> &mp) {
  for (auto itr = mp.begin(); itr != mp.end(); ++itr) {
    os << itr->first << ":" << itr->second;
    auto titr = itr;
    if (++titr != mp.end()) os << " ";
  }
  return os;
}
using ll = long long int;
using P = pair<int, int>;
const int inf = 1e9;
const ll linf = 1LL << 50;
const double EPS = 1e-10;
const int mod = 1000000007;
const int dx[4] = {-1, 0, 1, 0};
const int dy[4] = {0, -1, 0, 1};
struct fast_io {
  fast_io() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout << fixed << setprecision(20);
  }
} fast_io_;
int main(int argc, char const *argv[]) {
  int t, m;
  cin >> t >> m;
  vector<ll> a(m, 0);
  int curr = 1;
  for (int i = (0); i < (t); ++i) {
    string s;
    cin >> s;
    if (s == "alloc") {
      ll x;
      cin >> x;
      bool flg = false;
      for (int i = 0; i + x <= m; i++) {
        bool ok = true;
        for (int j = 0; j < x; j++) {
          if (a[i + j] != 0) ok = false;
        }
        if (ok) {
          for (int j = (0); j < (x); ++j) a[i + j] = curr;
          cout << curr << endl;
          curr++;
          flg = true;
          break;
        }
      }
      if (!flg) cout << "NULL" << endl;
    } else if (s == "erase") {
      ll x;
      cin >> x;
      bool flg = false;
      for (int i = (0); i < (m); ++i)
        if (a[i] == x && a[i] != 0) a[i] = 0, flg = true;
      if (!flg) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    } else {
      vector<ll> b;
      b.reserve(m);
      for (int i = (0); i < (m); ++i)
        if (a[i] != 0) b.emplace_back(a[i]);
      b.resize(m, 0);
      swap(a, b);
    }
  }
  return 0;
}
