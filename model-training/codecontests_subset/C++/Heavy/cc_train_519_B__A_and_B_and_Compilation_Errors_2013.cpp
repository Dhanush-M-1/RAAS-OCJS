#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n;
  cin >> n;
  long long int v[n];
  for (int i = 0; i < n; i++) {
    cin >> v[i];
  }
  map<int, int> mp1;
  map<int, int> mp2;
  for (int i = 0; i < n - 1; i++) {
    int a;
    cin >> a;
    mp1[a]++;
  }
  for (int i = 0; i < n - 2; i++) {
    int b;
    cin >> b;
    mp2[b]++;
  }
  for (int i = 0; i < n; i++) {
    if (mp1.find(v[i]) == mp1.end()) {
      cout << v[i] << endl;
      mp2[v[i]]++;
      break;
    } else {
      mp1[v[i]]--;
      if (mp1[v[i]] == 0) {
        mp1.erase(v[i]);
      }
    }
  }
  for (int i = 0; i < n; i++) {
    if (mp2.find(v[i]) == mp2.end()) {
      cout << v[i] << endl;
      break;
    } else {
      mp2[v[i]]--;
      if (mp2[v[i]] == 0) {
        mp2.erase(v[i]);
      }
    }
  }
}
