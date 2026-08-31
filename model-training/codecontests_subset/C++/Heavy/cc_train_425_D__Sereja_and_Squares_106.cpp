#include <bits/stdc++.h>
using namespace std;
inline int in() {
  int32_t x;
  scanf("%d", &x);
  return x;
}
inline long long lin() {
  long long x;
  scanf("%lld", &x);
  return x;
}
inline string get() {
  char ch[2000010];
  scanf("%s", ch);
  return ch;
}
inline void read(int *a, int n) {
  for (int i = 0; i < n; i++) a[i] = in();
}
template <class blank>
inline void out(blank x) {
  cout << x << "\n";
  exit(0);
}
const int maxn = 1e5 + 10;
const int maxm = 1e6 + 10;
const int maxlg = 21;
const int base = 29;
const int mod = 1e9 + 7;
const long long INF = 1e18 + 10;
const int SQ = 317 + 5;
unordered_set<int> exist[maxn];
inline bool checkexist(int x, int y) {
  return x < maxn && x >= 0 && exist[x].count(y);
}
set<int> columns[maxn], rows[maxn];
long long res;
int32_t main() {
  int n = in();
  int sq = sqrt(n);
  for (int i = 0; i < n; i++) {
    int x = in(), y = in();
    rows[x].insert(y);
    columns[y].insert(x);
    exist[x].insert(y);
  }
  for (int i = 0; i < maxn; i++) {
    if (rows[i].size() < sq) {
      for (set<int>::iterator it = rows[i].begin(); it != rows[i].end(); it++) {
        for (set<int>::iterator it2 = rows[i].begin(); it2 != rows[i].end();
             it2++) {
          if (*it2 <= *it) continue;
          int len = *it2 - *it;
          pair<int, int> A = {i, *it}, B = {i, *it2}, C = {i + len, A.second},
                         D = {i + len, B.second};
          if (checkexist(C.first, C.second) && checkexist(D.first, D.second))
            res++;
          C = {i - len, A.second}, D = {i - len, B.second};
          if (checkexist(C.first, C.second) && checkexist(D.first, D.second))
            res++;
        }
      }
      for (set<int>::iterator it = rows[i].begin(); it != rows[i].end(); it++) {
        exist[i].erase(*it);
        columns[*it].erase(i);
      }
      rows[i].clear();
    }
  }
  for (int i = 0; i < maxn; i++) {
    if (columns[i].size() < sq) {
      for (set<int>::iterator it = columns[i].begin(); it != columns[i].end();
           it++) {
        for (set<int>::iterator it2 = columns[i].begin();
             it2 != columns[i].end(); it2++) {
          if (*it2 <= *it) continue;
          pair<int, int> A = {*it, i}, B = {*it2, i}, C = {*it, i + *it2 - *it},
                         D = {*it2, C.second};
          if (checkexist(C.first, C.second) && checkexist(D.first, D.second))
            res++;
          C = {*it, i - (*it2 - *it)}, D = {*it2, C.second};
          if (checkexist(C.first, C.second) && checkexist(D.first, D.second))
            res++;
        }
      }
      for (set<int>::iterator it = columns[i].begin(); it != columns[i].end();
           it++) {
        exist[*it].erase(i);
        rows[*it].erase(i);
      }
      columns[i].clear();
    }
  }
  for (int i = 0; i < maxn; i++) {
    for (set<int>::iterator it = rows[i].begin(); it != rows[i].end(); it++) {
      for (set<int>::iterator it2 = rows[i].begin(); it2 != rows[i].end();
           it2++) {
        if (*it2 <= *it) continue;
        int len = *it2 - *it;
        pair<int, int> A = {i, *it}, B = {i, *it2}, C = {i + len, A.second},
                       D = {i + len, B.second};
        if (checkexist(C.first, C.second) && checkexist(D.first, D.second))
          res++;
        C = {i - len, A.second}, D = {i - len, B.second};
        if (checkexist(C.first, C.second) && checkexist(D.first, D.second))
          res++;
      }
    }
    for (set<int>::iterator it = rows[i].begin(); it != rows[i].end(); it++) {
      exist[i].erase(*it);
      columns[*it].erase(i);
    }
  }
  cout << res << "\n";
}
