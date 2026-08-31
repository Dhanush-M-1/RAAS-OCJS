#include <bits/stdc++.h>
using namespace std;
int N, M, P[1000006], C[1000006], x, y, r;
vector<int> g[1000006];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> N >> M;
  for (int i = 0; i < N; i++) cin >> P[i];
  for (int i = 0; i < M; i++) {
    cin >> x >> y;
    g[y].push_back(x);
  }
  for (int i = N - 1; i >= 0; i--)
    if (C[P[i]] == N - 1 - i - r && i != N - 1)
      r++;
    else
      for (int f : g[P[i]]) C[f]++;
  cout << r;
}
