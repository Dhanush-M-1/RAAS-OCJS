#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
string to_bin(char c) {
  switch (c) {
    case '0':
      return "0000";
      break;
    case '1':
      return "0001";
      break;
    case '2':
      return "0010";
      break;
    case '3':
      return "0011";
      break;
    case '4':
      return "0100";
      break;
    case '5':
      return "0101";
      break;
    case '6':
      return "0110";
      break;
    case '7':
      return "0111";
      break;
    case '8':
      return "1000";
      break;
    case '9':
      return "1001";
      break;
    case 'A':
      return "1010";
      break;
    case 'B':
      return "1011";
      break;
    case 'C':
      return "1100";
      break;
    case 'D':
      return "1101";
      break;
    case 'E':
      return "1110";
      break;
    case 'F':
      return "1111";
      break;
    case 'a':
      return "1010";
      break;
    case 'b':
      return "1011";
      break;
    case 'c':
      return "1100";
      break;
    case 'd':
      return "1101";
      break;
    case 'e':
      return "1110";
      break;
    case 'f':
      return "1111";
      break;
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  char c;
  string s, t;
  cin >> n;
  vector<string> v;
  bool bad = false, bd = false;
  for (int i = 0; i < n; i++) {
    s = "";
    for (int j = 0; j < n / 4; j++) {
      cin >> c;
      if (j == 0) {
        if (c != '0' && c != 'F') bd = true;
      }
      if (c != '0' && c != 'F') bad = true;
      s += to_bin(c);
    }
    v.push_back(s);
  }
  vector<int> del;
  for (int i = 1; i * i <= n; i++) {
    if (n % i == 0) {
      del.push_back(i);
      if (i * i < n) del.push_back(n / i);
    }
  }
  sort(del.begin(), del.end());
  reverse(del.begin(), del.end());
  for (int d : del) {
    if (d == 1) {
      cout << 1;
      return 0;
    }
    if ((d % 4 == 0) && bad) continue;
    if (d >= 4 && bd) continue;
    int ii = 0;
    int jj = 0;
    bool f = true;
    while (f && ii < n - 1) {
      char b = v[ii][jj];
      for (int i = ii; i < ii + d; i++) {
        for (int j = jj; j < jj + d; j++) {
          if (v[i][j] != b) {
            f = false;
            break;
          }
        }
      }
      jj += d;
      if (jj == n) {
        ii += d;
        jj = 0;
      }
    }
    if (f) {
      cout << d;
      return 0;
    }
  }
}
