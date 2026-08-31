#include <bits/stdc++.h>
using namespace std;
const long long int N = 20, A = 7;
long long int n;
deque<long long int> a;
deque<pair<long long int, long long int> > p[10];
void Quay(long long int l, long long int h, long long int sum,
          long long int mask) {
  if (l > h) {
    p[sum % 10].push_back({sum, mask});
  } else {
    Quay(l + 1, h, sum, mask * 10);
    Quay(l + 1, h, sum + 4, mask * 10 + 4);
    Quay(l + 1, h, sum + 7, mask * 10 + 7);
  }
}
void Inp() {
  cin >> n;
  a.clear();
  a.push_back(0);
  for (int i = 1; i < N; i++) {
    a.push_back(n % 10);
    n = n / 10;
  }
}
long long int dp[N][A], trace[N][A];
void Solve() {
  fill_n(&dp[0][0], sizeof(dp) / sizeof(dp[0][0]), -1);
  dp[0][0] = 0;
  for (int i = 0; i < N - 1; i++) {
    for (int j = 0; j < A; j++) {
      if (dp[i][j] != -1) {
        long long int vt = (a[i + 1] - j + 100) % 10;
        for (auto v : p[vt]) {
          long long int k = v.first + j;
          if ((k % 10) == a[i + 1]) {
            dp[i + 1][k / 10] = v.second;
            trace[i + 1][k / 10] = j;
          }
        }
      }
    }
  }
}
deque<long long int> ans[7];
void Add(long long int k) {
  for (int i = 1; i <= 6; i++) {
    ans[i].push_front(k % 10);
    k = k / 10;
  }
}
void Out() {
  for (int i = 1; i <= 6; i++) {
    while (ans[i].size() > 1) {
      if (ans[i].back() == 0) {
        ans[i].pop_back();
      } else {
        break;
      }
    }
    for (int j = ans[i].size() - 1; j >= 0; j--) {
      putchar(ans[i][j] + '0');
    }
    putchar(' ');
  }
  putchar('\n');
}
void Trace() {
  if (dp[N - 1][0] == -1) {
    putchar('-');
    putchar('1');
    putchar('\n');
    return;
  }
  for (int i = 1; i <= 6; i++) {
    ans[i].clear();
  }
  long long int k = 0;
  for (int i = N - 1; i > 0; i--) {
    Add(dp[i][k]);
    k = trace[i][k];
  }
  Out();
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int T;
  cin >> T;
  Quay(1, 6, 0, 0);
  while (T--) {
    Inp();
    Solve();
    Trace();
  }
}
