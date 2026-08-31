#include <bits/stdc++.h>
using namespace std;
const int mod = int(1e9 + 7);
const double PI = acos(-1.0);
int m[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int func(string second) {
  int i, sum = 0;
  for (i = 0; i < second.length(); i++) sum = sum * 10 + (int)second[i] - 48;
  return sum;
}
int ms, k, kk, g, i;
map<string, int> mm;
pair<int, string> a[100000];
vector<string> v;
int main() {
  string second, t;
  getline(cin, second);
  t = "";
  i = 0;
  while (i < second.length()) {
    if (second[i] == '-') {
      v.push_back(t);
      t = "";
    } else
      t += second[i];
    i++;
  }
  if (t != "") v.push_back(t);
  for (i = 0; i < v.size() - 2; i++) {
    if ((v[i].length() > 1) && (v[i + 1].length() == 2) &&
        (v[i + 2].length() > 3)) {
      t = v[i].substr(v[i].length() - 2);
      k = func(t);
      t += "-" + v[i + 1] + "-";
      kk = func(v[i + 1]);
      if ((kk < 13) && (kk > 0) && (k > 0) && (k <= m[kk])) {
        second = v[i + 2].substr(0, 4);
        t += second;
        g = func(second);
        if ((g > 2012) && (g < 2016)) {
          if (mm[t] == 0) {
            mm[t] = ++ms;
            a[ms].second = t;
          }
          a[mm[t]].first++;
        }
      }
    }
  }
  g = 1;
  for (i = 2; i <= ms; i++)
    if (a[i].first > a[g].first) g = i;
  cout << a[g].second;
  return 0;
}
