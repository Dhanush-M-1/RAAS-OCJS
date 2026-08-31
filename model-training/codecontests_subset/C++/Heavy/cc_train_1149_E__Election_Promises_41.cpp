#include <bits/stdc++.h>
const int N = 200200;
using namespace std;
int n;
int q;
int h[N];
int m[N];
int t[N];
vector<int> v[N];
void dfs(int x) {
  if (t[x]) {
    return;
  }
  set<int> s;
  for (int y : v[x]) {
    dfs(y);
    s.insert(t[y]);
  }
  t[x] = 1;
  while (s.find(t[x]) != s.end()) {
    t[x] += 1;
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n >> q;
  for (int i = 1; i <= n; i++) {
    cin >> h[i];
  }
  for (int i = 1; i <= q; i++) {
    int x, y;
    cin >> x >> y;
    v[x].push_back(y);
  }
  for (int i = 1; i <= n; i++) {
    dfs(i);
    m[t[i]] ^= h[i];
  }
  int last = -1;
  for (int i = 1; i <= n; i++) {
    if (m[i]) {
      last = i;
    }
  }
  if (last == -1) {
    cout << "LOSE"
         << "\n";
    return 0;
  }
  cout << "WIN"
       << "\n";
  for (int i = 1; i <= n; i++) {
    if (t[i] == last && (m[t[i]] ^ h[i]) < h[i]) {
      h[i] = m[t[i]] ^ h[i];
      for (int j : v[i]) {
        m[t[j]] ^= h[j];
        h[j] = m[t[j]];
        m[t[j]] = 0;
      }
      break;
    }
  }
  for (int i = 1; i <= n; i++) {
    cout << h[i] << " \n"[i == n];
  }
}
