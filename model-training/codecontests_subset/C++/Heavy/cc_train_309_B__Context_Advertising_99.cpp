#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1000010;
int N, R, C;
int A[MAXN], MR[MAXN];
string s[MAXN];
int mt[MAXN], mlv[MAXN][20];
void printAd(int x) {
  int i, j;
  for (i = 1; i <= R; i++) {
    for (j = x; j <= mt[x] - 1; j++) {
      if (j != x) putchar(' ');
      cout << s[j];
    }
    cout << endl;
    x = mt[x];
    if (x > N) break;
  }
}
int main() {
  scanf("%d%d%d", &N, &R, &C);
  int i, k;
  for (i = 1; i <= N; i++) {
    cin >> s[i];
    A[i] = s[i].size() + 1;
  }
  int Sum = -1, r = 1;
  for (i = 1; i <= N; i++) {
    while ((r <= N) && (Sum + A[r] <= C)) Sum += A[r++];
    mt[i] = r;
    Sum -= A[i];
  }
  mt[N + 1] = N + 1;
  for (i = 1; i <= N + 1; i++) mlv[i][0] = mt[i];
  for (k = 1; k <= 19; k++)
    for (i = 1; i <= N + 1; i++) mlv[i][k] = mlv[mlv[i][k - 1]][k - 1];
  int ans = 0;
  for (i = 1; i <= N; i++) {
    MR[i] = i;
    for (int t = R; t; t -= (t & -t)) MR[i] = mlv[MR[i]][__builtin_ctz(t)];
    ans = max(ans, MR[i] - i);
  }
  for (i = 1; i <= N; i++)
    if (ans == MR[i] - i) {
      printAd(i);
      return 0;
    }
}
