#include <bits/stdc++.h>
using namespace std;
struct cww {
  cww() {
    if (1) {
      ios::sync_with_stdio(false);
      cin.tie(0);
    }
  }
} star;
template <typename T>
inline bool chmin(T &l, T r) {
  bool a = l > r;
  if (a) l = r;
  return a;
}
template <typename T>
inline bool chmax(T &l, T r) {
  bool a = l < r;
  if (a) l = r;
  return a;
}
template <typename T>
istream &operator>>(istream &is, vector<T> &v) {
  for (auto &it : v) is >> it;
  return is;
}
class range {
 private:
  struct I {
    int x;
    int operator*() { return x; }
    bool operator!=(I &lhs) { return x < lhs.x; }
    void operator++() { ++x; }
  };
  I i, n;

 public:
  range(int n) : i({0}), n({n}) {}
  range(int i, int n) : i({i}), n({n}) {}
  I &begin() { return i; }
  I &end() { return n; }
};
int main() {
  int n;
  cin >> n;
  int k = 0;
  string s;
  cin >> s;
  for (int i : range(n)) {
    if (s[i] == '8') k++;
  }
  int ret = 0;
  for (int i : range(n)) {
    if (i <= k && n - i >= 10 * i) ret = i;
  }
  cout << ret << endl;
  return 0;
}
