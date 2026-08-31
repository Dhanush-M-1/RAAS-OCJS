#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, c, a;
  cin >> n >> c;
  vector<int> arr;
  for (int i = 0; i < n; i++) {
    cin >> a;
    arr.push_back(a);
  }
  int maxx = 0;
  for (int i = 0; i < n - 1; i++) {
    maxx = max(maxx, arr[i] - arr[i + 1] - c);
  }
  cout << maxx;
  return 0;
}
