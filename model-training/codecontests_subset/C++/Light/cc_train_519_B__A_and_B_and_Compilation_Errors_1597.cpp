#include <bits/stdc++.h>
using namespace std;
map<int, int> mp2;
map<int, int> mp1;
map<int, int> mp;
int n, B, C;
int main() {
  cin >> n;
  int a[n], b[n - 1], c[n - 2];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    mp[a[i]]++;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
    mp1[b[i]]++;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
    mp2[c[i]]++;
  }
  for (int i = 0; i < n; i++) {
    if (mp[a[i]] != mp1[a[i]]) {
      B = a[i];
    }
    if (mp[a[i]] != mp2[a[i]] && mp2[a[i]] < mp1[a[i]]) {
      C = a[i];
    }
  }
  cout << B << '\n' << C;
}
