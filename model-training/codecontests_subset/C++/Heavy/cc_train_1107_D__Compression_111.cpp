#include <bits/stdc++.h>
using namespace std;
const int MAXN = 5207;
string s[MAXN];
string g(int x) {
  string s;
  for (int i = 3; i >= 0; i--) {
    if (x & (1 << i))
      s += '1';
    else
      s += '0';
  }
  return s;
}
string f(char c) {
  if ('0' <= c && c <= '9') return g(c - '0');
  return g(c - 'A' + 10);
}
vector<int> dv;
string fine[MAXN];
int n;
bool isOk(int x) {
  int y = n / x;
  for (int p = 0; p < y; p++) {
    int k = p * x;
    for (int i = 0; i < x; i++) {
      if (fine[k + i].empty()) return false;
      if (fine[k + i] != fine[k]) return false;
    }
  }
  return true;
}
void pre(int x) {
  int y = n / x;
  for (int i = 0; i < n; i++) {
    bool ok = true;
    for (int p = 0; p < y; p++) {
      int k = p * x;
      for (int j = 0; j < x; j++) {
        if (s[i][k] != s[i][k + j]) {
          ok = false;
          break;
        }
      }
      if (ok)
        fine[i] += s[i][k];
      else {
        fine[i] = "";
        break;
      }
    }
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    if (n % i) continue;
    dv.push_back(i);
  }
  for (int i = 0; i < n; i++) {
    string t;
    cin >> t;
    for (char c : t) {
      s[i] += f(c);
    }
  }
  for (int x = n; x > 0; x--) {
    if (n % x) continue;
    pre(x);
    if (isOk(x)) {
      cout << x << endl;
      return 0;
    }
  }
  return 0;
}
