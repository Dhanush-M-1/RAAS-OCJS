#include <bits/stdc++.h>
using namespace std;
template <class T>
void debug(T a, T b) {
  ;
}
template <class T>
void chmin(T& a, const T& b) {
  if (a > b) a = b;
}
template <class T>
void chmax(T& a, const T& b) {
  if (a < b) a = b;
}
namespace std {
template <class S, class T>
ostream& operator<<(ostream& out, const pair<S, T>& a) {
  out << '(' << a.first << ',' << a.second << ')';
  return out;
}
}  // namespace std
int n;
pair<int, int> ps[100005];
vector<int> x[100005], y[100005];
int main() {
  cin >> n;
  for (int i = 0; i < (n); ++i) scanf("%d%d", &ps[i].first, &ps[i].second);
  sort(ps, ps + n);
  int res = 0;
  for (int i = n - 1; i >= 0; --i) {
    pair<int, int> p = ps[i];
    if (x[p.first].size() > y[p.second].size()) {
      for (int j = 0; j < (y[p.second].size()); ++j) {
        int dif = y[p.second][j] - p.first;
        if (binary_search((x[p.first]).begin(), (x[p.first]).end(),
                          p.second + dif, greater<int>()) &&
            binary_search(ps, ps + n, make_pair(p.first + dif, p.second + dif)))
          ++res;
      }
    } else {
      for (int j = 0; j < (x[p.first].size()); ++j) {
        int dif = x[p.first][j] - p.second;
        if (binary_search((y[p.second]).begin(), (y[p.second]).end(),
                          p.first + dif, greater<int>()) &&
            binary_search(ps, ps + n, make_pair(p.first + dif, p.second + dif)))
          ++res;
      }
    }
    x[p.first].push_back(p.second);
    y[p.second].push_back(p.first);
    ;
    ;
    ;
    ;
  }
  cout << res << endl;
  return 0;
}
