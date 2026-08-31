#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, m, j = 0, i;
  long long arr[100000];
  cin >> n;
  m = n;
  for (i = 2; i * i <= n; i++) {
    while (n % i == 0) {
      n /= i;
      arr[j++] = i;
    }
  }
  if (n != m && n > 1) arr[j++] = n;
  if (j == 2)
    cout << "2\n";
  else
    cout << "1\n" << arr[0] * arr[1] << endl;
  ;
}
