#include <bits/stdc++.h>
using namespace std;
const int MAX = 1 << 18;
const int ITER = 60;
vector<int> V[MAX];
int good[MAX];
int n, m;
int col[MAX];
bool dfs(int node) {
  col[node] = 1;
  for (auto it : V[node]) {
    if (col[it] == 0) {
      if (!dfs(it)) return false;
    } else if (col[it] == 2)
      return false;
  }
  col[node] = 2;
  return true;
}
bool check(int root) {
  for (int i = (0); i < (n); i++) col[i] = 0;
  if (!dfs(root)) return false;
  for (int i = (0); i < (n); i++)
    if (!col[i]) return false;
  return true;
}
pair<int, int> links[MAX];
int dub[MAX];
void dfs_calc(int node) {
  col[node] = 1;
  for (auto it : V[node]) {
    if (col[it] == 0) {
      dub[it] = dub[node] + 1;
      dfs_calc(it);
      vector<int> T = vector<int>{links[node].first, links[node].second,
                                  links[it].first, links[it].second};
      sort(T.begin(), T.end(), [](int a, int b) {
        if (a == MAX || b == MAX) return a < b;
        return dub[a] < dub[b];
      });
      if (T[0] < n && dub[T[0]] < dub[node]) links[node].first = T[0];
      if (T[1] < n && dub[T[1]] < dub[node]) links[node].second = T[1];
    } else {
      assert(col[it] == 1);
      vector<int> T = vector<int>{links[node].first, links[node].second, it};
      sort(T.begin(), T.end(), [](int a, int b) {
        if (a == MAX || b == MAX) return a < b;
        return dub[a] < dub[b];
      });
      if (T[0] < n && dub[T[0]] < dub[node]) links[node].first = T[0];
      if (T[1] < n && dub[T[1]] < dub[node]) links[node].second = T[1];
    }
  }
  col[node] = 2;
}
int per[MAX];
void calc(int root) {
  for (int i = (0); i < (n); i++) {
    col[i] = 0;
    links[i] = pair<int, int>(MAX, MAX);
  }
  dub[root] = 0;
  dfs_calc(root);
  for (int i = (0); i < (n); i++) per[i] = i;
  good[root] = 1;
  sort(per, per + n, [](int a, int b) { return dub[a] < dub[b]; });
  for (int iii = (1); iii < (n); iii++) {
    int i = per[iii];
    if (links[i].second == MAX && links[i].first < n && good[links[i].first])
      good[i] = 1;
  }
  good[root] = 1;
}
int main() {
  srand(1341);
  int tt;
  scanf("%d", &tt);
  while (tt--) {
    scanf("%d%d", &n, &m);
    for (int i = (0); i < (m); i++) {
      int a, b;
      scanf("%d%d", &a, &b);
      a--;
      b--;
      V[a].push_back(b);
    }
    if (m < n - 1) {
      for (int i = (0); i < (n); i++) V[i].clear();
      printf("-1\n");
      continue;
    }
    int yes = 0;
    for (int i = (0); i < (n); i++) good[i] = 0;
    for (int i = (0); i < (ITER); i++) {
      int root = (int)(((((long long)rand()) << 15) + rand()) % n);
      if (check(root)) {
        calc(root);
        if (accumulate(good, good + n, 0) * 5 < n)
          printf("-1");
        else
          for (int j = (0); j < (n); j++)
            if (good[j]) printf("%d ", j + 1);
        printf("\n");
        yes = 1;
        break;
      }
    }
    for (int i = (0); i < (n); i++) V[i].clear();
    if (!yes) printf("-1\n");
  }
  return 0;
}
