#include <bits/stdc++.h>
using namespace std;
template <class T>
ostream& operator<<(ostream& os, vector<T> v) {
  for (typename vector<T>::iterator it_i = v.begin(); it_i != v.end(); ++it_i) {
    os << *it_i << ", ";
  }
  return os;
}
int n, x, y;
int solve() {
  for (int i = 0; i <= 100 * n - x; ++i) {
    if ((x + i) * 100 >= y * n) return i;
  }
  return 10 * n - x;
}
int main() {
  while (cin >> n >> x >> y) {
    cout << solve() << endl;
  }
  return 0;
}
