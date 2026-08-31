#include <bits/stdc++.h>
using namespace std;
vector<int> giho, p, m;
int main() {
  int n, i, j;
  string s;
  getline(cin, s);
  int prev = 1, pos = 0;
  for (i = 0; i < s.size(); ++i) {
    if (s[i] == '=') break;
    if (s[i] == ' ') continue;
    if (s[i] == '?') {
      if (prev) {
        p.push_back(pos++);
      } else
        m.push_back(pos++);
    }
    if (s[i] == '+' || s[i] == '-') {
      if (s[i] == '+')
        prev = 1, giho.push_back(1);
      else
        prev = 0, giho.push_back(0);
    }
  }
  i += 2;
  n = 0;
  for (; i < s.size(); ++i) n = n * 10 + s[i] - '0';
  int x, y, u = p.size(), v = m.size();
  x = u * n - v;
  y = u - v * n;
  if (y <= n && n <= x) {
    cout << "Possible\n";
    int ret[150];
    int k = 1e9, z;
    for (i = v; i <= n * v; ++i) {
      if (n + i >= u) {
        k = n + i, z = i;
        break;
      }
    }
    assert(k <= n * u);
    int rem, g;
    for (i = 0; i < u; ++i) {
      rem = u - i - 1;
      g = min(k - rem, n);
      k -= g;
      ret[p[i]] = g;
    }
    for (i = 0; i < v; ++i) {
      rem = v - i - 1;
      g = min(z - rem, n);
      z -= g;
      ret[m[i]] = g;
    }
    pos = 0;
    for (i = 0; i < u + v; ++i) {
      cout << ret[i];
      if (pos < giho.size()) {
        if (giho[pos++])
          cout << " + ";
        else
          cout << " - ";
      }
    }
    cout << " = " << n << endl;
  } else {
    cout << "Impossible\n";
  }
}
