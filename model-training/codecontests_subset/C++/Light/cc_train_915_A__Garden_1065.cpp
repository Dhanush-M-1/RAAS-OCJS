#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n, k;
  cin >> n >> k;
  int mini = INT_MAX;
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    if (k % a == 0 && k / a < mini) mini = k / a;
  }
  cout << mini;
  return 0;
}
