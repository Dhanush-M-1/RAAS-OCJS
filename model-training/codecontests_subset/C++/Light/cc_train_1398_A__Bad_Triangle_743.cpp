#include <bits/stdc++.h>
using namespace std;
long long n, a[100005], T, c;
int main() {
  cin >> T;
  for (long long j = 1; j <= T; j++) {
    cin >> n;
    long long op;
    for (long long i = 1; i <= n; i++) {
      cin >> a[i];
    }
    if (a[n] >= a[1] + a[2])
      cout << "1 2 " << n << endl;
    else
      cout << "-1\n";
  }
  return 0;
}
