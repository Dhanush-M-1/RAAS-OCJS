#include <bits/stdc++.h>
using namespace std;
const int inf = 1023456789;
struct minion {
  int a, b, i;
};
void solve_case() {
  int N, K;
  cin >> N >> K;
  vector<minion> minions(N);
  for (int i = 0; i < N; ++i) {
    cin >> minions[i].a >> minions[i].b;
    minions[i].i = i;
  }
  sort(minions.begin(), minions.end(),
       [](const minion &x, const minion &y) { return x.b < y.b; });
  vector<vector<int>> dp_score(N, vector<int>(K + 1, -inf));
  vector<vector<bool>> dp_keep(N, vector<bool>(K + 1));
  for (int i = 0; i < N; ++i) {
    for (int j = 0; j <= min(i + 1, K); ++j) {
      int score_keep_minion = j == 0 ? -inf
                                     : ((i == 0 ? 0 : dp_score[i - 1][j - 1]) +
                                        minions[i].a + (j - 1) * minions[i].b);
      int score_destroy_minion =
          j == i + 1
              ? -inf
              : (i == 0 ? 0 : dp_score[i - 1][j]) + minions[i].b * (K - 1);
      if (score_keep_minion > score_destroy_minion) {
        dp_score[i][j] = score_keep_minion;
        dp_keep[i][j] = true;
      } else {
        dp_score[i][j] = score_destroy_minion;
        dp_keep[i][j] = false;
      };
    }
  }
  vector<int> keep;
  vector<int> destroy;
  int j = K;
  for (int i = N - 1; i >= 0; --i) {
    if (dp_keep[i][j]) {
      keep.push_back(minions[i].i);
      j--;
    } else {
      destroy.push_back(minions[i].i);
    }
  }
  assert(j == 0);
  assert(keep.size() == K);
  reverse(keep.begin(), keep.end());
  cout << (keep.size() + 2 * destroy.size()) << "\n";
  for (int i = 0; i < K - 1; ++i) {
    cout << (1 + keep[i]) << " ";
  }
  for (int i = 0; i < destroy.size(); ++i) {
    cout << (1 + destroy[i]) << " ";
    cout << -(1 + destroy[i]) << " ";
  }
  cout << (1 + keep[K - 1]) << "\n";
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int T;
  cin >> T;
  for (int t = 0; t < T; ++t) {
    solve_case();
  }
  return 0;
}
