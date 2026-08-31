#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t;
  cin >> t;
  for (long long p = 1; p <= t; p++) {
    long long n, m;
    cin >> n >> m;
    bool arr[1001];
    memset(arr, false, sizeof(arr));
    for (long long i = 1; i <= n; i++) {
      long long angka;
      cin >> angka;
      arr[angka] = true;
    }
    bool jawaban = false;
    long long containa = 0;
    for (long long i = 1; i <= m; i++) {
      long long angka;
      cin >> angka;
      if (arr[angka]) {
        jawaban = true;
        containa = angka;
      }
    }
    if (jawaban) {
      cout << "YES\n";
      cout << "1 " << containa << "\n";
    } else {
      cout << "NO\n";
    }
  }
  return 0;
}
