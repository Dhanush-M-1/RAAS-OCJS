#include <bits/stdc++.h>
using namespace std;
int work(int n, int k) {
  int ans = 0, p = 0;
  while (n) {
    ans += (n % k) * pow(10, p);
    n /= k;
    p++;
  }
  return ans;
}
int k;
int main() {
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      cout << work(i * j, k) << " ";
    }
    cout << endl;
  }
  return 0;
}
