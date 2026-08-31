#include <bits/stdc++.h>
using namespace std;
void fail() {
  cout << -1 << endl;
  exit(0);
}
int main() {
  int N, D;
  cin >> N >> D;
  vector<int64_t> A(N), S(N + 1);
  for (int i = 0; i < N; i++) {
    cin >> A[i];
    S[i + 1] = S[i] + A[i];
  }
  for (int i = N - 1; i >= 0; i--) S[i] = max(S[i], S[i + 1]);
  if (S[0] > D) fail();
  int64_t now = 0, ans = 0, gained = 0;
  for (int i = 0; i < N; i++) {
    int64_t a = A[i];
    if (a == 0 && now < 0) {
      int64_t avail = D - S[i] - gained;
      now += avail;
      if (now < 0) fail();
      ans++;
      gained += avail;
    }
    now += a;
    if (now > D) fail();
  }
  cout << ans << endl;
  return 0;
}
