#include <bits/stdc++.h>
using namespace std;
int a[100];
int main() {
  int n, sum = 0, count = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    sum += a[i];
  }
  int max = a[0];
  for (int i = 0; i < n; i++)
    if (a[i] > max) max = a[i];
  int k = max;
  for (int i = 0; i < n; i++) count += k - a[i];
  while (count <= sum) {
    k++;
    count = 0;
    for (int i = 0; i < n; i++) count += k - a[i];
  }
  cout << k;
  return 0;
}
