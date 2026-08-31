#include <bits/stdc++.h>
using namespace std;
void ios1() {
  ios_base::sync_with_stdio(0);
  cout.tie(0);
  cin.tie(0);
}
bool cmd(pair<long long, int> a, pair<long long, int> b) {
  if (a.first > b.first)
    return 0;
  else if (a.first < b.first)
    return 1;
  else
    return (a.second > b.second);
}
int main() {
  ios1();
  int n;
  cin >> n;
  pair<long long, int> arr[n];
  long long cop[n];
  int its[n];
  for (int i = 0; i < n; ++i) {
    cin >> cop[i];
    arr[i] = make_pair(cop[i], i);
  }
  long long sum1 = 0, sumi[n];
  sort(arr, arr + n, cmd);
  for (int i = n - 1; i >= 0; --i) {
    its[(n - 1) - i] = arr[i].second;
  }
  int m;
  cin >> m;
  for (int i = 0; i < m; ++i) {
    int a, b;
    cin >> a >> b;
    vector<int> v;
    for (int j = a - 1; j >= 0; j--) v.push_back(its[j]);
    sort(v.begin(), v.end());
    cout << cop[v[b - 1]] << endl;
  }
  return 0;
}
