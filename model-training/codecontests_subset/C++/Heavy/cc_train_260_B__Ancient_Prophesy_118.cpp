#include <bits/stdc++.h>
using namespace std;
const int maxn = 1005;
const double eps = 1e-9;
const int mod = 1000007;
const int inf = 0x7fffffff;
const int maxlog = 33;
template <class Int>
inline int size(const Int &a) {
  return (int)a.size();
}
map<string, int> mapp;
const int MONTH_DAYS[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
inline bool valid(string x) {
  for (__typeof(size(x)) i = 0; i < (size(x)); i++)
    if (x[i] == '-') x[i] = ' ';
  int cnt = count(x.begin(), x.end(), ' ');
  if (cnt > 2) return false;
  int d, m, y;
  istringstream buff;
  buff.clear();
  buff.str(x);
  buff >> d >> m >> y;
  if (m < 1 || m > 12 || d < 1 || d > MONTH_DAYS[m] || y < 2013 || y > 2015)
    return false;
  if (x[1] == ' ') return false;
  if (x[4] == ' ') return false;
  return true;
}
int main() {
  string line;
  int maxi = 0;
  getline(cin, line);
  for (__typeof(size(line) - 9) i = 0; i < (size(line) - 9); i++) {
    string temp = line.substr(i, 10);
    if (valid(temp)) {
      mapp[temp]++;
      maxi = max(mapp[temp], maxi);
    }
  }
  if (valid(line)) {
    mapp[line]++;
    maxi = max(maxi, mapp[line]);
  }
  for (__typeof((mapp).begin()) i = (mapp).begin(); i != (mapp).end(); i++) {
    if (maxi == i->second) {
      cout << i->first << endl;
      return 0;
    }
  }
}
