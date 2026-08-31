#include <bits/stdc++.h>
using namespace std;
void printarr(int arr[], int n) {
  for (int i = 0; i < n; i++) {
    cout << arr[i] << " ";
  }
  cout << endl;
}
void printarr(vector<int> arr) {
  int n = arr.size();
  for (int i = 0; i < n; i++) {
    cout << arr[i] << " ";
  }
  cout << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long test, ti, n, i;
  cin >> n;
  long long x[n], h[n], g[n + 1];
  g[0] = INT_MAX;
  g[n] = INT_MAX;
  for (int i = 0; i < (n); i++) cin >> x[i] >> h[i];
  for (int i = (1); i < (n); i++) g[i] = x[i] - x[i - 1];
  long long cnt = 0;
  for (int i = 0; i < (n); i++) {
    if (h[i] < g[i])
      cnt++;
    else if (h[i] < g[i + 1]) {
      cnt++;
      g[i + 1] -= h[i];
    }
  }
  cout << cnt << "\n";
  return 0;
}
