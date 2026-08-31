#include <bits/stdc++.h>
using namespace std;
double pi = 3.1415926536;
const int oo = (int)1e9;
const long long OO = numeric_limits<long long>::max();
int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};
int di[] = {0, 0, 1, -1, 1, -1, 1, -1};
int dj[] = {1, -1, 0, 0, 1, -1, -1, 1};
int f1[] = {0, 0, 0, 1, 1, 1, -1, -1, -1};
int f2[] = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
int days[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
string toString(int x) {
  stringstream ss;
  string s;
  ss << x;
  ss >> s;
  return s;
}
int main() {
  ios_base::sync_with_stdio(false);
  map<string, int> mymap;
  vector<string> myDates;
  for (int i = 2013; i <= 2015; i++) {
    for (int j = 1; j <= 12; j++) {
      for (int k = 1; k <= days[j]; k++) {
        stringstream ss;
        string year, month, day;
        day = toString(k);
        if (((int)(day).size()) == 1) day = "0" + day;
        month = toString(j);
        if (((int)(month).size()) == 1) month = "0" + month;
        year = toString(i);
        string date = day + month + year;
        myDates.push_back(date);
      }
    }
  }
  string s;
  cin >> s;
  for (int i = 0; i < ((int)(s).size()); i++) {
    string str = s.substr(i, 10);
    int cnt = 0;
    string date;
    for (int j = 0; j < ((int)(str).size()); j++) {
      if (str[j] == '-')
        cnt++;
      else
        date += str[j];
    }
    if (cnt == 2) {
      mymap[date]++;
    }
  }
  int idx = -1, mx = -1;
  for (int i = 0; i < ((int)(myDates).size()); i++) {
    int take = mymap[myDates[i]];
    if (take >= mx) {
      idx = i;
      mx = take;
    }
  }
  string ans = myDates[idx];
  for (int i = 0; i < ((int)(ans).size()); i++) {
    cout << ans[i];
    if (i == 1) {
      cout << "-";
    }
    if (i == 3) {
      cout << "-";
    }
  }
}
