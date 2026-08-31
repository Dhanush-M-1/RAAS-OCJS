#include <bits/stdc++.h>
using namespace std;
long long min(long long x, long long y) {
  if (x < y) return x;
  return y;
}
long long max(long long x, long long y) {
  if (x > y) return x;
  return y;
}
int main() {
  long long n, i;
  char x, y;
  cin >> x >> y;
  cin >> n;
  char a, b;
  string s[n];
  map<char, long long> m;
  for (i = 0; i < n; i++) {
    cin >> s[i];
    if (s[i][0] == x && s[i][1] == y) {
      cout << "YES" << '\n';
      return 0;
    }
  }
  long long flag = 0;
  for (i = 0; i < n; i++) {
    if (s[i][1] == x) {
      flag = 1;
      break;
    }
  }
  if (flag) {
    flag = 0;
    for (i = 0; i < n; i++) {
      if (s[i][0] == y) {
        flag = 1;
        break;
      }
    }
  }
  if (flag)
    cout << "YES" << '\n';
  else
    cout << "NO" << '\n';
}
