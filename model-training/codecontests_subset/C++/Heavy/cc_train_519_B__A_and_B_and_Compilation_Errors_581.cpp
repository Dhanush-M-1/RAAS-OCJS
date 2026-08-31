#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  long long N;
  scanf("%lld", &N);
  vector<long long> a, b, c;
  map<long long, long long> A, B, C;
  for (long long n = 0; n < N; ++n) {
    long long x;
    scanf("%lld", &x);
    a.push_back(x);
    A[x] += 1;
  }
  for (long long n = 0; n < (N - 1); ++n) {
    long long x;
    scanf("%lld", &x);
    b.push_back(x);
    B[x] += 1;
  }
  for (long long n = 0; n < (N - 2); ++n) {
    long long x;
    scanf("%lld", &x);
    c.push_back(x);
    C[x] += 1;
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  long long Ans1 = -1, Ans2 = -1;
  for (long long n = 0; n < N; ++n) {
    if (B[a[n]] == 0) {
      Ans1 = a[n];
      break;
    }
    B[a[n]] -= 1;
  }
  for (long long n = 0; n < N - 1; ++n) {
    if (C[b[n]] == 0) {
      Ans2 = b[n];
      break;
    }
    C[b[n]] -= 1;
  }
  cout << Ans1 << endl << Ans2 << endl;
  return 0;
}
