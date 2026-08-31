#include <bits/stdc++.h>
using namespace std;
string tob(string s) {
  string t;
  for (int i = 0; i < s.size(); i++) {
    switch (s[i]) {
      case '0':
        t += "0000";
        break;
      case '1':
        t += "0001";
        break;
      case '2':
        t += "0010";
        break;
      case '3':
        t += "0011";
        break;
      case '4':
        t += "0100";
        break;
      case '5':
        t += "0101";
        break;
      case '6':
        t += "0110";
        break;
      case '7':
        t += "0111";
        break;
      case '8':
        t += "1000";
        break;
      case '9':
        t += "1001";
        break;
      case 'A':
        t += "1010";
        break;
      case 'B':
        t += "1011";
        break;
      case 'C':
        t += "1100";
        break;
      case 'D':
        t += "1101";
        break;
      case 'E':
        t += "1110";
        break;
      case 'F':
        t += "1111";
        break;
      case 'a':
        t += "1010";
        break;
      case 'b':
        t += "1011";
        break;
      case 'c':
        t += "1100";
        break;
      case 'd':
        t += "1101";
        break;
      case 'e':
        t += "1110";
        break;
      case 'f':
        t += "1111";
        break;
      default:
        t += '.';
    }
  }
  return t;
}
int main() {
  int n;
  scanf("%d", &n);
  string arr[n];
  for (int i = 0; i < n; i++) {
    char ss[700000];
    scanf("%s", ss);
    arr[i] = tob(ss);
  }
  vector<int> v;
  for (int i = 1; i * i <= n; i++) {
    if (n % i == 0) {
      if (n / i == i) {
        v.push_back(i);
      } else {
        v.push_back(i);
        v.push_back(n / i);
      }
    }
  }
  int mx = 1;
  for (int m : v) {
    for (int i = 0; i < n; i += m) {
      for (int j = 0; j < n; j += m) {
        int o = arr[i][j];
        for (int ii = i; ii < i + m; ii++) {
          for (int jj = j; jj < j + m; jj++) {
            if (arr[ii][jj] != o) {
              goto go;
            }
          }
        }
      }
    }
    mx = max(mx, m);
  go:;
  }
  printf("%d", mx);
  return 0;
}
