#include <bits/stdc++.h>
using namespace std;
bool sortbysec(const pair<int, int> &a, const pair<int, int> &b) {
  return (a.second < b.second);
}
long long countdigit(long long n) {
  long long x = n, c = 0;
  while (x != 0) {
    x = x / 10;
    c++;
  }
  return c;
}
void solve() {
  long long n;
  cin >> n;
  string s[n];
  for (int i = 0; i < n; i++) cin >> s[i];
  if (s[0][1] == s[1][0]) {
    if (s[n - 1][n - 2] == s[n - 2][n - 1]) {
      if (s[n - 1][n - 2] == s[0][1]) {
        cout << "2" << endl;
        cout << "1 2" << endl;
        cout << "2 1" << endl;
      } else {
        cout << "0" << endl;
      }
    } else {
      cout << "1" << endl;
      if (s[n - 1][n - 2] == s[0][1])
        cout << n << " " << n - 1 << endl;
      else
        cout << n - 1 << " " << n << endl;
    }
  } else {
    if (s[n - 1][n - 2] == s[n - 2][n - 1]) {
      cout << "1" << endl;
      if (s[0][1] == s[n - 1][n - 2])
        cout << "1 2" << endl;
      else
        cout << "2 1" << endl;
    } else {
      cout << "2" << endl;
      if (s[0][1] == '0')
        cout << "1 2" << endl;
      else
        cout << "2 1" << endl;
      if (s[n - 1][n - 2] == '1')
        cout << n << " " << n - 1 << endl;
      else
        cout << n - 1 << " " << n << endl;
    }
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
}
