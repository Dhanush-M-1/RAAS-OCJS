#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  std::vector<int> v1(n);
  std::vector<int> v2(n - 1);
  std::vector<int> v3(n - 2);
  for (int i = 0; i < n; i++) cin >> v1[i];
  for (int i = 0; i < n - 1; i++) cin >> v2[i];
  for (int i = 0; i < n - 2; i++) cin >> v3[i];
  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());
  sort(v3.begin(), v3.end());
  std::vector<int> v(2);
  auto itr = v.begin();
  set_difference(v1.begin(), v1.end(), v2.begin(), v2.end(), itr);
  itr++;
  set_difference(v2.begin(), v2.end(), v3.begin(), v3.end(), itr);
  for (auto i : v) {
    cout << i << endl;
  }
  return 0;
}
