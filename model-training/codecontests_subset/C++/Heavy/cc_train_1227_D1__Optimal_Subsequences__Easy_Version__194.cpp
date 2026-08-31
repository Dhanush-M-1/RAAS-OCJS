#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
int main() {
  ll t = 1;
  while (t--) {
    int n;
    cin >> n;
    vector<int> v(n), temp(n);
    for (int i = 0; i < n; i++) {
      cin >> v[i];
      temp[i] = v[i];
    }
    sort(temp.begin(), temp.end(), greater<int>());
    int m;
    cin >> m;
    while (m--) {
      int k, pos;
      cin >> k >> pos;
      map<int, int> mp;
      for (int i = 0; i < k; i++) {
        mp[temp[i]]++;
      }
      vector<int> v1(k);
      int j = 0;
      for (int i = 0; i < n && j < k; i++) {
        if (mp[v[i]] > 0) {
          mp[v[i]]--;
          v1[j] = v[i];
          j++;
        }
      }
      cout << v1[pos - 1] << endl;
    }
  }
  return 0;
}
