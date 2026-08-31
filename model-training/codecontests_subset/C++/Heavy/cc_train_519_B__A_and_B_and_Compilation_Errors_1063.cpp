#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> ans(2);
  multiset<int> first, second, third;
  for (int i = 0; i < n; i++) {
    int temp;
    cin >> temp;
    first.insert(temp);
  }
  for (int i = 0; i < n - 1; i++) {
    int temp;
    cin >> temp;
    second.insert(temp);
  }
  for (int i = 0; i < n - 2; i++) {
    int temp;
    cin >> temp;
    third.insert(temp);
  }
  set_difference(first.begin(), first.end(), second.begin(), second.end(),
                 ans.begin());
  set_difference(second.begin(), second.end(), third.begin(), third.end(),
                 ans.begin() + 1);
  cout << ans[0] << "\n";
  cout << ans[1] << "\n";
}
