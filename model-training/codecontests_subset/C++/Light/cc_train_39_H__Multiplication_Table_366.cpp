#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  for (long long i = 1; i < n; i++) {
    for (long long j = 1; j < n; j++) {
      long long nor_ans = i * j;
      if (nor_ans >= n) {
        long long rem_ans = nor_ans / n;
        long long ans = nor_ans - (rem_ans * n);
        cout << rem_ans << ans << " ";
      } else
        cout << nor_ans << " ";
    }
    cout << endl;
  }
}
