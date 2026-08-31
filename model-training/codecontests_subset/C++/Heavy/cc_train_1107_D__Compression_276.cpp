#include <bits/stdc++.h>
using namespace std;
long long a[5205][5205], n;
vector<int> v[16];
int fun(char c) {
  if (isdigit(c)) return c - '0';
  return 10 + c - 'A';
}
void fun2() {
  for (int x = 0; x < 16; x++) {
    int y = x;
    while (v[x].size() < 4) {
      v[x].push_back(y % 2);
      y /= 2;
    }
    reverse(v[x].begin(), v[x].end());
  }
}
bool check(long long k) {
  for (int x = 1; x <= n; x += k) {
    for (int y = 1; y <= n; y += k) {
      long long s = a[x + k - 1][y + k - 1] - a[x - 1][y + k - 1] -
                    a[x + k - 1][y - 1] + a[x - 1][y - 1];
      if (s != 0 && s != k * k) {
        return 0;
      }
    }
  }
  return 1;
}
void fun3() {
  for (int x = 1; x <= n; x++) {
    for (int y = 1; y <= n; y++) {
      a[x][y] += a[x][y - 1];
    }
  }
  for (int x = 1; x <= n; x++) {
    for (int y = 1; y <= n; y++) {
      a[x][y] += a[x - 1][y];
    }
  }
}
int main() {
  cin >> n;
  string s;
  fun2();
  for (int x = 0; x < n; x++) {
    cin >> s;
    for (int y = 0; y < n / 4; y++) {
      int z = fun(s[y]);
      for (int t = 0; t < 4; t++) {
        a[x + 1][(4 * y) + t + 1] = v[z][t];
      }
    }
  }
  fun3();
  vector<int> d;
  for (int x = 1; x <= (long long)sqrt(n); x++) {
    if (n % x) continue;
    d.push_back(x);
    if (x != n / x) {
      d.push_back(n / x);
    }
  }
  sort((d).begin(), (d).end());
  reverse((d).begin(), (d).end());
  for (auto x : d) {
    if (check(x)) {
      cout << x << " ";
      return 0;
    }
  }
  return 0;
}
