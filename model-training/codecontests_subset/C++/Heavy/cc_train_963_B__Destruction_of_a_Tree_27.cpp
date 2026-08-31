#include <bits/stdc++.h>
using namespace std;
long long modexpo(long long x, long long p) {
  long long res = 1;
  x = x % 1000000007;
  while (p) {
    if (p % 2) res = res * x;
    p >>= 1;
    x = x * x % 1000000007;
    res %= 1000000007;
  }
  return res;
}
struct compare {
  bool operator()(const pair<long long, long long> a,
                  const pair<long long, long long> b) const {
    return a.first < b.first;
  }
};
const long long nax = 2e5 + 5;
vector<long long> g[nax];
long long deg[nax];
long long n, root;
vector<long long> ans;
set<long long> s;
void topdowndfs(long long x, long long p) {
  ans.push_back(x);
  s.insert(x);
  for (long long i : g[x]) {
    if (i != p && s.find(i) == s.end()) {
      topdowndfs(i, x);
    }
  }
}
void dfs(long long x, long long p) {
  for (long long i : g[x]) {
    if (i != p) {
      dfs(i, x);
    }
  }
  if (deg[x] % 2 == 0) {
    topdowndfs(x, p);
    deg[p]--;
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    long long x;
    cin >> x;
    if (x == 0) {
      root = i;
    } else {
      g[i].push_back(x);
      g[x].push_back(i);
      deg[i]++;
      deg[x]++;
    }
  }
  dfs(root, root);
  if (ans.size() == n) {
    cout << "YES\n";
    for (long long i : ans) {
      cout << i << " ";
    }
    cout << "\n";
  } else {
    cout << "NO"
         << "\n";
  }
}
