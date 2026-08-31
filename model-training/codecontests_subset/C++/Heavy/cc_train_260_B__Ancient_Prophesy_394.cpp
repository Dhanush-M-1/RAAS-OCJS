#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1000000000 + 7;
const long long int N = 10000000 + 6;
int cal[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
bool check(int d, int m) {
  if (m <= 12 && m > 0) {
    if (d >= 1 && d <= cal[m]) return true;
  }
  return false;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  string st;
  cin >> st;
  int n = st.size();
  unordered_map<string, int> hmap;
  for (int i = 0, j = 9; j < n; i++, j++) {
    string sub = st.substr(i, 10);
    if (sub[2] == '-' && sub[5] == '-') {
      if (sub[6] == '2' && sub[7] == '0' && sub[8] == '1' &&
          (sub[9] - '3' >= 0 && sub[9] - '3' <= 2)) {
        if (isdigit(sub[0]) && isdigit(sub[1]) && isdigit(sub[3]) &&
            isdigit(sub[4])) {
          string mo = "";
          string da = "";
          mo = mo + sub[3] + sub[4];
          da = da + sub[0] + sub[1];
          int month = stoi(mo);
          int day = stoi(da);
          bool b = check(day, month);
          if (b == true) hmap[sub]++;
        }
      }
    }
  }
  string ans;
  int ma = -1;
  for (auto it = hmap.begin(); it != hmap.end(); it++) {
    if (it->second > ma) {
      ans = it->first;
      ma = it->second;
    }
  }
  cout << ans;
  return 0;
}
