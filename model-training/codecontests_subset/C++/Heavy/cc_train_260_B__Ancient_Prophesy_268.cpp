#include <bits/stdc++.h>
using namespace std;
long long G(long long a, long long b) {
  if (b == 0) return a;
  return G(b, a % b);
}
map<string, int> m;
map<string, bool> mark;
vector<string> v;
vector<pair<int, string> > q;
int day[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int main() {
  ios_base::sync_with_stdio(false);
  string s;
  cin >> s;
  for (int i = 0; i < s.length() - 9; i++) {
    string ss = s.substr(i, 10);
    if (!mark[ss]) v.push_back(ss);
    mark[ss] = 1;
    m[ss]++;
  }
  for (int i = 0; i < v.size(); i++) q.push_back(make_pair(m[v[i]], v[i]));
  sort(q.begin(), q.end());
  reverse(q.begin(), q.end());
  for (int i = 0; i < q.size(); i++) {
    string s = q[i].second;
    if (s[2] != '-' || s[5] != '-') continue;
    s[2] = s[5] = '0';
    bool b = 0;
    for (int j = 0; j < s.length(); j++)
      if (s[j] == '-') b = 1;
    if (b) continue;
    s[2] = s[5] = '-';
    int da, mo, ye;
    da = 10 * s[0] + s[1] - 11 * '0';
    mo = 10 * s[3] + s[4] - 11 * '0';
    ye = 1000 * s[6] + 100 * s[7] + 10 * s[8] + s[9] - 1111 * '0';
    if (ye < 2013 || ye > 2015) continue;
    if (mo < 1 || mo > 12) continue;
    if (da < 1 || da > day[mo]) continue;
    cout << s << endl;
    break;
  }
}
