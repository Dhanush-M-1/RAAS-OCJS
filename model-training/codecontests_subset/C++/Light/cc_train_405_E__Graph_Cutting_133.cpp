#include <bits/stdc++.h>
using namespace std;
inline int toInt(string s) {
  int v;
  istringstream sin(s);
  sin >> v;
  return v;
}
template <class T>
inline string toString(T x) {
  ostringstream sout;
  sout << x;
  return sout.str();
}
template <class T>
inline T sqr(T x) {
  return x * x;
}
const double eps = 1e-10;
const double pi = acos(-1.0);
const long long INF = 1LL << 62;
const int inf = 1 << 29;
vector<pair<int, int> > graph[100010];
bool used[100010];
int n, m;
int dfs(int cur) {
  int l = -1, r;
  for (int i = (0); i < (graph[cur].size()); ++i) {
    int m = graph[cur][i].first;
    if (used[graph[cur][i].second]) continue;
    used[graph[cur][i].second] = true;
    r = dfs(graph[cur][i].first);
    if (r == -1) {
      if (l == -1) {
        l = m;
      } else {
        cout << l << " " << cur << " " << m << endl;
        l = -1;
      }
    } else
      cout << cur << " " << m << " " << r << endl;
  }
  return l;
}
int main(void) {
  scanf("%d %d", &n, &m);
  for (int i = (0); i < (m); ++i) {
    int f, t;
    scanf("%d %d", &f, &t);
    pair<int, int> in;
    in.second = i;
    in.first = t;
    graph[f].push_back(in);
    in.first = f;
    graph[t].push_back(in);
  }
  if (m & 1) {
    printf("No solution\n");
    return 0;
  }
  for (int i = (0); i < (100010); ++i) used[i] = false;
  dfs(1);
  return 0;
}
