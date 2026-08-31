#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:16777216")
using namespace std;
long long gcd(long long a, long long b) {
  while (a) {
    b %= a;
    swap(a, b);
  }
  return b;
}
map<int, map<int, int>*>* pole = new map<int, map<int, int>*>();
map<int, bool> used;
int dx[] = {-1, 0, 1, 1, 0, -1, 1, -1};
int dy[] = {1, 1, 1, -1, -1, -1, 0, 0};
int main() {
  int x0, y0, x1, y1;
  int n;
  cin >> x0 >> y0 >> x1 >> y1;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    if (used.find(r) == used.end()) {
      (*pole)[r] = new map<int, int>();
      used[r] = true;
    }
    for (int j = a; j <= b; j++) (*(*pole)[r])[j] = -1;
  }
  swap(y0, x0);
  swap(x1, y1);
  (*(*pole)[y0])[x0] = 0;
  queue<pair<int, int>> q;
  q.push(make_pair(y0, x0));
  while (!q.empty()) {
    int x, y, W;
    y = q.front().first;
    x = q.front().second;
    q.pop();
    W = (*(*pole)[y])[x];
    for (int i1 = 0; i1 < 8; i1++) {
      int tx = x + dx[i1];
      int ty = y + dy[i1];
      if (used.find(ty) == used.end()) continue;
      if ((*pole).find(ty) != (*pole).end())
        if ((*(*pole)[ty]).find(tx) != (*(*pole)[ty]).end())
          if ((*(*pole)[ty])[tx] == -1) {
            (*(*pole)[ty])[tx] = W + 1;
            q.push(make_pair(ty, tx));
          }
    }
  }
  printf("%d", (*(*pole)[y1])[x1]);
  return 0;
}
