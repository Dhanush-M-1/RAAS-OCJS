#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int sum1 = 0, sum2 = 0, sum3 = 0, n1, n2, n3;
  cin >> n1;
  n2 = n1 - 1;
  n3 = n2 - 1;
  int temp;
  while (n1--) {
    cin >> temp;
    sum1 += temp;
  }
  while (n2--) {
    cin >> temp;
    sum2 += temp;
  }
  while (n3--) {
    cin >> temp;
    sum3 += temp;
  }
  cout << sum1 - sum2 << "\n" << sum2 - sum3;
  int do_not_hack;
  return 0;
}
