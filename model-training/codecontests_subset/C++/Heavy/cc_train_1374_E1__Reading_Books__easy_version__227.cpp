#include <bits/stdc++.h>
using namespace std;
template <class T>
inline bool chmax(T &a, T b) {
  if (a < b) {
    a = b;
    return true;
  }
  return false;
}
template <class T>
inline bool chmin(T &a, T b) {
  if (a > b) {
    a = b;
    return true;
  }
  return false;
}
const long long INF = 1e11;
vector<long long> v[2][2];
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  long long N, K;
  cin >> N >> K;
  for (int i = 0; i < N; i++) {
    long long t, a, b;
    cin >> t >> a >> b;
    v[a][b].push_back(t);
  }
  long long ans = INF;
  for (int i = 0; i <= 1; i++) {
    for (int j = 0; j <= 1; j++) {
      for (int k = 0; k <= K; k++) {
        v[i][j].push_back(INF);
      }
      sort(v[i][j].begin(), v[i][j].end());
    }
  }
  long long now = 0;
  for (int i = 0; i < K; i++) {
    now += v[1][1][i];
  }
  chmin(ans, now);
  for (int i = 0; i < K; i++) {
    now -= v[1][1][K - 1 - i];
    now += v[0][1][i];
    now += v[1][0][i];
    chmin(ans, now);
  }
  if (ans >= INF) ans = -1;
  cout << ans << "\n";
  return 0;
}
