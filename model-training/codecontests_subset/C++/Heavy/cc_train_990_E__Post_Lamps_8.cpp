#include <bits/stdc++.h>
using namespace std;
const double PI = 3.141592653589;
template <class T>
void dbs(string str, T t) {
  cerr << str << " : " << t << "\n";
}
template <class T, class... S>
void dbs(string str, T t, S... s) {
  long long idx = str.find(',');
  cerr << str.substr(0, idx) << " : " << t << ", ";
  dbs(str.substr(idx + 1), s...);
}
template <class S, class T>
ostream& operator<<(ostream& os, const pair<S, T>& p) {
  return os << "(" << p.first << ", " << p.second << ")";
}
template <class T>
ostream& operator<<(ostream& os, const vector<T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class T>
ostream& operator<<(ostream& os, const set<T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class S, class T>
ostream& operator<<(ostream& os, const map<S, T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class T>
void prc(T a, T b) {
  cerr << "[";
  for (T i = a; i != b; ++i) {
    if (i != a) cerr << ", ";
    cerr << *i;
  }
  cerr << "]\n";
}
const long long MAX = 1e6 + 5;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n, m, k;
  cin >> n >> m >> k;
  vector<long long> s(m), a(k);
  for (long long i = 0; i < m; i++) cin >> s[i];
  for (long long i = 0; i < k; i++) cin >> a[i];
  if (!m) {
    long long ans = 1e18;
    for (long long i = 0; i < k; i++) {
      long long times = (n - 1) / (i + 1) + 1;
      ans = min(ans, times * a[i]);
    }
    cout << ans << "\n";
    return 0;
  }
  if (s[0] == 0) {
    cout << "-1\n";
    return 0;
  }
  long long last = s[0], cont = 1, curr = 1;
  for (long long i = 1; i < m; i++) {
    if (last != s[i] - 1) {
      cont = max(curr, cont);
      curr = 1;
    } else
      curr++;
    last = s[i];
  }
  cont = max(curr, cont);
  cont++;
  vector<long long> pos(MAX, 0);
  for (long long i = 0; i < m; i++) {
    pos[s[i]] = 1;
  }
  long long cost = 1e18;
  vector<long long> free;
  long long ptr = 0;
  for (long long i = 1; i <= n; i++) {
    if (ptr < n and s[ptr] == i) {
      ptr++;
    } else
      free.push_back(i);
  }
  for (long long i = cont - 1; i < k; i++) {
    long long l = i + 1;
    long long num_req = 1;
    long long start = l;
    while (start < n) {
      if (pos[start]) {
        start = *(lower_bound((free).begin(), (free).end(), start) - 1);
      }
      num_req++;
      start += l;
    }
    cost = min(cost, num_req * a[i]);
  }
  if (cost == (long long)1e18) cost = -1;
  cout << cost << "\n";
  return 0;
}
