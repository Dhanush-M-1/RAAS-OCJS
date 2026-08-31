#include <bits/stdc++.h>
using namespace std;
string a, b;
unordered_map<string, int> mm;
int day[15] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
bool check(string a) {
  for (int i = 0; i < a.size(); i++) {
    if (i == 2 || i == 5) {
      if (a[i] != '-') {
        return false;
      }
    } else {
      if (a[i] == '-') {
        return false;
      }
    }
  }
  int nn = 10 * (a[3] - '0') + a[4] - '0';
  if (day[nn] < 10 * (a[0] - '0') + a[1] - '0' ||
      10 * (a[0] - '0') + a[1] - '0' == 0 || nn == 0) {
    return false;
  }
  nn =
      1000 * (a[6] - '0') + 100 * (a[7] - '0') + 10 * (a[8] - '0') + a[9] - '0';
  if (nn < 2013 || nn > 2015) {
    return false;
  }
  return true;
}
string ans;
int cc = 0;
int main() {
  cin >> a;
  for (int i = 0; i <= a.size() - 10; i++) {
    b = a.substr(i, 10);
    if (check(b)) {
      mm[b]++;
      if (mm[b] > cc) {
        cc = mm[b];
        ans = b;
      }
    }
    b.clear();
  }
  cout << ans;
  return 0;
}
