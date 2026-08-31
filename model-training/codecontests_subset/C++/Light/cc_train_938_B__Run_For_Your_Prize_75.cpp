#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int x;
  int ans1 = 0;
  int ans2 = 0;
  for (int i = 0; i < n; i++) {
    cin >> x;
    if (x >= 500001) {
      ans2 = max(ans2, 1000000 - x);
    } else {
      ans1 = max(ans1, x - 1);
    }
  }
  std::cout << max(ans1, ans2) << std::endl;
  return 0;
}
