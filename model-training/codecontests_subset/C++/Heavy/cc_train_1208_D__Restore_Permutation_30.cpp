#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 200100;
const long long INF = 2000000100;
const long long MOD = 998244353;
long long N, S[MAXN], P[MAXN];
long long B[MAXN];
void update(int ind, long long v) {
  for (int i = ind; i <= N; i += (i & -i)) {
    B[i] += v;
  }
}
long long query(int ind) {
  if (ind == 0) return 0;
  long long s = 0;
  for (int i = ind; i > 0; i -= (i & -i)) {
    s += B[i];
  }
  return s;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin >> N;
  for (int i = 0; i < N; i++) cin >> S[i];
  for (int i = 1; i <= N; i++) update(i, i);
  for (int i = N - 1; i >= 0; i--) {
    long long a = 1, b = N, c;
    long long ans = -39;
    while (a <= b) {
      c = (a + b) / 2;
      if (query(c - 1) > S[i]) {
        b = c - 1;
      } else {
        ans = c;
        a = c + 1;
      }
    }
    P[i] = ans;
    update(ans, -ans);
  }
  for (int i = 0; i < N; i++) cout << P[i] << (i == N - 1 ? "\n" : " ");
}
