#include <bits/stdc++.h>
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,avx,avx2")
using namespace std;
template <class T>
bool umin(T& a, T b) {
  if (a > b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
bool umax(T& a, T b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
int a[101001];
vector<int> positions[101010];
int tr[404040];
int b[101010];
int dp[404040];
long long getSum(int* b, int* dp, int n) {
  long long res = 0;
  for (int j = 0; j < n; ++j) {
    res += b[j] > 0 ? 0 : dp[j];
  }
  return res;
}
const int fftmod = 998244353;
int main() {
  int n, k;
  cin >> n >> k;
  for (int i = 0; i < (n); ++i) {
    b[i] -= k;
  }
  for (int i = 0; i < (n); ++i) {
    cin >> a[i];
    --a[i];
    positions[i].push_back(-1);
    positions[i].push_back(-1);
  }
  dp[0] = 1;
  for (int i = 0; i < n; ++i) {
    int x = a[i];
    {
      int to = positions[x].back();
      int from = *++positions[x].rbegin() + 1;
      for (int j = from; j <= to; ++j) {
        b[j]--;
      }
    }
    int from = positions[x].back() + 1;
    for (int j = from; j <= i; ++j) {
      b[j]++;
    }
    long long res = 0;
    for (int j = 0; j < i + 1; ++j) res += b[j] > 0 ? 0 : dp[j];
    dp[i + 1] = res % fftmod;
    positions[x].push_back(i);
  }
  cout << dp[n] << endl;
  return 0;
}
