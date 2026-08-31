#include <bits/stdc++.h>
using namespace std;
int main()
  {int N, M, d, i{}, j{}; cin >> N >> M;
  int A[N], B[N], C[M], D[M]; for (; i < N; ++i) cin >> A[i] >> B[i]; while (cin >> C[j] >> D[j]) ++j;
  for (i = 0; i < N; ++i)
    {int m(1e9), k{}; for (j = 0; j < M; ++j) if ((d = abs(A[i] - C[j]) + abs(B[i] - D[j])) < m) m = d, k = j;
    cout << ++k << "\n";}}