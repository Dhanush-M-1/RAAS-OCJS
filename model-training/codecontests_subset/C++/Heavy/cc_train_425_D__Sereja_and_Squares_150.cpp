#include <bits/stdc++.h>
using namespace std;
const unsigned MAXN = (1 << 20);
void Read(unsigned &x);
unsigned n;
unsigned x[MAXN], y[MAXN];
void read() {
  Read(n);
  for (unsigned i = 0; i < n; i++) {
    Read(x[i]);
    Read(y[i]);
  }
}
set<unsigned> l[MAXN], r[MAXN];
vector<unsigned> row[MAXN], col[MAXN];
unordered_map<unsigned, bool> has[MAXN];
void solve() {
  for (unsigned i = 0; i < n; i++) {
    l[x[i]].insert(y[i]);
    r[y[i]].insert(x[i]);
    has[x[i]][y[i]] = true;
  }
  for (unsigned i = 0; i <= 1000000; i++)
    for (auto it : l[i]) row[i].push_back(it);
  for (unsigned j = 0; j <= 1000000; j++)
    for (auto it : r[j]) col[j].push_back(it);
  unsigned ans = 0, len = 0;
  for (unsigned i = 0; i < n; i++) {
    auto byx = upper_bound(row[x[i]].begin(), row[x[i]].end(), y[i]);
    auto byy = upper_bound(col[y[i]].begin(), col[y[i]].end(), x[i]);
    if (distance(byx, row[x[i]].end()) > distance(byy, col[y[i]].end())) {
      for (; byy != col[y[i]].end(); ++byy) {
        len = *byy - x[i];
        ans += (has[*byy].count(y[i] + len) && has[x[i]].count(y[i] + len));
      }
    } else {
      for (; byx != row[x[i]].end(); ++byx) {
        len = *byx - y[i];
        ans += (has[x[i] + len].count(*byx) && has[x[i] + len].count(y[i]));
      }
    }
  }
  cout << ans << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  read();
  solve();
  return 0;
}
char sir[800000];
unsigned pos_ind = 0;
void Next() {
  if (++pos_ind == 800000) fread(sir, 1, 800000, stdin), pos_ind = 0;
}
void Read(unsigned &x) {
  for (; sir[pos_ind] < '0' || sir[pos_ind] > '9'; Next())
    ;
  for (x = 0; sir[pos_ind] >= '0' && sir[pos_ind] <= '9'; Next())
    x = x * 10 + sir[pos_ind] - '0';
}
