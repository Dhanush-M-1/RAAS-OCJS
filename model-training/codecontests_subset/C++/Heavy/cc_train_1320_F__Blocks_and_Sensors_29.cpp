#include <bits/stdc++.h>
using namespace std;
struct pos {
  long long x, y, z, dx, dy, dz, color;
};
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n, m, k;
  cin >> n >> m >> k;
  vector<vector<vector<long long>>> result(
      n, vector<vector<long long>>(m, vector<long long>(k, -1)));
  queue<pos> todo;
  map<tuple<long long, long long, long long>, vector<pos>> done;
  for (long long i = 0; i < m; i++)
    for (long long j = 0; j < k; j++) {
      long long x;
      cin >> x;
      todo.push({0, i, j, 1, 0, 0, x});
    }
  for (long long i = 0; i < m; i++)
    for (long long j = 0; j < k; j++) {
      long long x;
      cin >> x;
      todo.push({n - 1, i, j, -1, 0, 0, x});
    }
  for (long long i = 0; i < n; i++)
    for (long long j = 0; j < k; j++) {
      long long x;
      cin >> x;
      todo.push({i, 0, j, 0, 1, 0, x});
    }
  for (long long i = 0; i < n; i++)
    for (long long j = 0; j < k; j++) {
      long long x;
      cin >> x;
      todo.push({i, m - 1, j, 0, -1, 0, x});
    }
  for (long long i = 0; i < n; i++)
    for (long long j = 0; j < m; j++) {
      long long x;
      cin >> x;
      todo.push({i, j, 0, 0, 0, 1, x});
    }
  for (long long i = 0; i < n; i++)
    for (long long j = 0; j < m; j++) {
      long long x;
      cin >> x;
      todo.push({i, j, k - 1, 0, 0, -1, x});
    }
  while (!todo.empty()) {
    pos p = todo.front();
    todo.pop();
    if (done.find(tuple<long long, long long, long long>{p.x, p.y, p.z}) ==
        done.end())
      done[tuple<long long, long long, long long>{p.x, p.y, p.z}] =
          vector<pos>();
    done[tuple<long long, long long, long long>{p.x, p.y, p.z}].push_back(p);
    if (p.color == 0 ||
        (result[p.x][p.y][p.z] != -1 && result[p.x][p.y][p.z] != p.color)) {
      result[p.x][p.y][p.z] = 0;
      for (pos pp :
           done[tuple<long long, long long, long long>{p.x, p.y, p.z}]) {
        if (pp.x + pp.dx < 0 || pp.x + pp.dx >= n || pp.y + pp.dy < 0 ||
            pp.y + pp.dy >= m || pp.z + pp.dz < 0 || pp.z + pp.dz >= k) {
          if (pp.color != 0) {
            cout << -1 << endl;
            return 0;
          }
        } else {
          todo.push({pp.x + pp.dx, pp.y + pp.dy, pp.z + pp.dz, pp.dx, pp.dy,
                     pp.dz, pp.color});
        }
      }
      done[tuple<long long, long long, long long>{p.x, p.y, p.z}].clear();
    } else if (result[p.x][p.y][p.z] == -1) {
      result[p.x][p.y][p.z] = p.color;
    }
  }
  for (long long a = 0; a < n; a++) {
    for (long long b = 0; b < m; b++) {
      for (long long c = 0; c < k; c++) {
        cout << max(0LL, result[a][b][c]) << " ";
      }
      cout << endl;
    }
    cout << endl;
  }
}
