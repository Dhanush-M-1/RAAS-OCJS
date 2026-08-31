#include <bits/stdc++.h>
using namespace std;
map<char, string> m;
vector<string> matrix;
int gcd(int a, int b);
void solve() {
  m['0'] = "0000";
  m['1'] = "0001";
  m['2'] = "0010";
  m['3'] = "0011";
  m['4'] = "0100";
  m['5'] = "0101";
  m['6'] = "0110";
  m['7'] = "0111";
  m['8'] = "1000";
  m['9'] = "1001";
  m['A'] = "1010";
  m['B'] = "1011";
  m['C'] = "1100";
  m['D'] = "1101";
  m['E'] = "1110";
  m['F'] = "1111";
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    string s = "";
    for (int j = 0; j < n / 4; ++j) {
      char c;
      cin >> c;
      s += m[c];
    }
    matrix.push_back(s);
  }
  int x = n;
  for (int i = 0; i < n; ++i) {
    int k = 1, len = 1;
    while (k < n) {
      len = 1;
      while (k < n && matrix[i][k] == matrix[i][k - 1]) ++k, ++len;
      x = gcd(x, len);
      k = k + 1;
    }
  }
  for (int i = 0; i < n; ++i) {
    int k = 1, len = 1;
    while (k < n) {
      len = 1;
      while (k < n && matrix[k][i] == matrix[k - 1][i]) ++k, ++len;
      x = gcd(x, len);
      k = k + 1;
    }
  }
  cout << x << '\n';
}
int gcd(int a, int b) {
  while (b != 0) {
    a = a % b;
    swap(a, b);
  }
  return a;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
  return 0;
}
