#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int i, j, k, l, m, n;
  cin >> n;
  long long int a[n];
  vector<long long int> v;
  for (i = 0; i < n; i++) {
    cin >> a[i];
    v.push_back(a[i]);
  }
  sort(v.begin(), v.end());
  long long int var;
  cin >> var;
  while (var--) {
    cin >> k >> l;
    map<long long int, long long int> mp;
    for (i = n - k; i < n; i++) mp[v[i]]++;
    long long int it = 0;
    for (i = 0; i < n; i++) {
      if (mp[a[i]]) {
        if (it == l - 1) {
          cout << a[i] << endl;
          break;
        } else
          it++;
        mp[a[i]]--;
      }
    }
  }
}
