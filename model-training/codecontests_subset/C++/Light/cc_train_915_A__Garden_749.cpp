#include <bits/stdc++.h>
using namespace std;
int N, K;
int main() {
  cin >> N >> K;
  int ans = K;
  while (N--) {
    int w;
    scanf("%d", &w);
    if (K % w == 0) {
      ans = min(ans, K / w);
    }
  }
  cout << ans << endl;
  return 0;
}
