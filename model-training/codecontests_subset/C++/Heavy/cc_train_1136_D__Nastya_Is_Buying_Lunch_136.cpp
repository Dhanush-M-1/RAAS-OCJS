#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
const int MAXN = 300010;
vector<int> adj[MAXN];
int arr[MAXN];
bool toMove[MAXN];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < (n); ++i) cin >> arr[i];
  int v1, v2;
  for (int i = 0; i < (m); ++i) {
    cin >> v1 >> v2;
    adj[v1].push_back(v2);
  }
  toMove[arr[n - 1]] = true;
  int cnt = 1, tmp;
  for (int i = (n - 2); i >= (0); --i) {
    tmp = 0;
    for (int ch : adj[arr[i]])
      if (toMove[ch]) ++tmp;
    if (tmp != cnt) {
      ++cnt;
      toMove[arr[i]] = true;
    }
  }
  cout << n - cnt << '\n';
  return 0;
}
