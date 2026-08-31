#include <bits/stdc++.h>
using namespace std;
long long mx(long long x, long long n) {
  if (!n)
    return 1;
  else if (n % 2 == 0)
    return mx((x * x) % 998244353, n / 2);
  else
    return (x * mx((x * x) % 998244353, (n - 1) / 2)) % 998244353;
}
long long modinv(long long n) { return mx(n, 1000000007 - 2); }
void bfs(vector<int> g[], int s, int n) {
  queue<long long> q;
  bool vis[n];
  memset(vis, false, sizeof(vis));
  vis[s] = true;
  q.push(s);
  while (!q.empty()) {
    long long temp = q.front();
    q.pop();
    for (auto it : g[temp]) {
      if (vis[it] == false) {
        q.push(it);
        vis[it] = true;
      }
    }
  }
}
void dfs(vector<int> g[], int src, bool vis[]) {
  vis[src] = true;
  for (auto it : g[src]) {
    if (vis[it] == false) {
      dfs(g, it, vis);
    }
  }
}
bool compare(string a, string b) { return a.length() < b.length(); }
long long n;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  string a[n];
  map<long long, vector<string>> mpp;
  for (long long i = 0; i < n; i++)
    cin >> a[i], mpp[a[i].size()].push_back(a[i]);
  long long l1, l2, ta = 0, ans = 0, count, d, t;
  for (auto iterator : mpp) {
    for (auto iterator2 : mpp) {
      l1 = iterator.first;
      l2 = iterator2.first;
      if (l1 >= l2) {
        ta = 0;
        d = l1 - l2;
        for (auto iterator3 : iterator.second) {
          count = 1;
          for (long long k = l1 - 1; k >= d; k--) {
            t = iterator3[k] - '0';
            ta = (ta % 998244353 +
                  (t % 998244353 * mx(10, count) % 998244353) % 998244353) %
                 998244353;
            count += 2;
          }
          count--;
          for (long long k = d - 1; k >= 0; k--) {
            t = iterator3[k] - '0';
            ta = (ta % 998244353 +
                  (t % 998244353 * mx(10, count) % 998244353) % 998244353) %
                 998244353;
            count++;
          }
          count = 0;
          for (long long k = l1 - 1; k >= d; k--) {
            t = iterator3[k] - '0';
            ta = (ta % 998244353 +
                  (t % 998244353 * mx(10, count) % 998244353) % 998244353) %
                 998244353;
            count += 2;
          }
          for (long long k = d - 1; k >= 0; k--) {
            t = iterator3[k] - '0';
            ta = (ta % 998244353 +
                  (t % 998244353 * mx(10, count) % 998244353) % 998244353) %
                 998244353;
            count++;
          }
        }
        ans = (ans % 998244353 +
               (ta % 998244353 * (iterator2.second.size()) % 998244353) %
                   998244353) %
              998244353;
        if (!d) continue;
        ta = 0;
        for (auto iterator3 : iterator2.second) {
          count = 0;
          for (long long k = l2 - 1; k >= 0; k--) {
            t = iterator3[k] - '0';
            ta = (ta % 998244353 +
                  (t % 998244353 * mx(10, count) % 998244353) % 998244353) %
                 998244353;
            count += 2;
          }
          count = 1;
          for (long long k = l2 - 1; k >= 0; k--) {
            t = iterator3[k] - '0';
            ta = (ta % 998244353 +
                  (t % 998244353 * mx(10, count) % 998244353) % 998244353) %
                 998244353;
            count += 2;
          }
        }
        ans = (ans % 998244353 +
               (ta % 998244353 * (iterator.second.size()) % 998244353) %
                   998244353) %
              998244353;
        ta = 0;
      }
    }
  }
  cout << ans % 998244353;
  return 0;
}
