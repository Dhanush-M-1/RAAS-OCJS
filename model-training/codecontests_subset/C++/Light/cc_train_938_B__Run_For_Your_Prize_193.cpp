#include <bits/stdc++.h>
using namespace std;
const int SIZE = 1e5 + 1;
const int last = 1e6;
int a[SIZE];
int main() {
  ios::sync_with_stdio(false);
  int i, n, b = 0, c = 0;
  cin >> n;
  for (i = 0; i < n; i++) cin >> a[i];
  int left = 0, right = n - 1;
  while (left < right) {
    if (a[left] - 1 < last - a[right]) {
      left++;
    } else {
      right--;
    }
  }
  cout << min(a[left] - 1, last - a[right]) << endl;
}
