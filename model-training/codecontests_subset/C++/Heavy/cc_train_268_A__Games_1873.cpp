#include <bits/stdc++.h>
template <class T, class U>
T getMin(T a, U b) {
  return (a < b ? a : b);
}
template <class T, class U>
T getMax(T a, U b) {
  return (a > b ? a : b);
}
template <class T>
T charIndexS(T c) {
  return c - 96;
}
template <class T>
T charIndexL(T c) {
  return c - 64;
}
template <class T, class U, class O, class P>
T arrayOutofBoundary(T r, U c, O m, P n) {
  return r < 0 || c < 0 || r == m || c == n;
}
template <class T, class U>
T power(T base, U exponent) {
  return (exponent == 0) ? 1 : (base * pow(base, exponent - 1));
}
int dx[] = {+0, +0, +1, -1, -1, +1, -1, +1};
int dy[] = {-1, +1, +0, +0, +1, +1, -1, -1};
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  vector<int> h(105, 0);
  vector<int> g(105, 0);
  int result = 0;
  while (n--) {
    int a, b;
    cin >> a >> b;
    h[a]++;
    g[b]++;
    if (g[a]) result += g[a];
    if (h[b]) result += h[b];
  }
  cout << result << endl;
  return 0;
}
