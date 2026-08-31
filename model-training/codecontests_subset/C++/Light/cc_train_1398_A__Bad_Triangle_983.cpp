#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[]) {
  int t;
  int n;
  vector<int> Arr;
  cin >> t;
  while (t--) {
    cin >> n;
    Arr.resize(n);
    for (int i = 0; i < n; i++) cin >> Arr[i];
    if (Arr[n - 1] >= Arr[0] + Arr[1]) {
      cout << 1 << " " << 2 << " " << n << endl;
    } else
      cout << -1 << endl;
  }
  return 0;
}
