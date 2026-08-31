#include <bits/stdc++.h>
using namespace std;
template <typename S, typename T>
ostream& operator<<(ostream& out, pair<S, T> const& p) {
  out << '(' << p.first << ", " << p.second << ')';
  return out;
}
template <typename T>
ostream& operator<<(ostream& out, vector<T> const& v) {
  int l = v.size();
  for (int i = 0; i < l - 1; i++) out << v[i] << ' ';
  if (l > 0) out << v[l - 1];
  return out;
}
template <typename T>
void trace(const char* name, T&& arg1) {
  cout << name << " : " << arg1 << endl;
}
template <typename T, typename... Args>
void trace(const char* names, T&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cout.write(names, comma - names) << " : " << arg1 << " | ";
  trace(comma + 1, args...);
}
const int N = 200200;
int done[N];
vector<int> g[N];
vector<int> order;
void purge(int x, int prev) {
  if (done[x]) return;
  order.push_back(x);
  done[x] = 1;
  for (int y : g[x]) {
    if (y == prev) continue;
    purge(y, x);
  }
}
bool dfs(int x, int prev) {
  bool leaf = true;
  int par = 0;
  for (int y : g[x]) {
    if (y == prev) continue;
    leaf = false;
    if (!dfs(y, x)) par ^= 1;
  }
  if (leaf) return false;
  if (prev != -1) {
    if (par) {
      purge(x, prev);
      return true;
    }
    return false;
  } else {
    if (par) return false;
    purge(x, prev);
    return true;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n;
  cin >> n;
  if (n == 1) {
    cout << "YES" << endl;
    cout << 1 << endl;
    return 0;
  }
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    if (x) {
      g[x].push_back(i);
      g[i].push_back(x);
    }
  }
  bool res = dfs(1, -1);
  if (!res) {
    cout << "NO" << endl;
  } else {
    cout << "YES" << endl;
    for (int x : order) {
      cout << x << '\n';
    }
  }
  return 0;
}
