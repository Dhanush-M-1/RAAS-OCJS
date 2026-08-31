#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> arr;
  int a[n];
  int sum = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    arr.push_back(a[i]);
    sum += a[i];
  }
  sort(arr.begin(), arr.end());
  int k = arr[arr.size() - 1];
  int p;
  for (int j = k;; j++) {
    p = 0;
    for (int i = 0; i < n; i++) {
      p += (j - a[i]);
    }
    if (p > sum) {
      cout << j;
      break;
    }
  }
}
