#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-9;
const int inf = 2000000000;
const long long infLL = 9000000000000000000;
template <typename first, typename second>
ostream& operator<<(ostream& os, const pair<first, second>& p) {
  return os << "(" << p.first << ", " << p.second << ")";
}
template <typename T>
ostream& operator<<(ostream& os, const vector<T>& v) {
  os << "{";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ", ";
    os << *it;
  }
  return os << "}";
}
template <typename T>
ostream& operator<<(ostream& os, const set<T>& v) {
  os << "[";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ",";
    os << *it;
  }
  return os << "]";
}
template <typename T>
ostream& operator<<(ostream& os, const multiset<T>& v) {
  os << "[";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ", ";
    os << *it;
  }
  return os << "]";
}
template <typename first, typename second>
ostream& operator<<(ostream& os, const map<first, second>& v) {
  os << "[";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ", ";
    os << it->first << " = " << it->second;
  }
  return os << "]";
}
void faltu() { cerr << '\n'; }
template <typename T>
void faltu(T a[], int n) {
  for (int i = 0; i < n; ++i) cerr << a[i] << ' ';
  cerr << '\n';
}
template <typename T, typename... hello>
void faltu(T arg, const hello&... rest) {
  cerr << arg << ' ';
  faltu(rest...);
}
int n, k;
vector<pair<pair<int, int>, int>> vec;
int dp[80][80];
vector<int> store;
int recur(int pos, int taken) {
  if (pos == n) {
    if (taken == k) return 0;
    return -inf;
  }
  if (dp[pos][taken] != -1) return dp[pos][taken];
  int ret = 0;
  if (taken < k)
    ret = vec[pos].first.second + vec[pos].first.first * taken +
          recur(pos + 1, taken + 1);
  ret = max(ret, vec[pos].first.first * (k - 1) + recur(pos + 1, taken));
  dp[pos][taken] = ret;
  return ret;
}
void print(int pos, int taken) {
  if (pos == n) return;
  if (taken < k && recur(pos, taken) == vec[pos].first.second +
                                            vec[pos].first.first * taken +
                                            recur(pos + 1, taken + 1)) {
    store.push_back(vec[pos].second + 1);
    print(pos + 1, taken + 1);
    return;
  }
  if (recur(pos, taken) ==
      vec[pos].first.first * (k - 1) + recur(pos + 1, taken)) {
    store.push_back(-vec[pos].second - 1);
    print(pos + 1, taken);
    return;
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int T;
  cin >> T;
  while (T--) {
    memset(dp, -1, sizeof(dp));
    vec.clear();
    store.clear();
    cin >> n >> k;
    vec.resize(n);
    for (int i = 0; i < n; ++i)
      cin >> vec[i].first.second >> vec[i].first.first, vec[i].second = i;
    sort(vec.begin(), vec.end());
    cout << 2 * n - k << '\n';
    print(0, 0);
    for (int i = 0, j = 0; i < n && j < k - 1; ++i) {
      if (store[i] > 0) {
        ++j;
        cout << store[i] << " ";
      }
    }
    for (int i = 0; i < n; ++i) {
      if (store[i] < 0) {
        cout << -store[i] << " " << store[i] << " ";
      }
    }
    for (int i = n - 1; i >= 0; --i) {
      if (store[i] > 0) {
        cout << store[i] << '\n';
        break;
      }
    }
  }
}
