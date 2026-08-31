#include <bits/stdc++.h>
using namespace std;
const int inf = (int)1e9;
const int mod = inf + 7;
const double eps = 1e-9;
const double pi = acos(-1.0);
int n;
vector<int> g[200200];
int dp[2][200200];
int calc(int has, int v, int par) {
  int &res = dp[has][v];
  if (res != -1) return res;
  vector<int> childs;
  for (__typeof(g[v].begin()) it = g[v].begin(); it != g[v].end(); it++) {
    if ((*it) != par) childs.push_back(*it);
  }
  if (childs.empty()) {
    if (has) return res = 0;
    return res = 1;
  }
  res = 0;
  if ((has + (int)childs.size()) % 2 == 0) {
    int cur = 1;
    for (__typeof(childs.begin()) it = childs.begin(); it != childs.end(); it++)
      cur &= calc(0, *it, v);
    if (cur) return res = 1;
  }
  vector<int> good, bad;
  for (__typeof(childs.begin()) it = childs.begin(); it != childs.end(); it++) {
    if (calc(0, *it, v))
      good.push_back(*it);
    else
      bad.push_back(*it);
  }
  for (__typeof(bad.begin()) it = bad.begin(); it != bad.end(); it++) {
    if (!calc(1, *it, v)) return res = 0;
  }
  int k = has + (int)childs.size() - (int)bad.size();
  if (k % 2 == 0) return res = 1;
  for (__typeof(good.begin()) it = good.begin(); it != good.end(); it++) {
    if (calc(1, *it, v)) return res = 1;
  }
  return res = 0;
}
void rec(int has, int v, int par) {
  vector<int> childs;
  for (__typeof(g[v].begin()) it = g[v].begin(); it != g[v].end(); it++) {
    if ((*it) != par) childs.push_back(*it);
  }
  if (childs.empty()) {
    printf("%d\n", v + 1);
    return;
  }
  if ((has + (int)childs.size()) % 2 == 0) {
    int cur = 1;
    for (__typeof(childs.begin()) it = childs.begin(); it != childs.end(); it++)
      cur &= calc(0, *it, v);
    if (cur) {
      printf("%d\n", v + 1);
      for (__typeof(childs.begin()) it = childs.begin(); it != childs.end();
           it++)
        rec(0, *it, v);
      return;
    }
  }
  vector<int> good, bad;
  for (__typeof(childs.begin()) it = childs.begin(); it != childs.end(); it++) {
    if (calc(0, *it, v))
      good.push_back(*it);
    else
      bad.push_back(*it);
  }
  for (__typeof(bad.begin()) it = bad.begin(); it != bad.end(); it++) {
    rec(1, *it, v);
  }
  int k = has + (int)childs.size() - (int)bad.size();
  int pos = -1;
  if (k % 2 == 1) {
    pos = 0;
    while (!calc(1, good[pos], v)) pos++;
    rec(1, good[pos], v);
  }
  printf("%d\n", v + 1);
  for (int i = 0; i < (int)good.size(); i++) {
    if (i == pos) continue;
    rec(0, good[i], v);
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int x;
    scanf("%d", &x);
    x--;
    if (x != -1) {
      g[i].push_back(x);
      g[x].push_back(i);
    }
  }
  memset(dp, -1, sizeof dp);
  if (calc(0, 0, -1)) {
    cout << "YES" << endl;
    rec(0, 0, -1);
  } else
    cout << "NO" << endl;
  return 0;
}
