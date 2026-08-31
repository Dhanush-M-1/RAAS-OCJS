#include <bits/stdc++.h>
using namespace std;
string f(char c) {
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
}
string f1(string c) {
  if (c == "0000") return "0";
  if (c == "0001") return "1";
  if (c == "0010") return "2";
  if (c == "0011") return "3";
  if (c == "0100") return "4";
  if (c == "0101") return "5";
  if (c == "0110") return "6";
  if (c == "0111") return "7";
  if (c == "1000") return "8";
  if (c == "1001") return "9";
  if (c == "1010") return "A";
  if (c == "1011") return "B";
  if (c == "1100") return "C";
  if (c == "1101") return "D";
  if (c == "1110") return "E";
  if (c == "1111") return "F";
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long n;
  cin >> n;
  vector<string> v1(n);
  for (long long i = 0; i < n; i++) cin >> v1[i];
  vector<string> v2;
  for (long long i = 0; i < n / 4; i++) {
    vector<string> w;
    for (long long j = 0; j < n; j++) {
      w.push_back(f(v1[j][i]));
    }
    for (long long j = 0; j < 4; j++) {
      string val;
      for (long long k = 0; k < n; k += 4) {
        string tmp;
        for (long long a = k; a < k + 4; a++) tmp += w[a].substr(j, 1);
        val += f1(tmp);
      }
      v2.push_back(val);
    }
  }
  vector<long long> div;
  long long ans = 1;
  for (long long i = 1; i <= n; i++) {
    if (n % i == 0) {
      long long check1 = 0, check2 = 0;
      for (long long j = 0; j < n; j += i) {
        long long flag = 0;
        for (long long k = j + 1; k < j + i; k++) {
          if (v1[k] != v1[j]) {
            flag = 1;
            break;
          }
        }
        if (flag == 1) {
          check1 = 1;
          break;
        }
      }
      for (long long j = 0; j < n; j += i) {
        long long flag = 0;
        for (long long k = j + 1; k < j + i; k++) {
          if (v2[k] != v2[j]) {
            flag = 1;
            break;
          }
        }
        if (flag == 1) {
          check2 = 1;
          break;
        }
      }
      if (check1 == 0 && check2 == 0) {
        ans = i;
      }
    }
  }
  cout << ans;
}
