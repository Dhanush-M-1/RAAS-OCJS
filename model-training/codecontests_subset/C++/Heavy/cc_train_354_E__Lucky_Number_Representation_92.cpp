#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:60777216")
using namespace std;
string s;
vector<long long> r;
set<pair<int, int> > u;
bool good(int pos, int add) {
  if (u.count(pair<int, int>(pos, add))) return 0;
  u.insert(pair<int, int>(pos, add));
  if (pos == s.size()) {
    if (add) return 0;
    r.clear();
    for (int i = (0); i < (6); i++) r.push_back(0);
    return 1;
  }
  for (int z = (0); z < (7); z++)
    for (int f = (0); f < (7 - z); f++) {
      int ss = 6 - z - f;
      int xx = f * 4 + ss * 7 + add;
      if (xx % 10 == s[pos] - '0') {
        if (good(pos + 1, xx / 10)) {
          for (int i = (0); i < (z); i++) r[i] *= 10;
          for (int i = (z); i < (z + f); i++) r[i] = r[i] * 10 + 4;
          for (int i = (z + f); i < (6); i++) r[i] = r[i] * 10 + 7;
          return true;
        }
      }
    }
  return 0;
}
int main() {
  int tc;
  cin >> tc;
  for (int TC = (0); TC < (tc); TC++) {
    cin >> s;
    u.clear();
    reverse(s.begin(), s.end());
    if (good(0, 0)) {
      sort((r).begin(), (r).end());
      for (int i = (0); i < (r.size()); i++) {
        if (i) printf(" ");
        cout << r[i];
      }
      puts("");
    } else
      puts("-1");
  }
  return 0;
}
