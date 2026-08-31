#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 5002;
const int INF = 1000000009;
int N, M;
int A[MAX_N][4], v[MAX_N], ans[MAX_N], a[MAX_N];
int main() {
  cin >> N >> M;
  for (int i = 1; i <= M; ++i) cin >> A[i][0] >> A[i][1] >> A[i][2] >> A[i][3];
  for (int i = 1; i <= N; ++i) a[i] = INF;
  for (int i = 1; i <= M; ++i) {
    int t = A[i][0], x = A[i][1], y = A[i][2], val = A[i][3];
    if (t == 1) {
      for (int j = x; j <= y; ++j) v[j] += val;
    } else {
      for (int j = x; j <= y; ++j)
        if (v[j] + ans[j] > val) {
          ans[j] -= ans[j] + v[j] - val;
          a[j] = ans[j];
        } else if (v[j] + ans[j] < val) {
          int temp = val - v[j] - ans[j];
          if (ans[j] + temp < a[j]) {
            ans[j] += temp;
            a[j] = ans[j];
          }
        }
    }
  }
  bool ok = 1;
  for (int i = 1; i <= N; ++i) v[i] = ans[i];
  for (int i = 1; i <= M; ++i) {
    int t = A[i][0], x = A[i][1], y = A[i][2], val = A[i][3];
    if (t == 1) {
      for (int j = x; j <= y; ++j) v[j] += val;
    } else {
      int maxVal = v[x];
      for (int j = x + 1; j <= y; ++j) maxVal = max(maxVal, v[j]);
      if (maxVal != val) i = M, ok = 0;
    }
  }
  if (ok) {
    cout << "YES\n";
    for (int i = 1; i <= N; ++i) cout << ans[i] << " ";
    cout << "\n";
  } else
    cout << "NO\n";
  return 0;
}
