#include <bits/stdc++.h>
using namespace std;
const long long int MOD = 1000000007;
long long int gcd(long long int a, long long int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
bool t[5200][5200];
string v[5200];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  string s[n];
  for (int i = int(0); i < int(n); i++) cin >> s[i];
  int res1 = n;
  int l = 0, r = 0;
  while (l < n) {
    while (r < n && s[l] == s[r]) {
      r++;
    }
    res1 = gcd(res1, r - l);
    l = r;
  }
  for (int i = int(0); i < int(n); i++) {
    for (int j = int(0); j < int(n / 4); j++) {
      char u = s[i][j];
      int X;
      if (u == 'A')
        X = 10;
      else if (u == 'B')
        X = 11;
      else if (u == 'C')
        X = 12;
      else if (u == 'D')
        X = 13;
      else if (u == 'E')
        X = 14;
      else if (u == 'F')
        X = 15;
      else
        X = u - '0';
      for (int k = int(0); k < int(4); k++) {
        if (X & (1 << (3 - k))) t[i][k + j * 4] = 1;
      }
    }
  }
  for (int i = int(0); i < int(n); i++) {
    int x = 0;
    int res = 0;
    while (x < n) {
      res = t[x][i] + (t[x + 1][i] << 1) + (t[x + 2][i] << 2) +
            (t[x + 3][i] << 3);
      v[i] += to_string(res);
      x += 4;
    }
  }
  int res2 = n;
  l = 0, r = 0;
  while (l < n) {
    while (r < n && v[l] == v[r]) {
      r++;
    }
    res2 = gcd(res2, r - l);
    l = r;
  }
  cout << gcd(res1, res2) << "\n";
}
