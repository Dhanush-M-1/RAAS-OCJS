#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e6 + 5;
int N, R, C, a[MAXN], s[MAXN], nex[MAXN][20], ans, st;
string S[MAXN];
int main() {
  cin >> N >> R >> C;
  ++C;
  for (int i = 1; i <= N; ++i)
    cin >> S[i], a[i] = S[i].size() + 1, s[i] = s[i - 1] + a[i];
  for (int i = N, j = N; i >= 1; --i) {
    for (; j >= i && s[j] - s[i - 1] > C; --j)
      ;
    nex[i][0] = j + 1;
  }
  for (int i = 1; i < 20; ++i) {
    for (int j = 1; j <= N; ++j) nex[j][i] = nex[nex[j][i - 1]][i - 1];
  }
  for (int i = 1; i <= N; ++i) {
    int k = R, pos = i;
    for (int j = 19; j >= 0; --j)
      if ((1 << j) <= k) {
        k -= 1 << j, pos = nex[pos][j];
        if (!pos) break;
      }
    if (!pos) pos = N + 1;
    if (pos - i > ans) ans = pos - i, st = i;
  }
  if (st) {
    int sum = 0;
    for (int i = st; i <= N; ++i) {
      if (a[i] > C) break;
      sum += a[i];
      if (sum > C)
        --R, sum = a[i], cout << endl;
      else if (i != st)
        cout << ' ';
      if (!R) break;
      cout << S[i];
    }
  }
  return 0;
}
