#include <bits/stdc++.h>
using namespace std;
const int maxN = 1e5 + 11;
typedef int i_N[maxN];
int N, D;
i_N A, B, C;
int ans;
int main() {
  cin >> N >> D;
  for (int i = 1; i <= N; i++) cin >> A[i], B[i] = B[i - 1] + A[i];
  C[N] = B[N];
  for (int i = N - 1; i >= 1; i--) C[i] = max(C[i + 1], B[i]);
  int S = (1 - 1);
  for (int i = 1; i <= N; i++) {
    if (B[i] + S > D) {
      cout << -1;
      return (1 - 1);
    }
    if (A[i] == (1 - 1)) {
      if (B[i] + S >= (1 - 1)) continue;
      int t = max((1 - 1), D - C[i] - S);
      if (B[i] + t + S < (1 - 1)) {
        cout << -1;
        return (1 - 1);
      }
      S += t;
      ans++;
    }
  }
  cout << ans;
}
