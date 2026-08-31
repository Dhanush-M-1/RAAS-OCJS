#include <bits/stdc++.h>
using namespace std;
long long int dxk[] = {0, 0, 1, -1, 1, 1, -1, -1};
long long int dyk[] = {1, -1, 0, 0, 1, -1, 1, -1};
long long int ll_max(long long int a, long long int b, long long int c) {
  return max(a, max(b, c));
}
int int_max(int a, int b, int c) { return max(a, max(b, c)); }
long long int ll_min(long long int a, long long int b, long long int c) {
  return min(a, min(b, c));
}
int int_min(int a, int b, int c) { return min(a, min(b, c)); }
long long int max(int a, long long int b) { return max((long long int)a, b); }
long long int min(int a, long long int b) { return min((long long int)a, b); }
long long int min(long long int a, int b) { return min(a, (long long int)b); }
long long int max(long long int a, int b) { return max(a, (long long int)b); }
long long int dx[] = {0, 0, 1, -1};
long long int dy[] = {1, -1, 0, 0};
long long int power(long long int a, long long int b) {
  if (a == 1) return 1;
  if (b == 0) return 1;
  long long int c = power(a, b / 2);
  long long int res = 1;
  if (b % 2) {
    res = (c * c) % 1000000007;
    res *= a;
    res %= 1000000007;
  } else
    res = ((c * c) % 1000000007);
  return res;
}
long long int modInv(long long int a) {
  return power(a, 1000000007 - 2) % 1000000007;
}
long long int fact[1], inv[1];
void factorial(long long int n) {
  fact[0] = 1;
  for (long long int i = 1; i <= n; i++) {
    fact[i] = fact[i - 1] * i;
    fact[i] %= 1000000007;
  }
}
void InvFactorial(long long int n) {
  inv[0] = 1;
  for (long long int i = 1; i <= n; i++) inv[i] = modInv(fact[i]);
}
long long int ncr(long long int n, long long int r) {
  if (n < r || n < 0 || r < 0) return 0;
  long long int b = inv[n - r];
  long long int c = inv[r];
  long long int a = fact[n] * b;
  a %= 1000000007;
  a *= c;
  a %= 1000000007;
  return a;
}
bool visited[200001];
vector<int> v[200001];
int par[200001];
int size;
int t;
void dfs(int i) {
  size++;
  visited[i] = 1;
  for (long long int j = 0; j < v[i].size(); j++) {
    if (par[v[i][j]] != -1 && par[v[i][j]] != t) t = -1;
    if (visited[v[i][j]]) continue;
    dfs(v[i][j]);
  }
}
void solve(int countu) {
  int n, m, a, b;
  cin >> n >> m >> a >> b;
  if (a > b) swap(a, b);
  for (long long int i = 1; i < n + 1; i++) {
    v[i].clear();
    par[i] = -1;
  }
  for (long long int i = 1; i < n + 1; i++) visited[i] = 0;
  queue<int> q, q1;
  for (long long int i = 0; i < m; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    if (x > y) swap(x, y);
    if (x == a && y == b) continue;
    if (x == a) {
      if (visited[y]) continue;
      if (par[y] == b) {
        visited[y] = 1;
        par[y] = -2;
        continue;
      }
      par[y] = a;
      q.push(y);
    } else if (x == b) {
      if (visited[y]) continue;
      if (par[y] == a) {
        visited[y] = 1;
        par[y] = -2;
        continue;
      }
      par[y] = b;
      q1.push(y);
    } else if (y == a) {
      if (visited[x]) continue;
      if (par[x] == b) {
        visited[x] = 1;
        par[x] = -2;
        continue;
      }
      par[x] = a;
      q.push(x);
    } else if (y == b) {
      if (visited[x]) continue;
      if (par[x] == a) {
        visited[x] = 1;
        par[x] = -2;
        continue;
      }
      par[x] = b;
      q1.push(x);
    } else {
      v[x].push_back(y);
      v[y].push_back(x);
    }
  }
  visited[a] = 1;
  visited[b] = 1;
  long long int a1 = 0, b1 = 0;
  while (!q.empty()) {
    int i = q.front();
    q.pop();
    if (visited[i]) continue;
    size = 0;
    t = a;
    if (par[i] == -2) t = -1;
    dfs(i);
    if (t == a) a1 += size;
  }
  while (!q1.empty()) {
    int i = q1.front();
    q1.pop();
    if (visited[i]) continue;
    size = 0;
    t = b;
    if (par[i] == -2) t = -1;
    dfs(i);
    if (t == b) b1 += size;
  }
  cout << a1 * b1 << '\n';
}
int main() {
  int t = 1;
  cin >> t;
  int countu = 1;
  while (t--) {
    solve(countu);
    countu++;
  }
}
