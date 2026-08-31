#include <bits/stdc++.h>
#define REP(i, a, n) for(ll i = ((ll) a); i < ((ll) n); i++)
#define INF 10000000000LL
using namespace std;
typedef long long ll;
 
ll X, K, R[200000], Q, T[200000], A[200000];
 
int main(void) {
  cin >> X >> K;
  R[0] = 0;
  REP(i, 1, K + 1) cin >> R[i];
  R[K + 1] = INF;
  cin >> Q;
  REP(i, 0, Q) cin >> T[i] >> A[i];
 
  ll lower = 0;
  ll upper = X;
 
  ll sum = 0;
  ll k = 0;
  REP(i, 0, K + 1) {
    if(i > 0) {
      lower = X - max(lower - (R[i] - R[i - 1]), 0LL);
      upper = X - max(upper - (R[i] - R[i - 1]), 0LL);
      swap(lower, upper);
    }
    sum += (i % 2 == 0 ? 1 : -1) * (R[i] - R[i - 1]);
 
    while(k < Q && R[i] <= T[k] && T[k] <= R[i + 1]) {
      ll a = i % 2 == 0 ? A[k] + sum : X - A[k] - sum;
      if(a <= lower) a = lower;
      if(a >= upper) a = upper;
      cout << (i % 2 == 0 ? max(a - (T[k] - R[i]), 0LL) : X - max(a - (T[k] - R[i]), 0LL)) << endl;
      k++;
    }
  }
}
