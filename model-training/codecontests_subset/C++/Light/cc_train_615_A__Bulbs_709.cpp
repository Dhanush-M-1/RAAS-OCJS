#include <bits/stdc++.h>
using namespace std;
template <class T1, class T2>
inline bool chmin(T1 &a, T2 b) {
  return b < a && (a = b, true);
}
template <class T1, class T2>
inline bool chmax(T1 &a, T2 b) {
  return a < b && (a = b, true);
}
using ll = long long;
int main() {
  int n, m;
  cin >> n >> m;
  vector<int> good(m);
  for (int i = (0); i < (n); i++) {
    int x;
    cin >> x;
    for (int j = (0); j < (x); j++) {
      int y;
      cin >> y;
      good[y - 1] = true;
    }
  }
  bool ans = true;
  for (int i = (0); i < (m); i++) ans &= good[i];
  cout << (ans ? "YES" : "NO") << endl;
  return 0;
}
