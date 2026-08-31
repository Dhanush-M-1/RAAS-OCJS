#include <bits/stdc++.h>
using namespace std;
const int XX = 1e5 + 10;
const int NX = 1e5 + 10;
struct point {
  int x, y;
  point() {}
  point(int x, int y) : x(x), y(y) {}
} P[NX];
vector<int> X[XX], Y[XX];
unordered_set<int> USX[XX];
int N;
int main() {
  scanf("%d", &N);
  for (int i = 1; i <= N; i++) {
    scanf("%d %d", &P[i].x, &P[i].y);
    int x = P[i].x;
    int y = P[i].y;
    X[x].push_back(y);
    Y[y].push_back(x);
    USX[x].insert(y);
  }
  for (int i = 0; i < XX; i++) {
    sort(X[i].begin(), X[i].end());
    sort(Y[i].begin(), Y[i].end());
  }
  long long ans = 0;
  for (int i = 1; i <= N; i++) {
    int x = P[i].x, y = P[i].y;
    int low_x = lower_bound(Y[y].begin(), Y[y].end(), x) - Y[y].begin();
    int low_y = lower_bound(X[x].begin(), X[x].end(), y) - X[x].begin();
    if (low_x < low_y) {
      for (int i = 0; i < low_x; i++) {
        int x2 = Y[y][i];
        int dist = x - x2;
        if (USX[x2].count(y - dist) && USX[x].count(y - dist)) ans++;
      }
    } else {
      for (int i = 0; i < low_y; i++) {
        int y2 = X[x][i];
        int dist = y - y2;
        if (x - dist >= 0 && USX[x - dist].count(y) &&
            USX[x - dist].count(y2)) {
          ans++;
        }
      }
    }
  }
  printf("%lld\n", ans);
}
