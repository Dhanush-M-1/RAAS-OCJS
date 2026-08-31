#include <bits/stdc++.h>
using namespace std;
int lenA, lenB;
int A[1000004];
int B[1000004];
int idxB[1000004];
int main() {
  scanf("%d %d", &lenA, &lenB);
  for (int i = 0, _n = (lenA); i < _n; ++i) scanf("%d", A + i);
  memset(idxB, -1, sizeof(idxB));
  for (int j = 0, _n = (lenB); j < _n; ++j) {
    scanf("%d", B + j);
    idxB[B[j]] = j;
  }
  vector<long long> V;
  long long offset = 0;
  int res = 0;
  for (int k = 0, _n = (lenA * 2); k < _n; ++k) {
    long long p = idxB[A[k % lenA]];
    if (p < 0) {
      V.clear();
      continue;
    }
    p += offset;
    if (!V.empty() && V.back() >= p) {
      p += lenB;
      offset += lenB;
    }
    V.push_back(p);
    int len = int((V).size()) -
              (lower_bound(V.begin(), V.end(), p - lenB + 1) - V.begin());
    res = max(res, len);
  }
  printf("%d\n", res);
  return 0;
}
