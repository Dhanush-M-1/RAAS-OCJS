#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  vector<int> a;
  cin >> n;
  a.resize(n);
  int max = 0;
  int s = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] > max) {
      max = a[i];
    }
    s += a[i];
  }
  int k = max;
  while (true) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum = sum + k - a[i];
    }
    if (sum > s) {
      cout << k;
      return 0;
    }
    k++;
  }
}
