#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> nums(n);
  vector<int> numt(n - 1);
  vector<int> numf(n - 2);
  for (int i = 0; i < n; i++) {
    int t;
    cin >> t;
    nums.push_back(t);
  }
  for (int i = 0; i < n - 1; i++) {
    int t;
    cin >> t;
    numt.push_back(t);
  }
  for (int i = 0; i < n - 2; i++) {
    int t;
    cin >> t;
    numf.push_back(t);
  }
  bool b = false;
  sort(nums.begin(), nums.end(), greater<int>());
  sort(numt.begin(), numt.end(), greater<int>());
  sort(numf.begin(), numf.end(), greater<int>());
  for (int i = 0; i < n - 1; i++) {
    if (nums[i] == numt[i]) {
      nums[i] = 0;
    }
  }
  sort(nums.begin(), nums.end(), greater<int>());
  cout << nums[0] << endl;
  for (int i = 0; i < n - 1; i++) {
    if (numt[i] == numf[i]) {
      numt[i] = 0;
      numf[i] = 0;
    }
  }
  sort(nums.begin(), nums.end(), greater<int>());
  sort(numt.begin(), numt.end(), greater<int>());
  sort(numf.begin(), numf.end(), greater<int>());
  cout << numt[0] << endl;
  return 0;
}
