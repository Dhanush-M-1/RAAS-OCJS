#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int n, k;
  cin >> n >> k;
  int a[n];
  for (int i = 0; i < n; i++) cin >> a[i];
  int temp = 100000;
  for (int i = 0; i < n; i++) {
    if (k % a[i] == 0 && temp > k / a[i]) temp = k / a[i];
  }
  cout << temp;
}
