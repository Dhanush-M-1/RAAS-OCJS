#include <bits/stdc++.h>
using namespace std;
int main() {
  cin.tie(0), ios_base::sync_with_stdio(0);
  int T;
  long long int i, j, p, q;
  cin >> T;
  long long int cnt2, N, L, R, cnt;
  for (int t = 0; t < T; t++) {
    cin >> N >> L >> R;
    cnt = 0;
    for (i = 1; i < N; i++) {
      if (L <= cnt + 2 * (N - i)) {
        for (j = L; j <= R - 1; j++) {
          if ((j - cnt) % 2 == 0)
            cnt2 = (j - cnt) / 2 + i;
          else
            cnt2 = i;
          cout << cnt2 << " ";
          if (cnt + 2 * (N - i) == j) cnt += 2 * (N - i), i++;
        }
        if (R <= N * (N - 1)) {
          if ((j - cnt) % 2 == 0)
            cnt2 = (j - cnt) / 2 + i;
          else
            cnt2 = i;
          cout << cnt2 << " ";
        }
        break;
      }
      cnt += 2 * (N - i);
      if (R < L) break;
    }
    if (R == N * (N - 1) + 1) {
      cout << 1;
    }
    cout << "\n";
  }
}
