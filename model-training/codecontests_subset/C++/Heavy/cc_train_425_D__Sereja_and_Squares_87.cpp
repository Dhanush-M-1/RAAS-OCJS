#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 7;
const int inf = 0x3f3f3f3f;
const long long INF = 0x3f3f3f3f3f3f3f3f;
const int mod = 1e9 + 7;
int n;
struct Point {
  int x, y;
  bool operator<(const Point &rhs) const {
    if (y == rhs.y)
      return x < rhs.x;
    else
      return y < rhs.y;
  }
} a[N];
set<pair<int, int> > st;
vector<int> X[N];
vector<int> Y[N];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d%d", &a[i].x, &a[i].y);
  sort(a + 1, a + 1 + n);
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    if (X[a[i].x].size() < Y[a[i].y].size()) {
      for (int j = 0; j < X[a[i].x].size(); j++) {
        int len = a[i].y - X[a[i].x][j];
        if (st.count(make_pair(a[i].x - len, a[i].y)) &&
            st.count(make_pair(a[i].x - len, a[i].y - len)))
          ans++;
      }
    } else {
      for (int j = 0; j < Y[a[i].y].size(); j++) {
        int len = a[i].x - Y[a[i].y][j];
        if (st.count(make_pair(a[i].x, a[i].y - len)) &&
            st.count(make_pair(a[i].x - len, a[i].y - len)))
          ans++;
      }
    }
    st.insert(make_pair(a[i].x, a[i].y));
    X[a[i].x].push_back(a[i].y);
    Y[a[i].y].push_back(a[i].x);
  }
  printf("%d\n", ans);
  return 0;
}
