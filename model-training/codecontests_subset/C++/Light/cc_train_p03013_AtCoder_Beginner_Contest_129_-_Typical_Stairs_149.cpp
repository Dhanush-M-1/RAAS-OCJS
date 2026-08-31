#include <cstdio>
using namespace std;
const int L = 1000000007;
int N, M, t, a[100001], dp[100001];
int main() {
  scanf("%d %d", &N, &M);
  for(int i = 0; i < M; i++) {scanf("%d", &t); a[t] = 1;};
  dp[0] = 1, dp[1] = !a[1];
  for(int i = 2; i <= N; i++) {
    if(a[i]) {dp[i] = 0; continue;}
    dp[i] = (dp[i-1]+dp[i-2])%L;
  }
  printf("%d", dp[N]);
}