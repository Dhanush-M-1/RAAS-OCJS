#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 5;
const int INF = 1e9;
const long long mod = 1e9 + 7;
vector<int> v[N];
bool memo[N];
int cnt[N], ans, arr[N], n, m;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> arr[i];
  for (int i = 1; i <= m; i++) {
    int a, b;
    cin >> a >> b;
    v[b].push_back(a);
  }
  int now = n;
  int person = arr[n];
  for (auto isi : v[person]) {
    memo[isi] = true;
  }
  for (int i = n; i >= 1; i--) {
    if (memo[arr[i]]) {
      if (cnt[arr[i]] == now - i) {
        ans++;
        now--;
        continue;
      }
    }
    for (auto isi : v[arr[i]]) {
      cnt[isi]++;
    }
  }
  cout << ans << endl;
}
