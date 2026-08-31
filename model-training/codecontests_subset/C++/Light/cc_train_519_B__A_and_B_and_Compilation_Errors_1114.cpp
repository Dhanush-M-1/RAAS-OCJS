#include <bits/stdc++.h>
using namespace std;
long long sum(vector<long long> arr) {
  long long s = 0;
  for (int i = 0; i < arr.size(); i++) s += arr[i];
  return s;
}
int main() {
  int n, i;
  long long x;
  cin >> n;
  vector<long long> arr, arr1;
  for (i = 0; i < n; i++) {
    cin >> x;
    arr.push_back(x);
  }
  for (i = 0; i < n - 1; i++) {
    cin >> x;
    arr1.push_back(x);
  }
  long long res = sum(arr) - sum(arr1);
  arr.clear();
  for (i = 0; i < n - 2; i++) {
    cin >> x;
    arr.push_back(x);
  }
  cout << res << endl;
  cout << sum(arr1) - sum(arr);
}
