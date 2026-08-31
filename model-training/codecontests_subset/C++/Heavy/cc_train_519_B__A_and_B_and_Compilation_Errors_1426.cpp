#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, n, t;
  cin >> n;
  vector<int> v1;
  vector<int> v2;
  vector<int> v3;
  vector<int> diff;
  vector<int> diff1;
  for (i = 0; i < n; i++) {
    cin >> t;
    v1.push_back(t);
  }
  for (i = 0; i < n - 1; i++) {
    cin >> t;
    v2.push_back(t);
  }
  for (i = 0; i < n - 2; i++) {
    cin >> t;
    v3.push_back(t);
  }
  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());
  sort(v3.begin(), v3.end());
  i = 0;
  set_difference(v1.begin(), v1.end(), v2.begin(), v2.end(),
                 inserter(diff, diff.begin()));
  cout << diff[0] << endl;
  set_difference(v2.begin(), v2.end(), v3.begin(), v3.end(),
                 inserter(diff1, diff1.begin()));
  cout << diff1[0];
  return 0;
}
