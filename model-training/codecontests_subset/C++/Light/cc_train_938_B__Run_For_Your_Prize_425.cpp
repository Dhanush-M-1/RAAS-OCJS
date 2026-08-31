#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, ans = 0, start = 1, end = 1000000, maxi, temp = 0;
  cin >> n;
  int arr[n + 1];
  for (int i = 0; i < n; i++) cin >> arr[i];
  for (int i = 0; i < n; i++) {
    int ans1 = abs(arr[i] - start);
    int ans2 = abs(end - arr[i]);
    maxi = min(ans1, ans2);
    if (maxi > temp) temp = maxi;
  }
  cout << temp << endl;
}
