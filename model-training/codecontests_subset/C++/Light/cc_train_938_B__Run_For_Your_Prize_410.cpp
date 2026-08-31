#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, ans = 0;
  scanf("%d", &a);
  for (int i = 0; i < a; i++) {
    int temp;
    cin >> temp;
    ans = max(ans, min(temp - 1, 1000000 - temp));
  }
  cout << ans;
  return 0;
}
