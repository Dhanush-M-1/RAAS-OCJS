#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  vector<long long> a(n), b(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < n; i++) {
    b[i] = a[i];
  }
  sort(a.begin(), a.end(), greater<long long>());
  long long m;
  cin >> m;
  vector<long long> result;
  while (m--) {
    long long k, pos;
    cin >> k >> pos;
    map<long long, long long> adj;
    for (int i = 0; i < k; i++) {
      adj[a[i]]++;
    }
    int ind = 1;
    long long ans = -1;
    for (int i = 0; i < n; i++) {
      auto x = adj.find(b[i]);
      if (x == adj.end() || (adj[b[i]] == 0)) {
        continue;
      }
      if (ind == pos) {
        ans = b[i];
        break;
      }
      adj[b[i]]--;
      ind++;
    }
    cout << ans << endl;
  }
}
