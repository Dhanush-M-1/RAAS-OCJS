#include <bits/stdc++.h>
using namespace std;
int read() {
  int res = 0;
  char ch = 0;
  bool f = false;
  do f = ch == 45;
  while (!isdigit(ch = getchar()));
  for (; isdigit(ch); ch = getchar()) (res *= 10) += ch - 48;
  return f ? -res : res;
}
using IPair = array<int, 2>;
bool operator<(const IPair& lhs, const IPair& rhs) {
  return lhs[0] * rhs[1] == rhs[0] * lhs[1] ? lhs[1] < rhs[1]
                                            : lhs[0] * rhs[1] < rhs[0] * lhs[1];
}
const int maxN = 300010;
vector<int> G[maxN];
IPair dp[maxN][2];
int w[maxN];
int n;
void dfs(int u, int from) {
  dp[u][0] = {INT_MIN, 0};
  dp[u][1] = {w[u], 1};
  for (const int v : G[u]) {
    if (v == from) continue;
    dfs(v, u);
    IPair t1 = {dp[v][0][0] + w[u], dp[v][0][1] + 1};
    IPair t2 = {dp[v][1][0] + dp[u][1][0], dp[v][1][1]};
    IPair t3 = {dp[v][1][0] + dp[u][1][0], dp[v][1][1] + 1};
    if (dp[u][1] < t1) dp[u][1] = t1;
    if (dp[u][1] < t2) dp[u][1] = t2;
    if (dp[u][1] < t3) dp[u][1] = t3;
    if (dp[u][0] < dp[v][0]) dp[u][0] = dp[v][0];
    if (dp[u][0] < dp[v][1]) dp[u][0] = dp[v][1];
  }
}
int prea = 0, preb = 0;
int a[36];
void fun0(int t) {
  for (int i = 0; i < t; i++) {
    int tmp;
    cout << "? " << prea + a[i] << " " << preb << endl << flush;
    cin >> tmp;
    if (tmp == -1) {
      prea += a[i];
      preb += a[i];
    }
  }
  cout << "! " << prea << " " << preb << endl << flush;
}
int fun1(int x) {
  int tmp;
  cout << "? " << prea + a[x] << " " << preb + a[x] << endl << flush;
  cin >> tmp;
  if (tmp == 1) {
    int tmp2;
    cout << "? " << prea << " " << preb + a[x] << endl << flush;
    cin >> tmp2;
    if (tmp2 == 1) {
      prea += a[x];
      preb += a[x];
      return 1;
    }
    if (tmp2 == -1) {
      return 1;
    }
  }
  if (tmp == -1) {
    int tmp2;
    prea += a[x];
    cout << "? " << prea << " " << preb << endl << flush;
    cin >> tmp2;
    return tmp2;
  }
}
int fun2(int x) {
  int tmp;
  cout << "? " << prea + a[x] << " " << preb + a[x] << endl << flush;
  cin >> tmp;
  if (tmp == -1) {
    int tmp2;
    cout << "? " << prea + a[x] << " " << preb << endl << flush;
    cin >> tmp2;
    if (tmp2 == -1) {
      prea += a[x];
      preb += a[x];
      return -1;
    }
    if (tmp2 == 1) {
      return -1;
    }
  }
  if (tmp == 1) {
    int tmp2;
    preb += a[x];
    cout << "? " << prea << " " << preb << endl << flush;
    cin >> tmp2;
    return tmp2;
  }
}
signed main() {
  a[0] = 1;
  for (int i = 1; i < 30; i++) a[i] = a[i - 1] + a[i - 1];
  int tmp;
  cout << "? 0 0" << endl << flush;
  cin >> tmp;
  if (tmp == 0) {
    fun0(30);
    return 0;
  } else {
    for (int i = 29; i >= 0; i--) {
      if (tmp == 0) {
        fun0(i + 1);
        return 0;
      }
      if (tmp == 1)
        tmp = fun1(i);
      else
        tmp = fun2(i);
    }
    fun0(0);
  }
  return 0;
}
