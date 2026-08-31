#include <bits/stdc++.h>
using namespace std;
int dp[100005][2];
pair<int, int> a[100005];
int main() {
  int n, x, y;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x >> y;
    a[i] = make_pair(x, y);
  }
  int c = 2;
  int LEFT = 0;
  int RIGHT = 1;
  int prev = LEFT;
  for (int i = 1; i < n - 1; i++) {
    if (prev == LEFT) {
      if (a[i - 1].first < a[i].first - a[i].second) {
        prev = LEFT;
        c++;
      } else if (a[i].first + a[i].second < a[i + 1].first) {
        prev = RIGHT;
        c++;
      } else {
        prev = LEFT;
      }
    } else if (prev == RIGHT) {
      if (a[i - 1].first + a[i - 1].second < a[i].first - a[i].second) {
        prev = LEFT;
        c++;
      } else if (a[i].first + a[i].second < a[i + 1].first) {
        prev = RIGHT;
        c++;
      } else {
        prev = LEFT;
      }
    }
  }
  cout << (n == 1 ? 1 : c) << endl;
}
