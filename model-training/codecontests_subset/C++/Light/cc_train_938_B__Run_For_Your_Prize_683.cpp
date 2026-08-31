#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> v(n);
  for (int i = 0; i < n; ++i) {
    cin >> v[i];
  }
  vector<long> myv;
  int m = 1;
  int temp_m = 1;
  int f = 1000000;
  int temp_f = 1000000;
  long total_m = 0, total_f = 0;
  for (int i = 0; i < n; ++i) {
    if (abs(v[i] - m) < abs(v[i] - f)) {
      myv.push_back(abs(v[i] - m));
    } else {
      myv.push_back(abs(v[i] - f));
    }
  }
  cout << (*max_element(myv.begin(), myv.end()));
  return 0;
}
