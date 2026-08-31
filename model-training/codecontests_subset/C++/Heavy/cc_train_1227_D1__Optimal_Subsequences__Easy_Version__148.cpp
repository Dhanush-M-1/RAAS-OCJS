#include <bits/stdc++.h>
using namespace std;
vector<long long int> graph[200007];
long long int visited[200007] = {0};
long long int mx = 0, cnt = 0;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int n, m, i, j;
  cin >> n;
  long long int a[n + 10];
  vector<pair<long long int, long long int> > v, s, g;
  vector<long long int> b;
  for (i = 0; i < n; i++) {
    cin >> a[i];
    s.push_back(make_pair(a[i], i));
  }
  sort(s.begin(), s.end());
  for (i = 0; i < n - 1; i++) {
    if (s[i].first != s[i + 1].first) {
      g.push_back(make_pair(s[i].first, s[i].second));
      for (j = g.size() - 1; j >= 0; j--) {
        v.push_back(make_pair(g[j].first, g[j].second));
      }
      g.clear();
    } else {
      g.push_back(make_pair(s[i].first, s[i].second));
    }
  }
  g.push_back(make_pair(s[i].first, s[i].second));
  for (j = g.size() - 1; j >= 0; j--) {
    v.push_back(make_pair(g[j].first, g[j].second));
  }
  cin >> m;
  while (m--) {
    long long int k, p;
    cin >> k >> p;
    cnt = 0;
    for (i = n - 1; i >= 0; i--) {
      cnt++;
      b.push_back(v[i].second);
      if (cnt == k) {
        break;
      }
    }
    sort(b.begin(), b.end());
    cout << a[b[p - 1]] << endl;
    b.clear();
  }
  return 0;
}
