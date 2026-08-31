#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma GCC target("sse4")
using namespace std;
const double PI = acos(-1.0);
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
long long MinCostMatching(const vector<vector<long long>> &cost,
                          vector<long long> &Lmate, vector<long long> &Rmate) {
  long long n = (long long)(cost.size());
  vector<long long> u(n);
  vector<long long> v(n);
  for (long long i = 0; i < n; i++) {
    u[i] = cost[i][0];
    for (long long j = 1; j < n; j++) {
      u[i] = min(u[i], cost[i][j]);
    }
  }
  for (long long j = 0; j < n; j++) {
    v[j] = cost[0][j] - u[0];
    for (long long i = 1; i < n; i++) {
      v[j] = min(v[j], cost[i][j] - u[i]);
    }
  }
  Lmate = vector<long long>(n, -1);
  Rmate = vector<long long>(n, -1);
  long long mated = 0;
  for (long long i = 0; i < n; i++) {
    for (long long j = 0; j < n; j++) {
      if (Rmate[j] != -1) {
        continue;
      }
      if (abs(cost[i][j] - u[i] - v[j]) == 0) {
        Lmate[i] = j;
        Rmate[j] = i;
        mated++;
        break;
      }
    }
  }
  vector<long long> dist(n);
  vector<long long> dad(n);
  vector<long long> seen(n);
  while (mated < n) {
    long long s = 0;
    while (Lmate[s] != -1) {
      s++;
    }
    fill(dad.begin(), dad.end(), -1);
    fill(seen.begin(), seen.end(), 0);
    for (long long k = 0; k < n; k++) {
      dist[k] = cost[s][k] - u[s] - v[k];
    }
    long long j = 0;
    while (true) {
      j = -1;
      for (long long k = 0; k < n; k++) {
        if (seen[k]) {
          continue;
        }
        if (j == -1 || dist[k] < dist[j]) {
          j = k;
        }
      }
      seen[j] = 1;
      if (Rmate[j] == -1) {
        break;
      }
      const long long i = Rmate[j];
      for (long long k = 0; k < n; k++) {
        if (seen[k]) {
          continue;
        }
        const long long new_dist = dist[j] + cost[i][k] - u[i] - v[k];
        if (dist[k] > new_dist) {
          dist[k] = new_dist;
          dad[k] = j;
        }
      }
    }
    for (long long k = 0; k < n; k++) {
      if (k == j || !seen[k]) {
        continue;
      }
      const long long i = Rmate[k];
      v[k] += dist[k] - dist[j];
      u[i] -= dist[k] - dist[j];
    }
    u[s] += dist[j];
    while (dad[j] >= 0) {
      const long long d = dad[j];
      Rmate[j] = Rmate[d];
      Lmate[Rmate[j]] = j;
      j = d;
    }
    Rmate[j] = s;
    Lmate[s] = j;
    mated++;
  }
  long long value = 0;
  for (long long i = 0; i < n; i++) {
    value += cost[i][Lmate[i]];
  }
  return value;
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long t;
  cin >> t;
  while (t--) {
    long long n, k;
    cin >> n >> k;
    long long a[n + 5], b[n + 5];
    for (long long i = 0; i < n; i++) {
      cin >> a[i] >> b[i];
    }
    vector<vector<long long>> mat(n, vector<long long>(n, 0));
    for (long long i = 0; i < (k - 1); i++) {
      for (long long j = 0; j < n; j++) {
        long long pft = a[j] + min(i, k - 1) * b[j];
        mat[i][j] = -pft;
      }
    }
    for (long long i = k - 1; i < n - 1; i++) {
      for (long long j = 0; j < n; j++) {
        long long pft = min(i, k - 1) * b[j];
        mat[i][j] = -pft;
      }
    }
    for (long long j = 0; j < n; j++) {
      long long i = n - 1;
      long long pft = a[j] + min(i, k - 1) * b[j];
      mat[i][j] = -pft;
    }
    vector<long long> l, r;
    long long pft = -MinCostMatching(mat, l, r);
    cerr << "pft"
         << "=" << pft << "\n";
    cout << k + 2 * (n - k) << "\n";
    for (long long i = 0; i < k - 1; i++) {
      cout << l[i] + 1 << " ";
    }
    for (long long i = k - 1; i < n - 1; i++) {
      cout << l[i] + 1 << " ";
      cout << -l[i] - 1 << " ";
    }
    cout << l[n - 1] + 1 << " ";
    cout << "\n";
  }
}
