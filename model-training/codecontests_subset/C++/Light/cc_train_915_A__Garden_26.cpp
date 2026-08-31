#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  vector<int> arr;
  int q;
  vector<int> arr1;
  for (int i = 0; i < n; i++) {
    cin >> q;
    arr.push_back(q);
  }
  sort(arr.begin(), arr.end());
  for (int i = 0; i < n; i++) {
    if (k % arr[i] == 0) arr1.push_back(k / arr[i]);
  }
  cout << *min_element(arr1.begin(), arr1.end()) << endl;
  ;
}
