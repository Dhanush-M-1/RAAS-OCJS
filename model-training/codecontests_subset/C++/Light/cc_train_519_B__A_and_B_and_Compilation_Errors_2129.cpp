#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n;
  cin >> n;
  long long a = 0, b = 0, c = 0;
  int cnt = 0;
  vector<long long> ar(n), ar1(n - 1), ar2(n - 2);
  for (int i = 0; i < n; i++) {
    cin >> ar[i];
    a += ar[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> ar1[i];
    b += ar1[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> ar2[i];
    c += ar2[i];
  }
  cout << a - b << endl << b - c << endl;
}
