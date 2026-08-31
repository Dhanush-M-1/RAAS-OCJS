#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  int arr[n], max = 0, sum = 0;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    max = fmax(arr[i], max);
    sum += arr[i];
  }
  sum *= 2;
  sum++;
  int rem = n - sum % n;
  if (sum % n != 0) sum += rem;
  sum /= n;
  cout << fmax(sum, max) << '\n';
}
