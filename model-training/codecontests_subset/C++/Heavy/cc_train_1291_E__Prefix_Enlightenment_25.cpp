#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 5;
const int MAXN = N;
const int mx = 5e5;
const int inf = 1e9;
int arr[MAXN];
vector<int> v1[MAXN];
struct DSU {
  int tot = 0;
  int par[MAXN];
  int cost[MAXN];
  void init() {
    for (int i = 0; i < N; i++) {
      par[i] = i;
      cost[i] = (i % 2 == 0);
    }
    cost[2 * mx] = 0;
    cost[2 * mx + 1] = inf;
    tot = 0;
  }
  int getpar(int a) {
    if (par[a] == a) {
      return a;
    }
    return par[a] = getpar(par[a]);
  }
  void merge(int a, int b, int curr) {
    int a_true = 2 * a;
    int b_true = 2 * b;
    int a_false = 2 * a + 1;
    int b_false = 2 * b + 1;
    a_true = getpar(a_true);
    a_false = getpar(a_false);
    b_true = getpar(b_true);
    b_false = getpar(b_false);
    if (curr) {
      if (a_true == b_true) {
        return;
      }
      tot -= min(cost[a_true], cost[a_false]);
      tot -= min(cost[b_true], cost[b_false]);
      cost[b_true] += cost[a_true];
      cost[b_false] += cost[a_false];
      par[a_true] = b_true;
      par[a_false] = b_false;
    } else {
      if (a_true == b_false) {
        return;
      }
      tot -= min(cost[a_true], cost[a_false]);
      tot -= min(cost[b_true], cost[b_false]);
      cost[b_false] += cost[a_true];
      cost[b_true] += cost[a_false];
      par[a_false] = b_true;
      par[a_true] = b_false;
    }
    tot += min(cost[b_true], cost[b_false]);
  }
} dsu;
int main() {
  int n, k;
  cin >> n >> k;
  string str;
  cin >> str;
  for (int i = 1; i <= n; i++) {
    arr[i] = str[i - 1] - '0';
  }
  for (int i = 1; i <= k; i++) {
    int c;
    cin >> c;
    while (c--) {
      int a;
      cin >> a;
      v1[a].push_back(i);
    }
  }
  dsu.init();
  for (int i = 1; i <= n; i++) {
    if (v1[i].size() == 1) {
      dsu.merge(v1[i][0], mx, arr[i] == 0);
    } else if (v1[i].size() == 2) {
      dsu.merge(v1[i][0], v1[i][1], arr[i] == 1);
    }
    cout << dsu.tot << endl;
  }
}
