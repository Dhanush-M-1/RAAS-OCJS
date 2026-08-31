#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 200000 + 10;
long long BIT1[MAXN], BIT2[MAXN];
long long N;
void update(long long p, long long num, long long *BIT) {
  for (; p <= N; p += p & -p) {
    BIT[p] += num;
  }
}
long long query(long long p, long long *BIT) {
  long long sum = 0;
  for (; p > 0; p -= p & -p) {
    sum += BIT[p];
  }
  return sum;
}
long long arr_num[MAXN], arr_pos[MAXN];
signed main(void) {
  cin >> N;
  for (long long i = 1; i <= N; i++) {
    cin >> arr_num[i];
    arr_pos[arr_num[i]] = i;
  }
  long long ans = 0;
  for (long long i = 1; i <= N; i++) {
    ans += i - query(arr_pos[i], BIT1) - 1;
    update(arr_pos[i], 1, BIT1);
    update(arr_pos[i], arr_pos[i], BIT2);
    long long lb = 1, ub = N;
    while (ub > lb) {
      long long mid = (lb + ub + 1) >> 1;
      if (query(mid - 1, BIT1) > i / 2) {
        ub = mid - 1;
      } else {
        lb = mid;
      }
    }
    long long upper = query(N, BIT1) - query(ub, BIT1);
    long long add1 =
        query(N, BIT2) - query(ub, BIT2) - ub * upper - (1 + upper) * upper / 2;
    long long lower = query(ub - 1, BIT1);
    long long add2 = ub * lower - query(ub - 1, BIT2) - (1 + lower) * lower / 2;
    cout << ans + add1 + add2 << " ";
  }
  cout << endl;
  return 0;
}
