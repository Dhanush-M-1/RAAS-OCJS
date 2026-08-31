#include <bits/stdc++.h>
using namespace std;
vector<long long> adj[200005];
set<long long> bac[200005];
long long mas[200005];
long long a;
void ba(long long u) {
  if (u == a) return;
  if (mas[u] == 0 || mas[u] == 2) return;
  mas[u] = 2;
  while (!bac[u].empty()) {
    long long a1 = *bac[u].begin();
    bac[u].erase(a1);
    ba(a1);
  }
}
int main() {
  long long t;
  cin >> t;
  for (long long t1 = 0; t1 < t; t1++) {
    long long n, m, b, c, d;
    cin >> n >> m >> a >> b;
    for (long long i = 0; i < m; i++) {
      cin >> c >> d;
      adj[c].push_back(d);
      adj[d].push_back(c);
    }
    queue<long long> q;
    mas[a] = 1;
    q.push(a);
    while (!q.empty()) {
      c = q.front();
      q.pop();
      if (c != b) {
        for (long long i = 0; i < adj[c].size(); i++) {
          if (mas[adj[c][i]] == 0) {
            q.push(adj[c][i]);
          }
          mas[adj[c][i]] = 1;
          bac[adj[c][i]].insert(c);
        }
      }
    }
    ba(b);
    mas[a] = 2;
    c = 0;
    d = 0;
    for (long long i = 1; i <= n; i++) {
      adj[i].clear();
      bac[i].clear();
      if (mas[i] == 0) c++;
      if (mas[i] == 1) d++;
      mas[i] = 0;
    }
    cout << c * d << "\n";
  }
}
