#include <bits/stdc++.h>
using namespace std;
long long int binpow(long long int a, long long int b) {
  a %= 1000000007;
  long long int res = 1;
  while (b > 0) {
    if (b & 1) res = (res * a) % 1000000007;
    a = (a * a) % 1000000007;
    b >>= 1;
  }
  return res;
}
long long int a[100005], b[100005], vis[100005], x[100005], k[100005];
vector<long long int> adj[100005];
void dfs(long long int n) {
  vis[n] = 1;
  for (auto xx : adj[n]) {
    if (vis[xx] == 0) {
      dfs(xx);
      if (a[xx] > b[xx] && 1000000000000000000 / (a[xx] - b[xx]) < k[xx]) {
        cout << "NO";
        exit(0);
      }
      if (1000000000000000000 < a[n] + k[xx] * max(0LL, a[xx] - b[xx])) {
        cout << "NO";
        exit(0);
      }
      a[n] += k[xx] * max(0LL, a[xx] - b[xx]);
      b[n] += max(0LL, b[xx] - a[xx]);
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int n, i, fl = 0;
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> b[i];
  }
  for (i = 1; i <= n; i++) {
    cin >> a[i];
  }
  for (i = 2; i <= n; i++) {
    cin >> x[i] >> k[i];
    adj[i].push_back(x[i]);
    adj[x[i]].push_back(i);
  }
  for (i = 1; i <= n; i++) {
    if (vis[i] == 0) {
      dfs(i);
      if (b[i] < a[i]) {
        fl = 1;
        break;
      }
    }
  }
  if (fl) {
    cout << "NO";
  } else {
    cout << "YES";
  }
}
