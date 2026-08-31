#include <bits/stdc++.h>
using namespace std;
const long double EPS = 1E-9;
const int INF = (int)1E9;
const long long INF64 = (long long)1E18;
const long double PI = 2 * acos(.0);
int n, m;
vector<pair<int, int> > fr;
map<int, int> pos, len;
int getNew(int l, int id) {
  for (int i = 0; i < (int)(fr.size()); i++)
    if (fr[i].second >= l) {
      pos[id] = fr[i].first;
      len[id] = l;
      fr[i].second -= l;
      fr[i].first += l;
      if (fr[i].second == 0) fr.erase(fr.begin() + i);
      return 0;
    }
  return -1;
}
int main() {
  int cur = 0;
  cin >> n >> m;
  fr.push_back(make_pair(0, m));
  for (int i = 0; i < (int)(n); i++) {
    string c;
    int x;
    cin >> c;
    if (c == "alloc") {
      cin >> x;
      int ans = getNew(x, cur);
      if (ans != -1) cur++;
      if (ans != -1)
        printf("%d\n", cur);
      else
        printf("NULL\n");
    }
    if (c == "defragment") {
      int f = 0;
      for (int i = 0; i < (int)(fr.size()); i++) f += fr[i].second;
      fr.clear();
      fr.push_back(make_pair(m - f, f));
      vector<pair<int, int> > t(pos.begin(), pos.end());
      for (int i = 0; i < (int)(t.size()); i++) swap(t[i].second, t[i].first);
      int c = 0;
      sort(t.begin(), t.end());
      for (int i = 0; i < (int)(t.size()); i++) {
        pos[t[i].second] = c;
        c += len[t[i].second];
      }
    }
    if (c == "erase") {
      cin >> x;
      x--;
      if (!pos.count(x)) {
        printf("ILLEGAL_ERASE_ARGUMENT\n");
        continue;
      }
      fr.push_back(make_pair(pos[x], len[x]));
      sort(fr.begin(), fr.end());
      for (int i = 0; i < (int)fr.size() - 1; i++)
        if (fr[i + 1].first == fr[i].first + fr[i].second) {
          fr[i].second += fr[i + 1].second;
          fr.erase(fr.begin() + i + 1);
          i--;
        }
      pos.erase(x);
      len.erase(x);
    }
    cur = cur;
  }
  return 0;
}
