#include <bits/stdc++.h>
using namespace std;
pair<int, int> a[100];
int ind[100];
bool cmp(int i, int j) {
  if (a[i].first == a[j].first) return a[i].second < a[j].second;
  return a[i].first > a[j].first;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> a[i].first;
    a[i].second = i, ind[i] = i;
  }
  sort(ind, ind + n, cmp);
  int m;
  cin >> m;
  while (m--) {
    int k, pos;
    cin >> k >> pos;
    vector<int> chosen(k);
    for (int i = 0; i < k; ++i) chosen[i] = a[ind[i]].second;
    sort(chosen.begin(), chosen.end());
    cout << a[chosen[pos - 1]].first << '\n';
  }
}
