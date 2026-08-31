#include <bits/stdc++.h>
#pragma GCC target("avx")
#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long int A, B, C, D, E, H, W, M, K, L, R, N, X, Y, Z, num = 0, sum = 0,
                                                             flag = 0;
  string S, T;
  cin >> Z;
  while (Z--) {
    cin >> N >> M;
    vector<long long int> P(N, 0);
    vector<long long int> Q(M, 0);
    for (long long int i = 0; i < N; i++) cin >> P[i];
    for (long long int i = 0; i < M; i++) cin >> Q[i];
    sort(P.begin(), P.end());
    sort(Q.begin(), Q.end());
    num = -1;
    for (long long int i = 0; i < N; i++)
      for (long long int j = 0; j < M; j++)
        if (P[i] == Q[j]) num = P[i];
    if (num == -1)
      cout << "NO" << endl;
    else {
      cout << "YES" << endl;
      cout << 1 << " " << num << endl;
    }
  }
}
