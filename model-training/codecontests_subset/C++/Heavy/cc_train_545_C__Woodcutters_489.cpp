#include <bits/stdc++.h>
using namespace std;
void showvec1d(vector<int> v) {
  int n = v.size();
  cout << "-------------start1dv--------------------"
       << "\n";
  for (int i = 0; i < n; i++) cout << v[i] << " ";
  cout << "\n";
  cout << "--------------end1dv-------------------"
       << "\n";
}
void showvec2d(vector<vector<int> > v) {
  int n = v.size();
  cout << "--------------start2dv-----------------------\n";
  for (int i = 0; i < n; i++) {
    int sz = v[i].size();
    for (int j = 0; j < sz; j++) cout << v[i][j] << " ";
    cout << "\n";
  }
  cout << "-------------end2dv------------------"
       << "\n";
}
void solve() {
  int n;
  cin >> n;
  int x, h;
  cin >> x >> h;
  int cnt = 1;
  int prev = x + 1;
  int psps;
  for (int i = 1; i < n; i++) {
    cin >> x;
    if (prev > x) {
      cnt--;
      prev -= h;
    }
    cin >> h;
    psps = x - prev;
    if (psps >= h)
      prev = x + 1;
    else
      prev = x + h + 1;
    cnt++;
  }
  cout << cnt << "\n";
}
int main() {
  cin.tie(0);
  cout.tie(0);
  cin.sync_with_stdio(0);
  cout.sync_with_stdio(0);
  int TC = 1;
  for (int ZZ = 1; ZZ <= TC; ZZ++) {
    clock_t start = clock();
    solve();
    clock_t end = clock();
    cerr << "Time: " << (double)(end - start) / CLOCKS_PER_SEC << " seconds"
         << '\n';
  }
  return 0;
}
