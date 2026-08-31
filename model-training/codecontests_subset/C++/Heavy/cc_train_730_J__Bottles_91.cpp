#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const long long INF = (1uLL << 63) - 1;
const long long mod = 1e9 + 7;
const double Pi = acos(-1.0);
const int maxn = 1e6 + 5;
struct node {
  int a, b;
} A[105];
bool cmp(node X, node Y) { return X.b > Y.b; }
int dp[105][10005];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, V = 0;
  int Big = 0;
  cin >> n;
  memset(dp, -1, sizeof dp);
  for (int i = 0; i < n; i++) cin >> A[i].a, V += A[i].a;
  for (int i = 0; i < n; i++) cin >> A[i].b, Big += A[i].b;
  sort(A, A + n, cmp);
  int anst = 0;
  int S = 0;
  for (int i = 0; i < n; i++) {
    S += A[i].b;
    if (S >= V) {
      anst = i + 1;
      break;
    }
  }
  dp[0][0] = 0;
  for (int i = 0; i < n; i++) {
    for (int j = anst - 1; j >= 0; j--) {
      for (int v = 10000 - A[i].a; v >= 0; v--) {
        if (dp[j][v] != -1) {
          dp[j + 1][v + A[i].a] = max(dp[j + 1][v + A[i].a], dp[j][v] + A[i].b);
        }
      }
    }
  }
  int ans = 0;
  for (int i = 10000; i >= 0; i--) {
    if (dp[anst][i] >= V) {
      ans = i;
      break;
    }
  }
  cout << anst << " " << V - ans << endl;
}
