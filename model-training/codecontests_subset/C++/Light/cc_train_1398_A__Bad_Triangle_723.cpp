#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  for (int i = 0; i < t; i++) {
    long long int n;
    cin >> n;
    long long int a[n];
    for (long long int j = 0; j < n; j++) {
      cin >> a[j];
    }
    if (a[0] + a[1] <= a[n - 1])
      cout << "1 2 " << n << endl;
    else
      cout << "-1" << endl;
  }
}
