#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int k;
  int max = 0, sum = 0;
  int key;
  for (int i = 0; i < n; i++) {
    cin >> k;
    if (k >= max) {
      max = k;
    }
    sum += k;
  }
  for (int i = 1; i <= 300; i++) {
    if ((i * n - sum) > sum && i >= max) {
      key = i;
      break;
    }
  }
  cout << key << endl;
}
