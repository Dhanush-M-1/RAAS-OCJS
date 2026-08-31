#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  long long int a[n];
  map<long long int, long long int> mp;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    mp[a[i]]++;
  }
  long long int b[n - 1];
  map<long long int, long long int> mp_2;
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
    mp_2[b[i]]++;
  }
  for (auto it : mp) {
    if (it.second != mp_2[it.first]) {
      cout << it.first << endl;
      break;
    }
  }
  long long int c[n - 2];
  map<long long int, long long int> mp_3;
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
    mp_3[c[i]]++;
  }
  for (auto it : mp_2) {
    if (it.second != mp_3[it.first]) {
      cout << it.first << endl;
      break;
    }
  }
  return 0;
}
