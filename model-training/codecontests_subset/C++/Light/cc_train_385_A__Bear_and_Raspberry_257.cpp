#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  int val[n];
  for (int i = 0; i < n; i++) {
    cin >> val[i];
  }
  int max = 0;
  for (int i = 0; i < n - 1; i++) {
    if (val[i] > val[i + 1] + c) {
      if (max < val[i] - val[i + 1] - c) max = val[i] - val[i + 1] - c;
    }
  }
  cout << max << endl;
}
