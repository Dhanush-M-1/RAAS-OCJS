#include <bits/stdc++.h>
using namespace std;
int arr[1000050], d[1000050], tim[1000050], ind[1000050];
set<int> e[1000050];
vector<int> g[1000050];
priority_queue<pair<int, int>, vector<pair<int, int> >,
               greater<pair<int, int> > >
    q;
int main() {
  int n, i, x, vs, curx, curd, next, size;
  pair<int, int> pa;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &x);
    if (x) {
      e[x].insert(i);
      e[i].insert(x);
      d[x]++;
      d[i]++;
    }
  }
  for (i = 1; i <= n; i++) q.push(make_pair(d[i], i));
  for (; !q.empty();) {
    pa = q.top();
    curx = pa.second;
    curd = pa.first;
    q.pop();
    if (d[curx] != curd) continue;
    arr[++vs] = curx;
    if (d[curx]) {
      next = *e[curx].begin();
      d[curx]--;
      d[next]--;
      e[curx].erase(next);
      e[next].erase(curx);
      q.push(make_pair(d[next], next));
      if (tim[curx] % 2 == 0) {
        tim[next]++;
        g[next].push_back(curx);
        ind[curx]++;
      } else {
        g[curx].push_back(next);
        ind[next]++;
      }
    } else if (tim[curx] & 1) {
      printf("NO\n");
      return 0;
    }
  }
  printf("YES\n");
  for (; !q.empty(); q.pop())
    ;
  for (i = 1; i <= n; i++) q.push(make_pair(ind[i], i));
  for (; !q.empty();) {
    pa = q.top();
    curx = pa.second;
    curd = pa.first;
    q.pop();
    if (ind[curx] != curd) continue;
    printf("%d\n", curx);
    size = g[curx].size();
    for (i = 0; i < size; i++) {
      ind[g[curx][i]]--;
      q.push(make_pair(ind[g[curx][i]], g[curx][i]));
    }
  }
  return 0;
}
