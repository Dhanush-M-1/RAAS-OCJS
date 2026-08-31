#include <bits/stdc++.h>
using namespace std;
mt19937 rnd(chrono::steady_clock::now().time_since_epoch().count());
mt19937 rnf(2106);
const int N = 80;
const int INF = 1000000009;
struct ban {
  int i;
  int a, b;
};
bool operator<(const ban& t1, const ban& t2) { return t1.b < t2.b; }
int n, k;
ban t[N];
int dp[N][N];
int p[N][N];
void solv() {
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; ++i) {
    t[i].i = i;
    scanf("%d%d", &t[i].a, &t[i].b);
  }
  for (int i = 0; i < N; ++i)
    for (int j = 0; j < N; ++j) dp[i][j] = -INF;
  sort(t + 1, t + n + 1);
  dp[0][0] = 0;
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j <= k; ++j) {
      if (j < k) {
        if (dp[i][j] + t[i + 1].a + t[i + 1].b * j > dp[i + 1][j + 1]) {
          dp[i + 1][j + 1] = dp[i][j] + t[i + 1].a + t[i + 1].b * j;
          p[i + 1][j + 1] = 1;
        }
      }
      if (dp[i][j] + t[i + 1].b * (k - 1) > dp[i + 1][j]) {
        dp[i + 1][j] = dp[i][j] + t[i + 1].b * (k - 1);
        p[i + 1][j] = 0;
      }
    }
  }
  vector<int> ans1, ans0;
  int j = k;
  for (int i = n; i >= 1; --i) {
    if (p[i][j] == 1) {
      ans1.push_back(t[i].i);
      --j;
    } else {
      ans0.push_back(t[i].i);
    }
  }
  reverse((ans1).begin(), (ans1).end());
  printf("%d\n", ((int)(ans1).size()) + ((int)(ans0).size()) * 2);
  for (int i = 0; i < ((int)(ans1).size()) - 1; ++i) printf("%d ", ans1[i]);
  for (int i = 0; i < ((int)(ans0).size()); ++i)
    printf("%d %d ", ans0[i], -ans0[i]);
  printf("%d\n", ans1.back());
}
int main() {
  int tt;
  scanf("%d", &tt);
  while (tt--) solv();
  return 0;
}
