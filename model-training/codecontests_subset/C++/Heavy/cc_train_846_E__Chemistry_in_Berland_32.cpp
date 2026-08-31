#include <bits/stdc++.h>
using namespace std;
const int MN = 100000 + 5;
bool Failed;
long long state[MN];
long long need[MN];
struct tEdge {
  int dest, next, rate;
};
tEdge E[MN * 2 + 123];
int Link[MN];
int ee = 0;
void addEdge(int u, int v, int rate) {
  ee++;
  E[ee].dest = v;
  E[ee].next = Link[u];
  Link[u] = ee;
  E[ee].rate = rate;
}
int Parent[MN];
int rate_from_parent[MN];
bool visited[MN];
void Apply(int v);
void DFS(int v, int p) {
  visited[v] = true;
  Parent[v] = p;
  int tmp = Link[v];
  while (tmp > 0) {
    if (E[tmp].dest != p) {
      rate_from_parent[E[tmp].dest] = E[tmp].rate;
      DFS(E[tmp].dest, v);
    }
    tmp = E[tmp].next;
  }
  Apply(v);
}
void Apply(int v) {
  if (Parent[v] == -1) {
    if (state[v] < need[v]) Failed = true;
  } else {
    long double sKa = (need[v] - state[v]);
    sKa *= rate_from_parent[v];
    if (sKa > 1e18) Failed = true;
    if (state[v] < need[v]) {
      state[Parent[v]] -= (need[v] - state[v]) * rate_from_parent[v];
      if (state[Parent[v]] < -1 * 100000LL * 1000000000000LL) Failed = true;
    } else
      state[Parent[v]] += (state[v] - need[v]);
  }
}
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    long long a;
    cin >> a;
    state[i] = a;
  }
  for (int i = 1; i <= n; i++) {
    long long a;
    cin >> a;
    need[i] = a;
  }
  for (int i = 2; i <= n; i++) {
    int k, x;
    cin >> x >> k;
    if (x != i) {
      addEdge(i, x, 1);
      addEdge(x, i, k);
    }
  }
  for (int i = 1; i <= n; i++)
    if (visited[i] == false) DFS(i, -1);
  if (!Failed)
    cout << "YES";
  else
    cout << "NO";
  cout << endl;
}
