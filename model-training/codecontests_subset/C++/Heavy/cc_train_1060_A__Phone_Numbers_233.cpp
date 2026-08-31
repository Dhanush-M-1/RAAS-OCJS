#include <bits/stdc++.h>
using namespace std;
const long double pi = 2 * acos(0.0);
template <class T>
bool umin(T& a, T b) {
  if (a > b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
bool umax(T& a, T b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T, class TT>
bool pal(T a, TT n) {
  int k = 0;
  for (int i = 0; i <= n / 2; i++) {
    if (a[i] != a[n - i - 1]) {
      k = 1;
      break;
    }
  }
  return k ? 0 : 1;
}
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int cnt = 0;
  for (int i = 0; i < s.size(); i++) cnt += (s[i] == '8');
  cout << min(cnt, n / 11);
  getchar();
  getchar();
  return 0;
}
