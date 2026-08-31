#include <bits/stdc++.h>
using namespace std;
struct vertT {
  long long r, c;
};
bool operator<(vertT v1, vertT v2) {
  if (v1.r != v2.r)
    return v1.r > v2.r;
  else
    return v1.c > v2.c;
}
set<vertT> allowed;
map<vertT, long long> dist;
void bfs(long long rs, long long cs) {
  queue<vertT> verts;
  vertT v;
  v.r = rs;
  v.c = cs;
  verts.push(v);
  dist[v] = 0;
  long long dx[] = {-1, 0, 1};
  while (!verts.empty()) {
    v = verts.front();
    verts.pop();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i != 1 || j != 1) {
          vertT w;
          w.r = v.r + dx[i];
          w.c = v.c + dx[j];
          if (allowed.find(w) != allowed.end() && dist.find(w) == dist.end()) {
            verts.push(w);
            dist[w] = dist[v] + 1;
          }
        }
      }
    }
  }
}
int main(void) {
  long long rs, cs, re, ce;
  cin >> rs >> cs >> re >> ce;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int j = a; j <= b; j++) {
      vertT v;
      v.r = r;
      v.c = j;
      allowed.insert(v);
    }
  }
  bfs(rs, cs);
  vertT v;
  v.r = re;
  v.c = ce;
  if (dist.find(v) == dist.end())
    cout << -1 << endl;
  else
    cout << dist[v] << endl;
}
