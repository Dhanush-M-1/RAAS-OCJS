#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1005;
int N, M, W[MAXN], B[MAXN], res;
pair<int, int> P[MAXN];
int main() {
  cin >> N >> M;
  for (int i = 1; i <= N; i++) {
    cin >> W[i];
    P[i].first = MAXN;
    P[i].second = i;
  }
  for (int i = 1; i <= M; i++) {
    cin >> B[i];
    if (P[B[i]].first == MAXN) P[B[i]].first = i;
  }
  sort(P + 1, P + N + 1);
  for (int i = 1; i <= M; i++) {
    for (int j = N; j > 1; j--) {
      if (P[j].second != B[i]) continue;
      swap(P[j - 1], P[j]);
      res += W[P[j].second];
    }
  }
  cout << res << '\n';
}
