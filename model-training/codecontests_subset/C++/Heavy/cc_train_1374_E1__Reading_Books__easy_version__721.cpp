#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, k;
  cin >> n >> k;
  long long arr[n + 1];
  long long a, b, c;
  vector<long long> A, B, common;
  for (long long i = 0; i < n; i++) {
    cin >> a >> b >> c;
    if (b == 1 && c == 1) {
      common.push_back(a);
    } else if (b == 1) {
      A.push_back(a);
    } else if (c == 1) {
      B.push_back(a);
    }
  }
  sort(common.begin(), common.end());
  sort(A.begin(), A.end());
  sort(B.begin(), B.end());
  long long pc = 0, pa = 0, pb = 0;
  if ((long long)(common.size() + min(A.size(), B.size())) < k) {
    cout << "-1\n";
    return 0;
  }
  long long cnt = 0, res = 0;
  common.push_back(INT_MAX);
  A.push_back(INT_MAX);
  B.push_back(INT_MAX);
  while (pc < (long long)common.size() || (pa < A.size() && pb < B.size())) {
    if (cnt == k) break;
    if (common[pc] < A[pa] + B[pb]) {
      res += common[pc];
      pc++;
      cnt++;
    } else {
      res += (A[pa] + B[pb]);
      pa++;
      pb++;
      cnt++;
    }
  }
  if (cnt == k)
    cout << res;
  else
    cout << "-1";
  return 0;
}
