#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int initial[n];
  int first[n - 1];
  int second[n - 2];
  int sum1 = 0, sum2 = 0, sum3 = 0;
  for (int i = 0; i < n; i++) {
    cin >> initial[i];
    sum1 += initial[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> first[i];
    sum2 += first[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> second[i];
    sum3 += second[i];
  }
  cout << (sum1 - sum2) << endl;
  cout << (sum2 - sum3) << endl;
  return 0;
}
