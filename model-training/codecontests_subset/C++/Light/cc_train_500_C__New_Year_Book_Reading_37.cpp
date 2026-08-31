#include <bits/stdc++.h>
using namespace std;
const int kMaxN = 505;
const int kMaxM = 1005;
int n, m;
int w[kMaxN];
int b[kMaxM];
int order[kMaxN];
int lastPos[kMaxN];
int solve() {
  int res = 0;
  int cnt = 0;
  int sum_w = 0;
  memset(lastPos, -1, sizeof(lastPos));
  for (int i = 0; i < (m); ++i) {
    int cur_book = b[i];
    if (lastPos[cur_book] == -1) {
      res += sum_w;
      lastPos[cur_book] = cnt;
      order[cnt] = cur_book;
      ++cnt;
      sum_w += w[cur_book];
    } else {
      int add = 0;
      for (int j = lastPos[cur_book] + 1; j < cnt; ++j) {
        add += w[order[j]];
        order[j - 1] = order[j];
        lastPos[order[j]] = j - 1;
      }
      res += add;
      order[cnt - 1] = cur_book;
      lastPos[cur_book] = cnt - 1;
    }
  }
  return res;
}
int main() {
  cin >> n >> m;
  for (int i = 0; i < (n); ++i) {
    cin >> w[i];
  }
  for (int i = 0; i < (m); ++i) {
    cin >> b[i];
    --b[i];
  }
  cout << solve() << endl;
  return 0;
}
