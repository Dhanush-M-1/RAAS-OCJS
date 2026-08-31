#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  string s;
  getline(cin >> ws, s);
  vector<string> a;
  string b = "";
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == '-') {
      a.push_back(b);
      b = "";
    } else {
      b += s[i];
    }
  }
  a.push_back(b);
  map<string, int> cnt;
  int condition;
  if (a.size() > 2) {
    condition = a.size();
  } else if (a.size() == 2) {
    condition = 3;
  }
  for (int i = 2; i < condition; i++) {
    if (a[i].size() >= 4) {
      string year = "";
      year += a[i][0];
      year += a[i][1];
      year += a[i][2];
      year += a[i][3];
      if (stoi(year) >= 2013 && stoi(year) <= 2015) {
        if (a[i - 1].size() == 2) {
          string month = "";
          month = a[i - 1];
          if (stoi(month) >= 1 && stoi(month) <= 12) {
            if (a[i - 2].size() >= 2) {
              string day = "";
              day += a[i - 2][a[i - 2].size() - 2];
              day += a[i - 2][a[i - 2].size() - 1];
              if (stoi(month) <= 7) {
                if (stoi(month) % 2) {
                  if (stoi(day) <= 31 && stoi(day) > 0) {
                    string ans = "";
                    ans += day + '-' + month + '-' + year;
                    cnt[ans]++;
                  } else {
                    continue;
                  }
                } else {
                  if (stoi(month) == 2) {
                    if (stoi(day) <= 28 && stoi(day) > 0) {
                      string ans = "";
                      ans += day + '-' + month + '-' + year;
                      cnt[ans]++;
                    } else {
                      continue;
                    }
                  } else {
                    if (stoi(day) <= 30 && stoi(day) > 0) {
                      string ans = "";
                      ans += day + '-' + month + '-' + year;
                      cnt[ans]++;
                    } else {
                      continue;
                    }
                  }
                }
              } else {
                if (stoi(month) % 2) {
                  if (stoi(day) <= 30 && stoi(day) > 0) {
                    string ans = "";
                    ans += day + '-' + month + '-' + year;
                    cnt[ans]++;
                  } else {
                    continue;
                  }
                } else {
                  if (stoi(day) <= 31 && stoi(day) > 0) {
                    string ans = "";
                    ans += day + '-' + month + '-' + year;
                    cnt[ans]++;
                  } else {
                    continue;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  int ans = 0;
  string an;
  for (auto it = cnt.begin(); it != cnt.end(); it++) {
    if (it->second > ans) {
      ans = it->second;
      an = it->first;
    }
  }
  cout << an << "\n";
}
