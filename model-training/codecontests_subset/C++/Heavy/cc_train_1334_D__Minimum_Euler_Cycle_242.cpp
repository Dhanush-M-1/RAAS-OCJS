#include <bits/stdc++.h>
using namespace std;
const int N = 300005;
int main() {
  long long test = 1;
  scanf("%d", &test);
  while (test--) {
    long long n;
    long long l, r;
    scanf("%lld %lld %lld", &n, &l, &r);
    if (l == 1LL * n * (n - 1) + 1) {
      printf("1\n");
      continue;
    }
    long long start = 1;
    long long curr = 0;
    while ((n - start) && curr + 2 * (n - start) < l) {
      curr += 2 * (n - start);
      start++;
    }
    long long idx = start + (l - curr + 1) / 2;
    long long tot = r - l + 1;
    vector<long long> v;
    if ((l - curr) % 2 == 0) {
      v.push_back(idx);
      idx++;
    }
    for (long long j = idx; j <= n && v.size() < tot; j++) {
      v.push_back(start);
      if (v.size() < tot) {
        v.push_back(j);
      }
    }
    for (long long i = start + 1; i <= n && v.size() < tot; i++) {
      for (long long j = i + 1; j <= n && v.size() < tot; j++) {
        v.push_back(i);
        if (v.size() < tot) {
          v.push_back(j);
        }
      }
    }
    if (v.size() < tot) {
      v.push_back(1);
    }
    for (long long i = 0; i < v.size(); i++) {
      printf("%lld ", v[i]);
    }
    printf("\n");
  }
  return 0;
}
