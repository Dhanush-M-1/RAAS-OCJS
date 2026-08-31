#include <bits/stdc++.h>
using namespace std;
const int INF = ~0U >> 1;
const double eps = 1e-6;
const int MAXN = 100;
int n, A[MAXN], B[MAXN];
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) scanf("%d %d", &A[i], &B[i]);
  int res = 0;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      if (j != i)
        if (A[i] == B[j]) res++;
  cout << res << endl;
  return 0;
}
