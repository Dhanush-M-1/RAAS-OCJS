#include <bits/stdc++.h>
using namespace std;
int n, m, k;
int a[200005];
int b[200005];
vector<int> adj[200005];
bool removed[200005];
int nc[200005];
int ans[200005];
set<pair<int, int>> remedges;
int main() {
  ios::sync_with_stdio(false);
  scanf("%d %d %d", &n, &m, &k);
  for (int i = 0; i < m; i++) {
    scanf("%d %d", &a[i], &b[i]);
  }
  for (int i = 0; i < m; i++) {
    adj[a[i]].push_back(b[i]);
    adj[b[i]].push_back(a[i]);
    nc[a[i]]++;
    nc[b[i]]++;
  }
  int cans = n;
  for (int i = 1; i <= n; i++) {
    if (!removed[i]) {
      if (nc[i] < k) {
        removed[i] = true;
        cans--;
        queue<int> q;
        q.push(i);
        while (!q.empty()) {
          int cur = q.front();
          q.pop();
          for (int j = 0; j < adj[cur].size(); j++) {
            int x = adj[cur][j];
            if (!removed[x]) {
              nc[x]--;
              if (nc[x] < k) {
                removed[x] = true;
                cans--;
                q.push(x);
              }
            }
          }
        }
      }
    }
  }
  ans[m - 1] = cans;
  for (int cm = m - 1; cm >= 0; cm--) {
    int ca = a[cm];
    int cb = b[cm];
    if (!removed[ca] && !removed[cb]) {
      nc[ca]--;
      nc[cb]--;
      remedges.insert(make_pair(ca, cb));
      remedges.insert(make_pair(cb, ca));
      if (nc[ca] < k) {
        removed[ca] = true;
        cans--;
        queue<int> q;
        q.push(ca);
        while (!q.empty()) {
          int cur = q.front();
          q.pop();
          for (int j = 0; j < adj[cur].size(); j++) {
            int x = adj[cur][j];
            if (remedges.find(make_pair(cur, x)) != remedges.end()) {
              continue;
            }
            if (!removed[x]) {
              nc[x]--;
              if (nc[x] < k) {
                removed[x] = true;
                cans--;
                q.push(x);
              }
            }
          }
        }
      }
      if (nc[cb] < k && !removed[cb]) {
        removed[cb] = true;
        cans--;
        queue<int> q;
        q.push(cb);
        while (!q.empty()) {
          int cur = q.front();
          q.pop();
          for (int j = 0; j < adj[cur].size(); j++) {
            int x = adj[cur][j];
            if (remedges.find(make_pair(cur, x)) != remedges.end()) {
              continue;
            }
            if (!removed[x]) {
              nc[x]--;
              if (nc[x] < k) {
                removed[x] = true;
                cans--;
                q.push(x);
              }
            }
          }
        }
      }
    }
    if (cm > 0) {
      ans[cm - 1] = cans;
    }
  }
  for (int i = 0; i < m; i++) {
    printf("%d\n", ans[i]);
  }
}
