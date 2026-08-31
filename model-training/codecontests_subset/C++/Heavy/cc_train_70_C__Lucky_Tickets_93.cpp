#include <bits/stdc++.h>
using namespace std;
template <class T>
void check_max(T& a, T b) {
  if (a < b) a = b;
}
template <class T>
void check_min(T& a, T b) {
  if (a > b) a = b;
}
int r(int a) {
  int res = 0;
  for (int p = 0, mi = 1; mi <= a; mi *= 10, p++)
    res = res * 10 + (a / mi % 10);
  return res;
}
const int MAXN = 100000 + 1;
const int MAXMI = 16;
struct TYPE {
  int num;
  int mi[MAXMI][2];
};
bool operator<(TYPE a, TYPE b) {
  for (int _t = MAXMI, i = 0; i < _t; i++)
    for (int _t = 2, w = 0; w < _t; w++)
      if (a.mi[i][w] != b.mi[i][w]) return a.mi[i][w] < b.mi[i][w];
  return false;
}
TYPE rec[MAXN];
void add(map<int, int>& tmp, int v, int coef) {
  for (int i = 2; i * i <= v; i++) {
    if (v % i == 0) {
      while (v % i == 0) {
        tmp[i] += coef;
        v /= i;
      }
    }
  }
  if (v != 1) tmp[v] += coef;
}
vector<int> R[MAXN];
void init() {
  for (int _t = MAXN, i = 1; i < _t; i++) {
    map<int, int> tmp;
    add(tmp, i, 1);
    add(tmp, r(i), -1);
    memset(rec[i].mi, 0, sizeof(rec[i].mi));
    int c = 0;
    for (map<int, int>::iterator it = tmp.begin(); it != tmp.end(); it++)
      if (it->second != 0) {
        rec[i].mi[c][0] = it->first;
        rec[i].mi[c][1] = it->second;
        c++;
      }
    rec[i].num = i;
  }
  sort(rec + 1, rec + MAXN);
  for (int _t = MAXN, i = 0; i < _t; i++) R[i].clear();
  for (int _t = MAXN, p = 1; p < _t; p++) {
    TYPE rev = rec[p];
    for (int _t = MAXMI, x = 0; x < _t; x++) rev.mi[x][1] = -rev.mi[x][1];
    int i = 0, d = 1;
    while (d < MAXN) d *= 2;
    for (; d > 0; d /= 2)
      if (i + d < MAXN && rec[i + d] < rev) i += d;
    i++;
    if (i < MAXN && !(rev < rec[i])) {
      int j = i;
      while (j < MAXN && !(rec[i] < rec[j])) j++;
      for (int _t = j, k = i; k < _t; k++) R[rec[p].num].push_back(rec[k].num);
    }
  }
}
const int IAL = 1 << 18;
int ia[IAL + 1];
int g(int v) { return v & (-v); }
void add(int v) {
  while (v < IAL) {
    ia[v]++;
    v += g(v);
  }
}
int sum(int v) {
  int res = 0;
  while (v) {
    res += ia[v];
    v -= g(v);
  }
  return res;
}
void solve() {
  int maxx, maxy, w;
  cin >> maxx >> maxy >> w;
  memset(ia, 0, sizeof(ia));
  bool ok = false;
  long long ansx = 1E8, ansy = 1E8;
  int all_sum = 0;
  for (int x = 1; x <= maxx; x++) {
    for (int _t = R[x].size(), p = 0; p < _t; p++)
      if (R[x][p] <= maxy) {
        add(R[x][p]);
        all_sum++;
      }
    if (all_sum >= w) {
      int d = 1;
      while (d < maxy) d *= 2;
      int y = 0;
      for (; d > 0; d /= 2)
        if (y + d <= maxy && sum(y + d) < w) y += d;
      y++;
      if ((long long)x * (long long)y < ansx * ansy) {
        ansx = x;
        ansy = y;
        ok = true;
      }
    }
  }
  if (ok)
    cout << ansx << " " << ansy << endl;
  else
    cout << -1 << endl;
}
int main() {
  init();
  solve();
  return 0;
}
