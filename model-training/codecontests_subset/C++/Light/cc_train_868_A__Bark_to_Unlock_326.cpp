#include <bits/stdc++.h>
using namespace std;
template <class T1>
void deb(T1 e1) {
  cout << e1 << endl;
}
template <class T1, class T2>
void deb(T1 e1, T2 e2) {
  cout << e1 << " " << e2 << endl;
}
template <class T1, class T2, class T3>
void deb(T1 e1, T2 e2, T3 e3) {
  cout << e1 << " " << e2 << " " << e3 << endl;
}
void check_time() {}
const int res = 2e5 + 10;
const long long int mod = 1e9 + 7;
int main() {
  string s, x;
  int n, sum = 0, ans = 0;
  cin >> s;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    cin >> x;
    if (x == s) {
      deb("YES");
      return 0;
    }
    if (s[1] == x[0]) {
      sum = 1;
    }
    if (s[0] == x[1]) {
      ans = 1;
    }
  }
  cout << ((sum == 1 and ans == 1) ? "YES\n" : "NO\n") << endl;
  return 0;
}
