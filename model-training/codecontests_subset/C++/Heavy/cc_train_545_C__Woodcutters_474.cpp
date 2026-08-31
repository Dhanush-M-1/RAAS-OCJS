#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int> > trees;
int N;
int memo[100010][3];
int max_area(int i, int last_point, int dir) {
  if (i == N - 1) return 0;
  int &ret = memo[i][dir];
  if (ret != -1) {
    return ret;
  }
  int c1 = -1;
  if (trees[i].first - trees[i].second > last_point)
    c1 = max_area(i + 1, trees[i].first, 0) + 1;
  int c2 = -1;
  if (trees[i].first + trees[i].second < trees[i + 1].first) {
    c2 = max_area(i + 1, trees[i].first + trees[i].second, 1) + 1;
  }
  int c3 = -1;
  c3 = max_area(i + 1, trees[i].first, 2);
  return ret = max(c1, max(c2, c3));
}
int main() {
  memset(memo, -1, sizeof(memo));
  cin >> N;
  int x, h;
  for (int i = 0; i < N; i++) {
    cin >> x >> h;
    trees.push_back(make_pair(x, h));
  }
  sort(trees.begin(), trees.end());
  if (N == 1)
    cout << 1 << endl;
  else
    cout << max_area(1, trees[0].first, 0) + 2 << endl;
}
