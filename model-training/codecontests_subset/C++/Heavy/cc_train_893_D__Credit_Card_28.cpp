#include <bits/stdc++.h>
using namespace std;
long long A[(int)1e5 + 5], pa[(int)1e5 + 5], maxi[(int)1e5 + 5];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int N, D;
  cin >> N >> D;
  for (int i = 0; i < N; i++) {
    cin >> A[i];
  }
  partial_sum(A, A + N, pa);
  long long curMax = -1000ll * 1000 * 1000 * 1000 * 1000 * 1000;
  for (int i = N - 1; i >= 0; i--) {
    curMax = max(curMax, pa[i]);
    maxi[i] = curMax;
  }
  if (curMax > D) {
    cout << -1;
    return 0;
  }
  long long tot = 0;
  long long added = 0;
  int moves = 0;
  for (int i = 0; i < N; i++) {
    tot += A[i];
    if (A[i] != 0) continue;
    if (tot < 0) {
      moves++;
      long long add = D - (maxi[i] + added);
      added += add;
      tot += add;
      if (tot < 0) {
        cout << -1;
        return 0;
      }
    }
  }
  cout << moves << endl;
  return 0;
}
