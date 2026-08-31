#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  vector<pair<int, int>> coor(n + 10);
  for (int i = 1; i <= n; ++i) {
    cin >> coor[i].first >> coor[i].second;
  }
  sort(coor.begin() + 1, coor.begin() + 1 + n);
  coor[0] = {-2e9 + 10, 0};
  coor[n + 1] = {2e9 + 10, 0};
  int answer = 0;
  for (int i = 1; i <= n; ++i) {
    if (coor[i].first - coor[i].second > coor[i - 1].first) {
      ++answer;
    } else if (coor[i].first + coor[i].second < coor[i + 1].first) {
      ++answer;
      coor[i].first += coor[i].second;
    }
  }
  cout << answer;
}
