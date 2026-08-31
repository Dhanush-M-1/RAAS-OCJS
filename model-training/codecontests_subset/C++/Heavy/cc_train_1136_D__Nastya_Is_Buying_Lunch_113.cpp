#include <bits/stdc++.h>
using namespace std;
long long n, m;
int mas[300300];
vector<int> edge[300300];
vector<int> nes;
int tim[300300];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> mas[i];
  }
  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    edge[a].push_back(b);
  }
  int t = 1e8;
  tim[mas[n - 1]] = t;
  int nes = 1;
  int ans = 0;
  for (int i = n - 2; i >= 0; i--) {
    int kol = 0;
    t--;
    for (int j = 0; j < edge[mas[i]].size(); j++) {
      if (tim[edge[mas[i]][j]] == 0) continue;
      kol++;
    }
    if (kol == nes) {
      ans++;
      continue;
    }
    tim[mas[i]] = t;
    nes++;
  }
  cout << ans;
  return 0;
}
