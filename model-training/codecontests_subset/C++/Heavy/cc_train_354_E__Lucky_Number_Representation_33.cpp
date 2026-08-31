#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:16777216")
using namespace std;
const long double pi = 3.14159265358979323846;
const long long int inf = (long long int)1ll << 50;
const int ss = (int)1e6 + 3;
const long long int base = inf;
bool pred(const pair<int, int>& i, const pair<int, int>& j) {
  if (i.first == j.first) {
    return i.second > j.second;
  } else {
    return i.first > j.first;
  }
}
bool pred1(const string& i, const string& j) { return i.size() > j.size(); }
vector<pair<int, int> > check(int number, int plus) {
  vector<pair<int, int> > res;
  for (int i = 0; i <= 6; ++i) {
    for (int j = 0; j <= 6 - i; ++j) {
      int z = i * 4 + j * 7;
      z += plus;
      if (z % 10 == number) {
        res.push_back(make_pair(i, j));
      }
    }
  }
  return res;
}
int main() {
  int t;
  cin >> t;
  for (int tt = 0; tt < t; ++tt) {
    string s;
    cin >> s;
    vector<vector<bool> > dp(25, vector<bool>(5));
    vector<vector<int> > p(25, vector<int>(5, -1));
    vector<vector<pair<int, int> > > ans(25, vector<pair<int, int> >(5));
    dp[0][0] = true;
    for (int i = s.size() - 1, k = 1; i >= 0; --i, ++k) {
      int now = s[i] - '0';
      for (int j = 0; j < 5; ++j) {
        if (dp[k - 1][j]) {
          vector<pair<int, int> > res = check(now, j);
          for (int j1 = 0; j1 < res.size(); ++j1) {
            int z = res[j1].first * 4 + res[j1].second * 7 + j;
            dp[k][z / 10] = true;
            p[k][z / 10] = j;
            ans[k][z / 10] = res[j1];
          }
        }
      }
    }
    if (dp[s.size()][0] == false) {
      cout << "-1\n";
      continue;
    }
    vector<string> out(6);
    for (int i = 0, k = s.size(); p[k][i] != -1; i = p[k][i], --k) {
      int x = ans[k][i].first;
      int y = ans[k][i].second;
      for (int j = 0; j < x; ++j) {
        out[j] += "4";
      }
      for (int j = x; j < x + y; ++j) {
        out[j] += "7";
      }
      for (int j = x + y; j < 6; ++j) {
        out[j] += "0";
      }
    }
    for (int i = 0; i < 6; ++i) {
      long long int now = 0;
      long long int st = 1;
      for (int j = out[i].size() - 1; j >= 0; --j) {
        now += st * (out[i][j] - '0');
        st *= 10;
      }
      cout << now << " ";
    }
    cout << "\n";
  }
  return 0;
}
