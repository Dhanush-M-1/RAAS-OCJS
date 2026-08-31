#include <bits/stdc++.h>
using namespace std;
int M, N, mark[1000];
void openFile() { freopen("in.inp", "r", stdin); }
int main() {
  ios::sync_with_stdio(false);
  cin >> N >> M;
  for (int i = 0, sz; i < N; ++i) {
    cin >> sz;
    for (int j = 0, x; j < sz; ++j) {
      cin >> x;
      mark[x] = 1;
    }
  }
  int ans = 0;
  for (int i = 1; i <= M; ++i) ans += mark[i];
  if (ans == M)
    printf("YES");
  else
    printf("NO");
}
