#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e5 + 5;
long long a[MAX], b[MAX], k[MAX];
vector<int> adj[MAX];
int parent[MAX];
int n;
void die() {
  puts("NO");
  exit(0);
}
inline bool overflow(long long a, long long b) {
  return a >= (long long)1e18 / b;
}
void dfs(int source) {
  for (auto &each : adj[source]) {
    dfs(each);
  }
  if (b[source] > a[source]) {
    b[parent[source]] += b[source] - a[source];
    b[source] = a[source];
  } else if (source > 1) {
    long long need = a[source] - b[source];
    b[source] = a[source];
    if (overflow(need, k[source])) {
      die();
    }
    b[parent[source]] -= need * k[source];
    if (b[parent[source]] <= (long long)-1e18) {
      die();
    }
  }
}
int main() {
  scanf("%d", &n);
  long long sum_b = 0, sum_a = 0;
  for (int i = int(1); i < int(n + 1); i++) {
    scanf("%lld", b + i);
    sum_b += b[i];
  }
  for (int i = int(1); i < int(n + 1); i++) {
    scanf("%lld", a + i);
    sum_a += a[i];
  }
  if (sum_a > sum_b) {
    puts("NO");
    return 0;
  }
  for (int i = int(2); i < int(n + 1); i++) {
    scanf("%d %lld", parent + i, k + i);
    adj[parent[i]].push_back(i);
  }
  dfs(1);
  bool ok = true;
  for (int i = int(1); i < int(n + 1); i++) {
    if (a[i] > b[i]) {
      ok = false;
    }
  }
  puts(ok ? "YES" : "NO");
  return 0;
}
