#include <bits/stdc++.h>
using namespace std;
int main() {
  int i;
  int n, k;
  int num[1005];
  int mini = 999999;
  cin >> n >> k;
  for (int a = 0; a < n; a++) cin >> num[a];
  for (i = 0; i < n; i++) {
    if (k % num[i] == 0) {
      if (k / num[i] < mini) mini = k / num[i];
    }
  }
  cout << mini << endl;
  return 0;
}
