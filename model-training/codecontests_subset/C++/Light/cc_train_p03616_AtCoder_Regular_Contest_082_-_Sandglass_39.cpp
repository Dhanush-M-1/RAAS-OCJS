#include <cstdio>
#include <algorithm>
#include <cstring>
using namespace std;

const int MAX_N = 100005;
typedef long long i64;

int R[MAX_N], X, K, Q;

void get(i64 &temp) {
  if (temp < 0) temp = 0;
  if (temp > X) temp = X;
}

int main() {
  scanf("%d%d", &X, &K);
  for (int i = 1; i <= K; ++i)
    scanf("%d", &R[i]);

  scanf("%d", &Q);

  i64 sum = 0, mul = -1;
  i64 mn = 0, mx = X;
  int l = 1;
  
  while (Q--) {
    int T;
    i64 A;
    scanf("%d%lld", &T, &A);
    while (l <= K && R[l] <= T) {
      sum += (R[l] - R[l - 1]) * mul;
      mn += (R[l] - R[l - 1]) * mul;
      mx += (R[l] - R[l - 1]) * mul;
      get(mn), get(mx), mul = -mul;
      l++;
    }
    
    A += sum;
    if (A < mn) A = mn;
    if (A > mx) A = mx;
    A += (T - R[l - 1]) * mul;
    
    get(A);
    printf("%lld\n", A);
  }
  
  return 0;
}
