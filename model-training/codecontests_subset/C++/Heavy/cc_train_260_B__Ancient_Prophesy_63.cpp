#include <bits/stdc++.h>
using namespace std;
const int inf = (int)1e9;
const double EPS = 1e-9, INF = 1e12;
string in;
int day(int y, int m) {
  int d[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  return d[m] + (y % 4 == 0);
}
int main() {
  cin >> in;
  map<string, int> cnt;
  for (int i = 0; i < (int)in.size() - 9; i++) {
    if (isdigit(in[i]) && isdigit(in[i + 1]) && isdigit(in[i + 3]) &&
        isdigit(in[i + 4]) && isdigit(in[i + 6]) && isdigit(in[i + 7]) &&
        isdigit(in[i + 8]) && isdigit(in[i + 9]) && in[i + 2] == '-' &&
        in[i + 5] == '-') {
      int y = atoi(in.substr(i + 6, 4).c_str());
      int m = atoi(in.substr(i + 3, 2).c_str());
      int d = atoi(in.substr(i, 2).c_str());
      if (2013 <= y && y <= 2015 && 1 <= m && m <= 12 && 1 <= d &&
          d <= day(y, m))
        cnt[in.substr(i, 10)]++;
    }
  }
  int mx = 0;
  for (__typeof(cnt.begin()) i = cnt.begin(); i != cnt.end(); i++)
    mx = max(mx, i->second);
  for (__typeof(cnt.begin()) i = cnt.begin(); i != cnt.end(); i++)
    if (i->second == mx) cout << i->first << endl;
  return 0;
}
