#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 9;
long long a, b, x, y, z, n, m, k;
int arr[N];
double m2;
int main() {
  cin >> n >> k;
  arr[n];
  for (int i = 0; i < n; i++) cin >> arr[i];
  sort(arr, arr + n);
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    if (k % arr[i] == 0) x = arr[i];
  }
  cout << k / x;
}
