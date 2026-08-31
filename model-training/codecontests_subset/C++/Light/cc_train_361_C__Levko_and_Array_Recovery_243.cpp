#include <bits/stdc++.h>
using namespace std;
const int kMaxN = 5025;
const int INF = (1 << 29);
int Maxi[kMaxN], S[kMaxN], A[kMaxN], B[kMaxN], T[kMaxN];
int n, m, maxi;
int main() {
  scanf("%d%d", &n, &m);
  int a, b, c, type;
  bool ok = 1;
  for (int i = 0; i < n; ++i) Maxi[i] = INF;
  for (int i = 0; i < m; ++i) {
    cin >> type >> a >> b >> c;
    a--;
    b--;
    A[i] = a;
    B[i] = b;
    S[i] = c;
    T[i] = type;
    if (type == 1) {
      for (int i = a; i <= b; ++i) {
        Maxi[i] += c;
      }
    } else {
      bool ok2 = 0;
      for (int i = a; i <= b; ++i) {
        if (Maxi[i] >= c) {
          ok2 = 1;
          Maxi[i] = c;
        }
      }
      ok = ok && ok2;
    }
  }
  for (int i = m - 1; i >= 0; --i) {
    if (T[i] == 1) {
      for (int j = A[i]; j <= B[i]; ++j) {
        Maxi[j] -= S[i];
      }
    } else {
      maxi = INT_MIN;
      for (int j = A[i]; j <= B[i]; ++j) {
        maxi = max(maxi, Maxi[j]);
      }
      if (maxi != S[i]) ok = 0;
    }
  }
  if (!ok)
    puts("NO");
  else {
    puts("YES");
    for (int i = 0; i < n; ++i) {
      printf("%d%s", Maxi[i], i == n - 1 ? "\n" : " ");
    }
  }
}
