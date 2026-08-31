#include <bits/stdc++.h>
using namespace std;
inline int add(int _a, int _b) {
  if (_a < 0) {
    _a += 1000000007;
  }
  if (_b < 0) {
    _b += 1000000007;
  }
  if (_a + _b >= 1000000007) {
    return _a + _b - 1000000007;
  }
  return _a + _b;
}
inline int mul(int _a, int _b) {
  if (_a < 0) {
    _a += 1000000007;
  }
  if (_b < 0) {
    _b += 1000000007;
  }
  return ((long long int)((long long int)_a * (long long int)_b)) % 1000000007;
}
const int N = 75;
namespace wm {
bool vis[N + 5];
int U[N + 5], V[N + 5], P[N + 5], way[N + 5], minv[N + 5], match[N + 5],
    ar[N + 5][N + 5];
int hungarian(int n, int m, int mat[N + 5][N + 5], int flag) {
  memset(U, 0, sizeof(U)), memset(V, 0, sizeof(V)), memset(P, 0, sizeof(P)),
      memset(ar, 0, sizeof(ar)), memset(way, 0, sizeof(way));
  int i, j;
  for (i = 1; i <= n; i++) {
    for (j = 1; j <= m; j++) {
      ar[i][j] = mat[i][j];
      if (flag == +1) ar[i][j] = -ar[i][j];
    }
  }
  if (n > m) m = n;
  int a, b, c, d, r, w;
  for (i = 1; i <= n; i++) {
    P[0] = i, b = 0;
    for (j = 0; j < m + 1; j++) minv[j] = INT_MAX, vis[j] = 0;
    do {
      vis[b] = 1;
      a = P[b], d = 0, w = INT_MAX;
      for (j = 1; j <= m; j++) {
        if (!vis[j]) {
          r = ar[a][j] - U[a] - V[j];
          if (r < minv[j]) minv[j] = r, way[j] = b;
          if (minv[j] < w) w = minv[j], d = j;
        }
      }
      for (j = 0; j < m + 1; j++) {
        if (vis[j])
          U[P[j]] += w, V[j] -= w;
        else
          minv[j] -= w;
      }
      b = d;
    } while (P[b] != 0);
    do {
      d = way[b];
      P[b] = P[d], b = d;
    } while (b != 0);
  }
  for (j = 1; j <= m; j++) match[j] = P[j];
  return (flag == +1) ? V[0] : -V[0];
}
}  // namespace wm
int n, A[N + 5], B[N + 5], choice, mat[N + 5][N + 5];
void solve() {
  int i, j;
  for (i = 0; i < n; i++)
    for (j = 0; j < n; j++) {
      if (j < choice - 1)
        mat[i + 1][j + 1] = A[i] + j * B[i];
      else if (j >= choice - 1 && j < n - 1)
        mat[i + 1][j + 1] = (choice - 1) * B[i];
      else
        mat[i + 1][j + 1] = A[i] + (choice - 1) * B[i];
    }
  int sol = wm ::hungarian(n, n, mat, +1);
  printf("%d", choice - 1 + 2 * (n - choice) + 1), puts("");
  vector<int> vec;
  for (i = 1; i <= choice - 1; i++) vec.push_back(wm ::match[i]);
  for (i = choice; i <= n - 1; ++i)
    vec.push_back(wm ::match[i]), vec.push_back(-wm ::match[i]);
  vec.push_back(wm ::match[n]);
  for (i = 0; i < vec.size(); i++) {
    if (i) printf(" ");
    printf("%d", vec[i]);
  }
  puts("");
}
int main() {
  int cs, ts;
  scanf("%d", &ts);
  for (cs = 0; cs < ts; cs++) {
    int i, j;
    scanf("%d %d", &n, &choice);
    for (i = 0; i < n; i++) scanf("%d %d", &A[i], &B[i]);
    solve();
  }
}
