#include <bits/stdc++.h>
using namespace std;
template <class c>
struct rge {
  c b, e;
};
template <class c>
rge<c> range(c i, c j) {
  return rge<c>{i, j};
}
template <class c>
auto dud(c* x) -> decltype(cerr << *x, 0);
template <class c>
char dud(...);
struct debug {
  template <class c>
  debug& operator<<(const c&) {
    return *this;
  }
};
int n;
string a, b, s;
int main() {
  cin >> a >> b;
  cin >> n;
  cout << a << " " << b << endl;
  for (int i = 1; i <= n; i++) {
    cin >> s;
    if (a == s) {
      cin >> s;
      a = s;
    } else {
      cin >> s;
      b = s;
    }
    cout << a << " " << b << endl;
  }
  return 0;
}
