#include <bits/stdc++.h>
using namespace std;
template <typename T, typename U>
ostream &operator<<(ostream &out, const pair<T, U> &p) {
  out << "(" << p.first << ", " << p.second << ")";
  return out;
}
template <template <typename, typename...> class ContainerType,
          typename ValueType, typename... Args>
void print(const ContainerType<ValueType, Args...> &c) {
  for (const auto &v : c) cout << v << ' ';
  cout << '\n';
}
void print() { cout << '\n'; }
template <typename T, typename... Args>
void print(T a, Args... args) {
  cout << a << " ";
  print(args...);
}
long long llipower(long long x, long long y, long long p = LLONG_MAX) {
  long long res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    set<int> a;
    int x;
    for (int i = 0; i < n; i++) {
      cin >> x;
      a.insert(x);
    }
    vector<int> b(m);
    for (int i = 0; i < m; i++) cin >> b[i];
    bool con = false;
    for (int i = 0; i < m; i++) {
      if (a.count(b[i])) {
        con = true;
        cout << "YES"
             << "\n";
        cout << 1 << " " << b[i] << "\n";
        break;
      }
    }
    if (!con)
      cout << "NO"
           << "\n";
  }
}
