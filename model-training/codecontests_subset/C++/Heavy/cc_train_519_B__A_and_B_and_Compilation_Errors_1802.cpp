#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  const int MAXN = 100000;
  int arr1[MAXN], arr2[MAXN], arr3[MAXN];
  map<int, int> map1;
  map<int, int> map2;
  map<int, int>::iterator it;
  for (int i = 0; i < n; ++i) {
    cin >> arr1[i];
    it = map1.find(arr1[i]);
    if (it == map1.end()) {
      map1[arr1[i]] = 1;
    } else {
      it->second += 1;
    }
  }
  for (int i = 0; i < n - 1; ++i) {
    cin >> arr2[i];
    it = map2.find(arr2[i]);
    if (it == map2.end()) {
      map2[arr2[i]] = 1;
    } else {
      it->second += 1;
    }
    it = map1.find(arr2[i]);
    if (it != map1.end()) {
      it->second -= 1;
    }
  }
  for (int i = 0; i < n - 2; ++i) {
    cin >> arr3[i];
    it = map2.find(arr3[i]);
    if (it != map2.end()) {
      it->second -= 1;
    }
  }
  for (int i = 0; i < n; ++i) {
    it = map1.find(arr1[i]);
    if (it->second != 0) {
      cout << it->first << endl;
      it->second -= 1;
    }
  }
  for (int i = 0; i < n - 1; ++i) {
    it = map2.find(arr2[i]);
    if (it->second != 0) {
      cout << it->first << endl;
      it->second -= 1;
    }
  }
  return 0;
}
