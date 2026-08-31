#include <bits/stdc++.h>
using namespace std;
long long int biexp(long long int a, long long int b) {
  long long int res = 1;
  while (b) {
    if (b % 2) res = res * a;
    a = a * a;
    b = b / 2;
  }
  return res;
}
int main() {
  int t = 1;
  while (t--) {
    string s;
    cin >> s;
    string r;
    long long int x = 0;
    string s2;
    map<string, long long int> v;
    for (long long int i = 0; i <= s.length() - 10; i++) {
      r = s.substr(i, 10);
      long long int d = (r[0] - '0') * 10 + (r[1] - '0');
      long long int m = (r[3] - '0') * 10 + (r[4] - '0');
      if (r[0] != '-' and r[1] != '-' and r[2] == '-' and r[3] != '-' and
          r[4] != '-' and r[5] == '-' and r[6] == '2' and r[7] == '0' and
          r[8] == '1' and (r[9] == '3' or r[9] == '4' or r[9] == '5')) {
        if (m >= 1 and m <= 12) {
          if (m == 2) {
            if (d >= 1 and d <= 28) v[r]++;
          } else if (((m <= 7 and m % 2 != 0) or (m >= 8 and m % 2 == 0)) and
                     d >= 1 and d <= 31)
            v[r]++;
          else if (d >= 1 and d <= 30)
            v[r]++;
        }
      }
    }
    for (auto it = v.begin(); it != v.end(); it++) {
      if (it->second > x) {
        x = it->second;
        s2 = it->first;
      }
    }
    cout << s2;
  }
  return 0;
}
