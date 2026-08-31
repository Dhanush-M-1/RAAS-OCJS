#include <bits/stdc++.h>
using namespace std;
inline int iin() {
  int x;
  scanf("%d", &x);
  return x;
}
inline long long int lin() {
  long long int x;
  scanf("%lld", &x);
  return x;
}
const long long int N = 1e6 + 85;
const long long int M = 1e3 + 85;
const long long int mod = 1e9 + 7;
const long long int pinf = LLONG_MAX;
const long long int minf = LLONG_MIN;
long long int arr[N];
vector<pair<long long int, long double> > edge[N];
map<int, bool> mark;
void DFS(int v) {
  mark[v] = true;
  for (auto e : edge[v])
    if (!mark[e.first]) {
      DFS(e.first);
      if (arr[e.first] >= 0)
        arr[v] += arr[e.first];
      else {
        if (arr[e.first] * 0.1 * e.second + arr[v] < -1e18) {
          cout << "NO\n";
          exit(0);
        }
        arr[v] += arr[e.first] * e.second;
      }
    }
}
int32_t main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> arr[i];
  for (int i = 1; i <= n; i++) {
    long long int x;
    cin >> x;
    arr[i] -= x;
  }
  for (int i = 2; i <= n; i++) {
    long long int x, k;
    cin >> x >> k;
    edge[x].push_back({i, k});
  }
  DFS(1);
  return cout << (arr[1] >= 0 ? "YES\n" : "NO\n") << endl, 0;
}
