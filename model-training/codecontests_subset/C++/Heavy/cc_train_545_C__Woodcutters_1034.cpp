#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n;
  while (cin >> n) {
    vector<long long int> height(n + 5);
    vector<long long int> left(n + 5);
    vector<long long int> right(n + 5);
    long long int x, y, h, a;
    for (a = 1; a <= n; a++) {
      cin >> x >> h;
      height[a] = h;
      if (a != 1) left[a] = x - y - 1;
      right[a - 1] = left[a];
      y = x;
    }
    long long int cnt = n;
    for (a = 2; a < n; a++) {
      if (height[a] > left[a]) {
        if (height[a] <= right[a])
          left[a + 1] = left[a + 1] - height[a];
        else
          cnt--;
      }
    }
    cout << cnt << endl;
  }
  return 0;
}
