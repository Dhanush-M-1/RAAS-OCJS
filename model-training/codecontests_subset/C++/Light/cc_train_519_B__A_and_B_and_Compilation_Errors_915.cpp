#include <bits/stdc++.h>
using namespace std;
const int N = (int)1e6 + 5;
const int MACX = (int)1e9 + 7;
const int dx[] = {1, -1, 0, 0};
const int dy[] = {0, 0, 1, -1};
long long n, a[N], b[N], c[N];
multiset<long long> ms, ms2;
int main() {
  ios_base ::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    ms.insert(a[i]);
  }
  for (int i = 1; i < n; i++) {
    cin >> b[i];
    ms.erase(ms.find(b[i]));
    ms2.insert(b[i]);
  }
  for (int i = 1; i < n - 1; i++) {
    cin >> c[i];
    ms2.erase(ms2.find(c[i]));
  }
  cout << *ms.begin() << " " << *ms2.begin();
  return 0;
}
