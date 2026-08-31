#include <bits/stdc++.h>
using namespace std;
int n;
vector<pair<int, int> > v[100010 * 2];
unordered_set<long long> occ;
int contC[100010], contL[100010];
int main() {
  occ.reserve(1024);
  occ.max_load_factor(0.25);
  ios::sync_with_stdio(0);
  cin >> n;
  int xi, yi;
  for (int i = 0; i < n; i++) {
    cin >> xi >> yi;
    occ.insert(yi * (1LL << 20) + xi);
    contC[xi]++;
    contL[yi]++;
    v[xi - yi + 100010].push_back({xi, yi});
  }
  int ans = 0;
  for (int i = 0; i < 100010 * 2; i++) {
    for (int l = 0; l < v[i].size(); l++) {
      if (contC[v[i][l].first] == 1 || contL[v[i][l].second] == 1)
        swap(v[i][l], v[i][v[i].size() - 1]), v[i].pop_back(), l--;
    }
    sort(v[i].begin(), v[i].end());
    for (int l = 0; l < v[i].size(); l++) {
      for (int j = l + 1; j < v[i].size(); j++) {
        if (occ.count(v[i][l].first + (1LL << 20) * v[i][j].second) &&
            occ.count(v[i][j].first + (1LL << 20) * v[i][l].second)) {
          ans++;
        }
      }
    }
  }
  cout << ans << "\n";
}
