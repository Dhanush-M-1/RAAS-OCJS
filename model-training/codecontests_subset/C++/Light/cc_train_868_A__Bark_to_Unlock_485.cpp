#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int main(void) {
  cin.tie(0)->sync_with_stdio(false);
  string pw;
  cin >> pw;
  int n;
  cin >> n;
  string w[n];
  for (int i = 0; i < n; i++) {
    cin >> w[i];
    if (w[i] == pw) {
      cout << "YES" << '\n';
      return 0;
    }
  }
  bool f = false, s = false;
  for (int i = 0; i < n; i++) {
    if (w[i][1] == pw[0]) {
      f = true;
    }
    if (w[i][0] == pw[1]) {
      s = true;
    }
    if (f == true && s == true) {
      cout << "YES" << '\n';
      return 0;
    }
  }
  cout << "NO" << '\n';
  return 0;
}
