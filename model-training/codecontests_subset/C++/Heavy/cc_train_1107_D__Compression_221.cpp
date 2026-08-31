#include <bits/stdc++.h>
using namespace std;
template <typename T1, typename T2>
inline void chmin(T1& a, T2 b) {
  if (a > b) a = b;
}
template <typename T1, typename T2>
inline void chmax(T1& a, T2 b) {
  if (a < b) a = b;
}
const int MOD = 998244353;
const int MAX = 200020;
const double pi = acos(-1);
const double EPS = 1e-12;
const long long INF = 2e18;
int A[5252][5252];
void solve() {
  int N;
  cin >> N;
  for (int i = 0; i < N; ++i) {
    string S;
    cin >> S;
    vector<int> v;
    for (int j = 0; j < N / 4; ++j) {
      int num = (S[j] <= '9') ? S[j] - '0' : 10 + S[j] - 'A';
      for (int k = 4 - 1; k >= 0; --k) v.push_back((num & (1 << k)) ? 1 : 0);
    }
    for (int j = 0; j < v.size(); ++j) {
      A[i + 1][j + 1] = v[j];
    }
  }
  for (int i = 1; i < N + 1; ++i) {
    for (int j = 1; j < N + 1; ++j) {
      A[i][j] += A[i - 1][j] + A[i][j - 1] - A[i - 1][j - 1];
    }
  }
  vector<int> divs;
  for (int i = N; i >= 1; i--) {
    if (N % i == 0) divs.push_back(i);
  }
  for (auto p : divs) {
    bool ok = true;
    for (int i = 0; i < N; i += p) {
      for (int j = 0; j < N; j += p) {
        int sum = A[i + p][j + p] + A[i][j] - A[i + p][j] - A[i][j + p];
        if (sum != 0 && sum != p * p) goto END;
      }
    }
    cout << (p) << '\n';
    return;
  END:;
  }
}
signed main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  solve();
}
