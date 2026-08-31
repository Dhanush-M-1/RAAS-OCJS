#include <bits/stdc++.h>
using namespace std;
struct _ {
  ios_base::Init i;
  _() {
    cin.sync_with_stdio(0);
    cin.tie(0);
  }
} _;
vector<bool> isOnC;
struct Edge {
  int a, b;
};
int t, k;
int n;
int temp = -1;
int cLength = 0;
vector<bool> isMarked;
vector<vector<int> > e;
vector<vector<int> > dist;
double sum = 0.0;
int source = -1;
void dfs(int a, int d, int cD) {
  if (dist[source][a] == -1) {
    dist[source][a] = d;
    dist[a][source] = d;
    int x, y, z;
    if (cD >= 2) {
      x = d - cD + 2;
      y = cD - 2;
      z = cLength - cD;
    } else {
      x = d;
      y = z = 0;
    }
    double t = 2.0;
    if (source == a) t = 1.0;
    ;
    ;
    ;
    ;
    sum += t * (1.0 / (x + y) + 1.0 / (x + z) - 1.0 / (x + y + z));
  }
  isMarked[a] = true;
  for (int i = 0; i < e[a].size(); ++i) {
    if (!isMarked[e[a][i]]) {
      dfs(e[a][i], d + 1, cD + isOnC[e[a][i]]);
    }
  }
}
void findCycle(int p, int a) {
  if (isMarked[a]) {
    isOnC[a] = true;
    temp = a;
    ;
    cLength++;
    return;
  }
  isMarked[a] = true;
  for (int i = 0; i < e[a].size(); ++i) {
    if (e[a][i] != p) findCycle(a, e[a][i]);
    if (temp == a) {
      temp = -1;
      return;
    } else if (temp != -1) {
      ;
      ++cLength;
      isOnC[a] = true;
      return;
    }
  }
}
int main() {
  cin >> n;
  isOnC.assign(n, false);
  e.assign(n, vector<int>());
  int a, b;
  for (int i = 0; i < n; ++i) {
    cin >> a >> b;
    e[a].push_back(b);
    e[b].push_back(a);
  }
  isMarked.assign(n, false);
  temp = -1;
  findCycle(-1, 0);
  dist.assign(n, vector<int>(n, -1));
  for (int i = 0; i < n; ++i) {
    source = i;
    isMarked.assign(n, false);
    dfs(i, 1, isOnC[i]);
  }
  cout << fixed << setprecision(8) << sum << endl;
  return 0;
}
