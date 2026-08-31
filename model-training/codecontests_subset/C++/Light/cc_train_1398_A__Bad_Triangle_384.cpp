#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    long long int n;
    long long int ar[50009];
    cin >> n;
    for (int i = 1; i <= n; i++) {
      cin >> ar[i];
    }
    if ((ar[1] + ar[2]) > ar[n]) {
      cout << "-1" << endl;
    } else
      cout << "1"
           << " "
           << "2"
           << " " << n << endl;
  }
}
