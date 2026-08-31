#include <bits/stdc++.h>
using namespace std;
string hex_char(char c) {
  switch (toupper(c)) {
    case '0':
      return "0000";
    case '1':
      return "0001";
    case '2':
      return "0010";
    case '3':
      return "0011";
    case '4':
      return "0100";
    case '5':
      return "0101";
    case '6':
      return "0110";
    case '7':
      return "0111";
    case '8':
      return "1000";
    case '9':
      return "1001";
    case 'A':
      return "1010";
    case 'B':
      return "1011";
    case 'C':
      return "1100";
    case 'D':
      return "1101";
    case 'E':
      return "1110";
    case 'F':
      return "1111";
  }
  return "";
}
int check(int x, int n, vector<string> &s) {
  for (int i = 0; i < n / x; ++i) {
    for (int j = 0; j < n / x; ++j) {
      char c = s[i * x][j * x];
      for (int k = 0; k < x; ++k) {
        for (int l = 0; l < x; ++l) {
          int a = i * x + k;
          int b = j * x + l;
          if (c != s[a][b]) return 0;
        }
      }
    }
  }
  return 1;
}
int main() {
  long long unsigned n;
  cin >> n;
  vector<string> input;
  for (int i = 0; i < n; ++i) {
    string s;
    cin >> s;
    string t;
    for (int i = 0; i < s.size(); ++i) {
      t += hex_char(s[i]);
    }
    input.push_back(t);
  }
  for (int i = n; i > 1; --i) {
    if (n % i == 0) {
      int f = check(i, n, input);
      if (f == 1) {
        cout << i << endl;
        return 0;
      }
    }
  }
  cout << 1 << endl;
  return 0;
}
