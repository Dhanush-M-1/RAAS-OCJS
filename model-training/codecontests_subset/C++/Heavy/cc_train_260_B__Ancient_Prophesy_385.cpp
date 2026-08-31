#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cout << name << " : " << arg1 << std::endl;
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cout.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
long long int Months[13] = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
map<string, long long int> checking;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  string s;
  cin >> s;
  bool ffllg = 0;
  for (long long int i = 0; i <= s.length() - 10; i++) {
    long long int cnt = 1;
    bool datecheck = 1, check = 1, monthchck = 1, yearcheck = 1;
    string ss = "";
    long long int end = i + 10;
    for (long long int j = i; j < end; j++) {
      if (cnt <= 2) {
        if (s[j] == '-') {
          datecheck = 0;
          continue;
        }
        long long int digit = s[j] - '0';
        if (cnt == 1 && ((digit > 3))) {
          datecheck = 0;
        }
      }
      if (cnt == 3) {
        if (s[j] != '-') check = 0;
      }
      if (cnt > 3 && cnt < 6) {
        if (s[j] == '-') {
          monthchck = 0;
          continue;
        }
        long long int digit = s[j] - '0';
        if (cnt == 4) {
          if (digit > 1) monthchck = 0;
        }
      }
      if (cnt == 6) {
        if (s[j] != '-') check = 0;
      }
      if (cnt == 7) {
        if (s[j] == '-') {
          yearcheck = 0;
          continue;
        }
        if (s[j] != '2') yearcheck = 0;
      }
      if (cnt == 8) {
        if (s[j] == '-') {
          yearcheck = 0;
          continue;
        }
        if (s[j] != '0') yearcheck = 0;
      }
      if (cnt == 9) {
        if (s[j] == '-') {
          yearcheck = 0;
          continue;
        }
        if (s[j] != '1') yearcheck = 0;
      }
      if (cnt == 10) {
        if (s[j] == '-') {
          yearcheck = 0;
          continue;
        }
        long long int digit = s[j] - '0';
        if (digit < 3 || digit > 5) yearcheck = 0;
      }
      cnt++;
      ss += s[j];
    }
    if (ss[0] == '0' && ss[1] == '0') datecheck = 0;
    if (ss[3] == '0' && ss[4] == '0') monthchck = 0;
    if (yearcheck && monthchck && datecheck && check) {
      long long int date = (ss[0] - '0') * 10 + (ss[1] - '0');
      long long int month = (ss[3] - '0') * 10 + (ss[4] - '0');
      if (Months[month] >= date) {
        checking[ss]++;
        ffllg = 1;
      }
    }
  }
  long long int maxi = INT_MIN;
  string ssss = "";
  for (auto it = checking.begin(); it != checking.end(); it++) {
    if (it->second > maxi) {
      maxi = it->second;
      ssss = it->first;
    }
  }
  cout << ssss << '\n';
  return 0;
}
