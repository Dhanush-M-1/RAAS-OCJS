#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, m;
  cin >> n >> m;
  map<int, int> a, b;
  int temp;
  for (long long i = 0; i < n; i++) {
    cin >> temp;
    a[temp]++;
  }
  for (long long i = 0; i < m; i++) {
    cin >> temp;
    b[temp]++;
  }
  auto itr = a.end();
  itr--;
  for (auto it = a.begin(); it != a.end(); it++) {
    if (b.find(it->first) != b.end()) {
      cout << "YES" << endl << "1 " << it->first << endl;
      return;
    } else if (it == itr) {
      cout << "NO" << endl;
      return;
    }
  }
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL), cout.tie(NULL);
  clock_t start = clock();
  long long test = 1;
  cin >> test;
  while (test--) solve();
  clock_t end = clock();
  cerr << fixed << setprecision(15) << ((double)(end - start)) / CLOCKS_PER_SEC
       << endl;
  return 0;
}
