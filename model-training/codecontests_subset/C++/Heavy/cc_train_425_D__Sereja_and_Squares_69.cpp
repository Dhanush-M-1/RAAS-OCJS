#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
int n, ans;
vector<int> xs[N], ys[N];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 0; i < n; ++i) {
    int x, y;
    cin >> x >> y;
    xs[x].push_back(y);
    ys[y].push_back(x);
  }
  for (int i = 0; i < N; ++i) {
    sort(xs[i].begin(), xs[i].end());
    sort(ys[i].begin(), ys[i].end());
  }
  for (int i = 0; i < N; ++i) {
    int nowX = i;
    for (int nowY : xs[i]) {
      int boundY = upper_bound(xs[nowX].begin(), xs[nowX].end(), nowY) -
                   xs[nowX].begin();
      int boundX = upper_bound(ys[nowY].begin(), ys[nowY].end(), nowX) -
                   ys[nowY].begin();
      while (boundY < (int)xs[nowX].size() and boundX < (int)ys[nowY].size()) {
        int checkX = ys[nowY][boundX];
        int checkY = xs[nowX][boundY];
        if (checkX - nowX > checkY - nowY)
          ++boundY;
        else if (checkX - nowX < checkY - nowY)
          ++boundX;
        else {
          ans += binary_search(xs[checkX].begin(), xs[checkX].end(), checkY);
          ++boundX;
          ++boundY;
        }
      }
    }
  }
  cout << ans << '\n';
}
