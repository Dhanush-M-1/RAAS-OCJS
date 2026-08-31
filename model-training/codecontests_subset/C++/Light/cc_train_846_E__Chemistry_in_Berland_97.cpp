#include <bits/stdc++.h>
#pragma warning(disable : 4996)
#pragma comment(linker, "/STACK:336777216")
using namespace std;
int IT_MAX = 1 << 15;
const long long MOD = 1000000007;
const int INF = 0x3f3f3f3f;
const long long LL_INF = 0x3f3f3f3f3f3f3f3f;
const double PI = acos(-1);
const double ERR = 1e-10;
long long mymul(long long a, long long b) {
  bool c = false;
  if (a < 0) {
    a *= -1;
    c = true;
  }
  if (b < 0) {
    b *= -1;
    c = !c;
  }
  long long rv;
  if ((2 * LL_INF) / b < a)
    rv = 2 * LL_INF;
  else
    rv = min(a * b, 2 * LL_INF);
  if (c) rv *= -1;
  return rv;
}
vector<pair<long long, long long> > son[100050];
long long B[100050];
long long A[100050];
long long in[100050];
long long par[100050][2];
void DFS(int n) {
  for (auto it : son[n]) DFS(it.second);
  if (in[n] < 0) {
    if (n == 1) {
      printf("NO\n");
      exit(0);
    }
    int t1 = par[n][0], t2 = par[n][1];
    in[t1] -= mymul(-in[n], t2);
    if (in[t1] < -LL_INF) {
      printf("NO\n");
      exit(0);
    }
  } else {
    int t1 = par[n][0], t2 = par[n][1];
    in[t1] += in[n];
  }
}
int main() {
  int N, i;
  scanf("%d", &N);
  for (i = 1; i <= N; i++) scanf("%lld", &B[i]);
  for (i = 1; i <= N; i++) scanf("%lld", &A[i]);
  for (i = 2; i <= N; i++) {
    int t1, t2;
    scanf("%d %d", &t1, &t2);
    son[t1].emplace_back(t2, i);
    par[i][0] = t1, par[i][1] = t2;
  }
  for (i = 1; i <= N; i++) in[i] = B[i] - A[i];
  DFS(1);
  return !printf("YES\n");
}
