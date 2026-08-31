#include <bits/stdc++.h>
using namespace std;
int length, n, bucket, ans = 1e9 + 7;
int main() {
  cin >> n >> length;
  for (int i = 0; i < n; i++) {
    cin >> bucket;
    if (length % bucket == 0 && bucket <= length)
      ans = (ans < length / bucket ? ans : length / bucket);
  }
  cout << ans;
  return 0;
}
