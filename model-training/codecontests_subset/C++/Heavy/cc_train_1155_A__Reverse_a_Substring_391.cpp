#include <bits/stdc++.h>
using namespace std;
template <class T>
bool chmax(T &a, T b) {
  if (a < b) {
    a = b;
    return true;
  }
  return false;
}
template <class T>
bool chmin(T &a, T b) {
  if (a > b) {
    a = b;
    return true;
  }
  return false;
}
const int INF = 1 << 30;
const long long INFL = 1LL << 60;
const long long mod = 1000000009;
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i < int(n - 1); i++) {
    if (s[i] > s[i + 1]) {
      cout << "YES" << endl;
      cout << i + 1 << ' ' << i + 2 << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
}
