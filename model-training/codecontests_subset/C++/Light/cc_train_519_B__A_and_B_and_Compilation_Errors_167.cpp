#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  while (cin >> n) {
    long long sum1 = 0;
    int a;
    for (int i = 0; i < n; i++) {
      scanf("%d", &a);
      sum1 += a;
    }
    long long sum2 = 0;
    for (int i = 0; i < n - 1; i++) {
      scanf("%d", &a);
      sum2 += a;
    }
    long long sum3 = 0;
    for (int i = 0; i < n - 2; i++) {
      scanf("%d", &a);
      sum3 += a;
    }
    cout << sum1 - sum2 << endl;
    cout << sum2 - sum3 << endl;
  }
  return 0;
}
