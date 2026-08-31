#include <bits/stdc++.h>
using namespace std;
const int maxn = 110;
int mark[maxn];
int idn = 1;
int m, t;
string q;
vector<pair<int, pair<int, int> > > vec;
int ja[maxn];
int main() {
  ios::sync_with_stdio(false);
  cin >> t >> m;
  for (int i = 0; i < t + 1; ++i) ja[i] = -1;
  for (int it = 0; it < t; ++it) {
    cin >> q;
    if (q == "erase") {
      int x;
      cin >> x;
      if (x >= idn || x < 1 || ja[x] == -1)
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      else {
        pair<int, pair<int, int> > v = vec[ja[x]];
        if (v.second.second != x) cerr << "ERROR" << endl;
        vec.erase(vec.begin() + ja[x]);
        for (int i = 0; i < (int)(vec).size(); ++i)
          ja[vec[i].second.second] = i;
        for (int i = v.first; i < v.second.first + v.first; ++i)
          mark[i] = false;
        ja[x] = -1;
      }
    }
    if (q == "alloc") {
      int n;
      bool bo = false;
      int now = 0;
      cin >> n;
      for (int i = 0; i < m - n + 1; ++i) {
        for (int j = 0; j < n; ++j) {
          if (mark[j + i]) break;
          if (j == n - 1) {
            bo = true;
            now = i;
          }
        }
        if (bo) break;
      }
      if (bo) {
        for (int i = now; i < now + n; ++i) mark[i] = true;
        vec.push_back(pair<int, pair<int, int> >(now, pair<int, int>(n, idn)));
        sort((vec).begin(), (vec).end());
        for (int i = 0; i < (int)(vec).size(); ++i)
          ja[vec[i].second.second] = i;
        cout << idn++ << endl;
      } else
        cout << "NULL" << endl;
    }
    if (q == "defragment") {
      for (int i = 0; i < m; ++i) mark[i] = false;
      int sum = 0;
      for (int i = 0; i < (int)(vec).size(); ++i) {
        vec[i].first = sum;
        sum += vec[i].second.first;
      }
      for (int i = 0; i < sum; ++i) mark[i] = true;
    }
  }
  return 0;
}
