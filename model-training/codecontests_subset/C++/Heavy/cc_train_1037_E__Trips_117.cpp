#include <bits/stdc++.h>
using namespace std;
struct P {
  int x, y, z;
  bool operator<(const P &a) const { return x < a.x; }
};
vector<int> v[222228];
int a, c, i, b, n, m, k, d;
int o[221111];
int l[221111];
int j[1111][9];
int e;
int dx[10] = {0, 1, 0, -1, 1, 1, -1, -1}, dy[10] = {1, 0, -1, 0, 1, -1, 1, -1},
    dz[10] = {0, 0, 0, 0, 1, -1};
long long x, y, mod = 1000000007, mod2 = 1000000009, mod3 = 2017;
long long z;
double pi = 3.14159265;
P u[222221];
stack<int> s;
queue<int> q, q1;
map<int, int> p[222222];
char r[13];
bool as(P a, P b) { return a.x > b.x; }
int main() {
  scanf("%d %d %d", &a, &b, &c);
  for (int t = 1; t <= b; t++) {
    scanf("%d %d", &n, &m);
    u[t] = {n, m};
    p[min(n, m)][max(m, n)] = 1;
    v[n].push_back(m);
    v[m].push_back(n);
    o[n]++;
    o[m]++;
  }
  k = a;
  for (int t = 1; t <= a; t++)
    if (o[t] < c) {
      k--;
      l[t] = 1;
      q.push(t);
    }
  for (; q.size(); q.pop())
    for (int h = 0; h < v[q.front()].size(); h++)
      if (!l[v[q.front()][h]]) {
        o[v[q.front()][h]]--;
        if (o[v[q.front()][h]] < c) {
          k--;
          l[v[q.front()][h]] = 1;
          q.push(v[q.front()][h]);
        }
      }
  s.push(k);
  for (int t = b; t > 1; t--)
    if (l[u[t].y] == 0 && !l[u[t].x] &&
        p[min(u[t].x, u[t].y)][max(u[t].x, u[t].y)]) {
      p[min(u[t].x, u[t].y)][max(u[t].x, u[t].y)] = 0;
      o[u[t].x]--;
      o[u[t].y]--;
      if (l[u[t].x] == 0 && o[u[t].x] < c) {
        k--;
        l[u[t].x] = 1;
        q.push(u[t].x);
      }
      if (l[u[t].y] == 0 && o[u[t].y] < c) {
        k--;
        l[u[t].y] = 1;
        q.push(u[t].y);
      }
      for (; q.size(); q.pop())
        for (int h = 0; h < v[q.front()].size(); h++)
          if (!l[v[q.front()][h]] && p[min(q.front(), v[q.front()][h])]
                                      [max(q.front(), v[q.front()][h])]) {
            p[min(q.front(), v[q.front()][h])]
             [max(q.front(), v[q.front()][h])] = 0;
            o[v[q.front()][h]]--;
            if (o[v[q.front()][h]] < c) {
              k--;
              l[v[q.front()][h]] = 1;
              q.push(v[q.front()][h]);
            }
          }
      s.push(k);
    } else
      s.push(k);
  for (; s.size(); s.pop()) printf("%d\n", s.top());
}
