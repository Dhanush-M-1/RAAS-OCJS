#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 500007;
const long long MOD = 1e9 + 7;
const long long INF = 1e18 + 7;
long long n, m, ans = 0;
long long seat[MAXN] = {};
set<long long> can;
vector<long long> adj[MAXN] = {};
int main(void) {
  cin >> n >> m;
  for (long long i0 = 0; i0 < n; i0++) {
    cin >> seat[n - i0 - 1];
  }
  for (long long i0 = 0; i0 < m; i0++) {
    long long x, y;
    cin >> x >> y;
    adj[x].push_back(y);
  }
  long long need = 1;
  can.insert(seat[0]);
  for (long long i0 = 1; i0 < n; i0++) {
    long long tot = 0;
    long long num_Bro = adj[seat[i0]].size();
    for (long long i = 0; i < num_Bro; i++) {
      long long bro = adj[seat[i0]][i];
      if (can.find(bro) != can.end()) tot++;
    }
    if (tot == need)
      ans++;
    else {
      need++;
      can.insert(seat[i0]);
    }
  }
  cout << ans << endl;
  return 0;
}
