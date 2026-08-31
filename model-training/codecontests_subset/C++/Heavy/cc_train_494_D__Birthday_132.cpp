#include <bits/stdc++.h>
using namespace std;
const long long N = 100010;
const long long mod = 1e9 + 7;
vector<long long> adj[N], adjed[N];
long long parent[N][18], parentsum[N], edgecost[N], sum[N], sumsq[N],
    counter = 0, sumo[N], sumsqo[N];
long long n, used[N], pin[N], pout[N], size[N];
void dfs(long long node) {
  used[node] = 1;
  size[node] = 1;
  sum[node] = 0;
  sumsq[node] = 0;
  pin[node] = counter++;
  for (long long i = 1; i < 18; ++i) {
    parent[node][i] = parent[parent[node][i - 1]][i - 1];
  }
  long long t;
  for (long long i = 0; i < adj[node].size(); ++i) {
    t = adj[node][i];
    if (used[t] == 0) {
      parent[t][0] = node;
      parentsum[t] = (parentsum[node] + edgecost[adjed[node][i]]) % mod;
      dfs(t);
      size[node] += size[t];
      sum[node] =
          (sum[node] + sum[t] + size[t] * edgecost[adjed[node][i]]) % mod;
      sumsq[node] = (sumsq[node] + sumsq[t] +
                     (2 * ((sum[t] * edgecost[adjed[node][i]]) % mod))) %
                    mod;
      sumsq[node] =
          (sumsq[node] +
           (size[t] *
            ((edgecost[adjed[node][i]] * edgecost[adjed[node][i]]) % mod)) %
               mod) %
          mod;
    }
  }
  pout[node] = counter++;
}
void dfs2(long long node, long long s, long long sq, long long t) {
  used[node] = 1;
  sumo[node] = (s - sum[node] + ((n - 2 * size[node]) * t) % mod) % mod;
  sumsqo[node] = (sq - sumsq[node] - (size[node] * ((t * t) % mod)) % mod -
                  2 * ((sum[node] * t) % mod)) %
                 mod;
  sumsqo[node] =
      (sumsqo[node] + ((n - size[node]) * ((t * t) % mod)) % mod +
       (2 * ((t * (sumo[node] - ((n - size[node]) * t) % mod)) % mod)) % mod) %
      mod;
  long long m;
  for (long long i = 0; i < adj[node].size(); ++i) {
    m = adj[node][i];
    if (used[m] == 0) {
      dfs2(m, (sumo[node] + sum[node]) % mod,
           (sumsq[node] + sumsqo[node]) % mod, edgecost[adjed[node][i]]);
    }
  }
}
long long ancestor(long long A, long long b) {
  if (pin[A] <= pin[b] && pout[b] <= pout[A]) return 1;
  return 0;
}
long long go_up(long long A, long long b) {
  for (long long i = 18 - 1; i >= 0; i--) {
    if (!ancestor(parent[A][i], b)) {
      A = parent[A][i];
    }
  }
  return A;
}
long long LCA(long long A, long long b) {
  long long result = -1;
  if (ancestor(A, b)) {
    result = A;
  } else if (ancestor(b, A)) {
    result = b;
  } else {
    result = parent[go_up(A, b)][0];
  }
  return result;
}
int main() {
  scanf("%lld", &n);
  long long x, y, cost;
  for (long long i = 0; i < n - 1; ++i) {
    scanf("%lld %lld %lld", &x, &y, &cost);
    adj[x].push_back(y);
    adj[y].push_back(x);
    adjed[x].push_back(i);
    adjed[y].push_back(i);
    edgecost[i] = cost;
  }
  memset(used, 0, sizeof(used));
  parent[1][0] = 1;
  parentsum[1] = 0;
  used[1] = 1;
  dfs(1);
  memset(used, 0, sizeof(used));
  dfs2(1, sum[1], sumsq[1], 0);
  long long q, u, v;
  scanf("%lld", &q);
  for (long long i = 0; i < q; ++i) {
    scanf("%lld %lld", &u, &v);
    long long p = LCA(u, v);
    long long s, ans = 0,
                 l = (parentsum[u] + parentsum[v] - 2 * parentsum[p]) % mod;
    y = (ancestor(v, u)) ? 1 : -1;
    if (y == -1) {
      s = (sumsq[v] + 2 * (sum[v] * l) % mod +
           (size[v] * ((l * l) % mod)) % mod) %
          mod;
      ans = (ans + s - (sumsqo[u] + sumsq[u] - s)) % mod;
    } else {
      s = (sumsqo[v] + 2 * ((sumo[v] * l) % mod) +
           ((n - size[v]) * ((l * l) % mod)) % mod) %
          mod;
      ans = (ans - s + (sumsqo[u] + sumsq[u] - s)) % mod;
    }
    printf("%lld\n", (ans + mod) % mod);
  }
  return 0;
}
