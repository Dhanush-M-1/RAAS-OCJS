#include <bits/stdc++.h>
using namespace std;
int main(void) {
  long long int n, ar[100000], err_1 = 0, err_2 = 0, err_3 = 0, i;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> ar[i];
    err_1 = err_1 + ar[i];
  }
  for (i = 0; i < n - 1; i++) {
    cin >> ar[i];
    err_2 = err_2 + ar[i];
  }
  for (i = 0; i < n - 2; i++) {
    cin >> ar[i];
    err_3 = err_3 + ar[i];
  }
  cout << err_1 - err_2 << endl;
  cout << err_2 - err_3 << endl;
}
