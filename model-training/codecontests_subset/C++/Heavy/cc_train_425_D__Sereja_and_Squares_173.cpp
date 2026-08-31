#include <bits/stdc++.h>
using namespace std;
const int N = 100000 + 5;
set<pair<int, int> > st;
struct PP {
  int x, y;
  bool operator<(const PP& a) const {
    if (y == a.y) return x < a.x;
    return y < a.y;
  }
} a[N];
vector<int> vx[N], vy[N];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d%d", &a[i].x, &a[i].y);
  }
  sort(a, a + n);
  int ans = 0;
  for (int i = 0; i < n; i++) {
    if (vx[a[i].x].size() < vy[a[i].y].size()) {
      for (int j = 0; j < vx[a[i].x].size(); j++) {
        int len = a[i].y - vx[a[i].x][j];
        if (st.count(pair<int, int>(a[i].x - len, a[i].y)) &&
            st.count(pair<int, int>(a[i].x - len, a[i].y - len)))
          ans++;
      }
    } else {
      for (int j = 0; j < vy[a[i].y].size(); j++) {
        int len = a[i].x - vy[a[i].y][j];
        if (st.count(pair<int, int>(a[i].x, a[i].y - len)) &&
            st.count(pair<int, int>(a[i].x - len, a[i].y - len)))
          ans++;
      }
    }
    st.insert(pair<int, int>(a[i].x, a[i].y));
    vx[a[i].x].push_back(a[i].y);
    vy[a[i].y].push_back(a[i].x);
  }
  printf("%d\n", ans);
  return 0;
}
