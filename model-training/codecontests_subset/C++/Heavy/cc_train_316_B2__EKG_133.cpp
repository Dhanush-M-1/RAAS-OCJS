#include <bits/stdc++.h>
using namespace std;
const long double pi = 3.14159265358979323846;
long long MOD = 1e9 + 7;
const char nl = '\n';
const long long inf = 1e15;
long long power(long long x, long long y) {
  long long z = 1;
  while (y > 0) {
    if (y % 2) z = z * x;
    x = x * x;
    y /= 2;
  }
  return z;
}
long long gcd(long long a, long long b) {
  if (a < b) return gcd(b, a);
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long sq(long long a) {
  long long ans = (1ll * a * a);
  return ans;
}
int n, x;
vector<vector<int>> g(1001);
int par[1001];
int pos[1001];
int vis[1001];
set<int> ans(vector<int> nums, int ptr) {
  if (ptr == nums.size()) {
    set<int> t;
    t.insert(0);
    return t;
  }
  set<int> bakra = ans(nums, ptr + 1);
  set<int> ret = bakra;
  for (int ele : bakra) {
    ret.insert(ele + nums[ptr]);
  }
  return ret;
}
void dfs(int node, int position, int color) {
  pos[node] = position;
  vis[node] = color;
  for (int child : g[node]) {
    if (vis[child] == -1) {
      dfs(child, position + 1, color);
    }
  }
}
void solve() {
  memset(pos, -1, sizeof(pos));
  memset(par, -1, sizeof(par));
  memset(vis, -1, sizeof(vis));
  cin >> n >> x;
  for (int i = 1; i <= n; i++) {
    int temp;
    cin >> temp;
    if (temp != 0) {
      par[i] = temp;
      g[temp].push_back(i);
    }
  }
  int color = 0;
  for (int i = 1; i <= n; i++) {
    if (par[i] == -1) {
      color++;
      dfs(i, 0, color);
    }
  }
  int fre[color + 1];
  memset(fre, 0, sizeof(fre));
  for (int i = 1; i <= n; i++) {
    fre[vis[i]]++;
  }
  vector<int> nums;
  for (int i = 1; i <= color; i++) {
    if (vis[x] != i) {
      nums.push_back(fre[i]);
    }
  }
  set<int> retard = ans(nums, 0);
  for (auto it : retard) {
    cout << it + pos[x] + 1 << "\n";
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0), cout.tie(0);
  long long TC = 1;
  while (TC--) {
    solve();
  }
}
