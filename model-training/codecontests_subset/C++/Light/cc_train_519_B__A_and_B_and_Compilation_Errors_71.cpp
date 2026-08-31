#include <bits/stdc++.h>
using namespace std;
int main(int argc, char** argv) {
  int n;
  cin >> n;
  long long sum = 0;
  long long x = 0;
  for (int i = 0; i < n; i++) {
    cin >> x;
    sum += x;
  }
  long long sum2 = 0;
  for (int i = 0; i < n - 1; i++) {
    cin >> x;
    sum2 += x;
  }
  cout << sum - sum2 << '\n';
  sum = sum2;
  sum2 = 0;
  for (int i = 0; i < n - 2; i++) {
    cin >> x;
    sum2 += x;
  }
  cout << sum - sum2 << '\n';
  return 0;
}
