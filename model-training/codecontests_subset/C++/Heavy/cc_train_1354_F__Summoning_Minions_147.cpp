#include <bits/stdc++.h>
using namespace std;
template <typename T>
ostream &operator<<(ostream &os, const vector<T> &v) {
  os << '{';
  string sep;
  for (const auto &x : v) os << sep << x, sep = ", ";
  return os << '}';
}
template <typename A, typename B>
ostream &operator<<(ostream &os, const pair<A, B> &p) {
  return os << '(' << p.first << ", " << p.second << ')';
}
void dbg_out() { cerr << endl; }
template <typename Head, typename... Tail>
void dbg_out(Head H, Tail... T) {
  cerr << ' ' << H;
  dbg_out(T...);
}
template <typename T>
void output_vector(const vector<T> &v, bool add_one = false, int start = -1,
                   int end = -1) {
  if (start < 0) start = 0;
  if (end < 0) end = int(v.size());
  for (int i = start; i < end; i++)
    cout << v[i] + (add_one ? 1 : 0) << (i < end - 1 ? ' ' : '\n');
}
const int64_t INF64 = int64_t(2e18) + 5;
vector<int> assignment;
template <typename T>
int64_t hungarian(vector<vector<T>> costs) {
  int n = int(costs.size());
  int m = costs.empty() ? 0 : int(costs[0].size());
  if (n > m) {
    vector<vector<T>> new_costs(m, vector<T>(n));
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++) new_costs[j][i] = costs[i][j];
    swap(costs, new_costs);
    swap(n, m);
  }
  vector<int64_t> u(n + 1), v(m + 1);
  vector<int> p(m + 1), way(m + 1);
  for (int i = 1; i <= n; i++) {
    vector<int64_t> min_v(m + 1, INF64);
    vector<bool> used(m + 1, false);
    p[0] = i;
    int j0 = 0;
    do {
      used[j0] = true;
      int i0 = p[j0], j1 = 0;
      int64_t delta = INF64;
      for (int j = 1; j <= m; j++)
        if (!used[j]) {
          int64_t cur = costs[i0 - 1][j - 1] - u[i0] - v[j];
          if (cur < min_v[j]) {
            min_v[j] = cur;
            way[j] = j0;
          }
          if (min_v[j] < delta) {
            delta = min_v[j];
            j1 = j;
          }
        }
      for (int j = 0; j <= m; j++)
        if (used[j]) {
          u[p[j]] += delta;
          v[j] -= delta;
        } else {
          min_v[j] -= delta;
        }
      j0 = j1;
    } while (p[j0] != 0);
    do {
      int j1 = way[j0];
      p[j0] = p[j1];
      j0 = j1;
    } while (j0 != 0);
  }
  assignment = p;
  return -v[0];
}
void run_case() {
  int N, K;
  cin >> N >> K;
  vector<int> A(N), B(N);
  for (int i = 0; i < N; i++) cin >> A[i] >> B[i];
  vector<vector<int>> costs(N, vector<int>(N, 0));
  for (int i = 0; i < N; i++)
    for (int position = 0; position < N; position++)
      if (position < K)
        costs[i][position] = -(A[i] + position * B[i]);
      else
        costs[i][position] = -((K - 1) * B[i]);
  int64_t score = -hungarian(costs);
  ;
  vector<int> solution;
  for (int k = 1; k < K; k++) solution.push_back(assignment[k]);
  for (int k = K + 1; k <= N; k++) {
    solution.push_back(assignment[k]);
    solution.push_back(-assignment[k]);
  }
  solution.push_back(assignment[K]);
  assert(int(solution.size()) == 2 * N - K);
  cout << solution.size() << '\n';
  output_vector(solution);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int tests;
  cin >> tests;
  while (tests-- > 0) run_case();
}
