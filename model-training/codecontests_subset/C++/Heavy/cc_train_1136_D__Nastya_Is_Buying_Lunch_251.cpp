#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
long long n, m, res = 0;
vector<long long> pos, mas, cnt;
set<long long> suff;
vector<vector<long long>> cons;
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m;
  mas.resize(n);
  pos.resize(n);
  cons.resize(n);
  for (long long i = 0; i < n; i++) {
    cin >> mas[i];
    mas[i]--;
    pos[mas[i]] = i;
  }
  for (long long i = 0; i < m; i++) {
    long long a, b;
    cin >> a >> b;
    a--;
    b--;
    if (pos[b] > pos[a]) cons[pos[a]].push_back(pos[b]);
  }
  suff.insert(n - 1);
  for (long long i = n - 2; i >= 0; i--) {
    long long s = 0;
    for (auto j : cons[i]) {
      if (suff.count(j)) s++;
    }
    if (s == suff.size()) {
      res++;
    } else {
      suff.insert(i);
    }
  }
  cout << res;
  return 0;
}
