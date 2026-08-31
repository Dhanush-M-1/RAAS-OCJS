#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  a %= b;
  return gcd(b, a);
}
string conv(string k) {
  string s, fn = "";
  for (auto c : k) {
    switch (c) {
      case '0':
        s = "0000";
        break;
      case '1':
        s = "0001";
        break;
      case '2':
        s = "0010";
        break;
      case '3':
        s = "0011";
        break;
      case '4':
        s = "0100";
        break;
      case '5':
        s = "0101";
        break;
      case '6':
        s = "0110";
        break;
      case '7':
        s = "0111";
        break;
      case '8':
        s = "1000";
        break;
      case '9':
        s = "1001";
        break;
      case 'A':
        s = "1010";
        break;
      case 'B':
        s = "1011";
        break;
      case 'C':
        s = "1100";
        break;
      case 'D':
        s = "1101";
        break;
      case 'E':
        s = "1110";
        break;
      case 'F':
        s = "1111";
        break;
    }
    fn += s;
  }
  return fn;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  vector<string> s;
  for (unsigned long long i = 0; i < n; i++) {
    string kk;
    cin >> kk;
    kk = conv(kk);
    s.push_back(kk);
  }
  long long gr = 0;
  for (int i = 0; i < n; i++) {
    int cnt = 1;
    for (int j = 1; j < n; j++) {
      if (s[i][j] == s[i][j - 1])
        cnt++;
      else {
        gr = gcd(gr, cnt);
        cnt = 1;
      }
    }
    gr = gcd(gr, cnt);
  }
  for (int i = 0; i < n; i++) {
    int cnt = 1;
    for (int j = 1; j < n; j++) {
      if (s[j][i] == s[j - 1][i])
        cnt++;
      else {
        gr = gcd(gr, cnt);
        cnt = 1;
      }
    }
    gr = gcd(gr, cnt);
  }
  cout << gr << endl;
  return 0;
}
