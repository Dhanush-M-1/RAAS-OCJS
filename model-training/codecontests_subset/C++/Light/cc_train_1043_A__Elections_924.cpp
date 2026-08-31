#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, num, ma = 0, sum1 = 0, sum2 = 0;
  vector<long long> v;
  cin >> n;
  for (long long i = 0; i < n; i++) {
    cin >> num;
    ma = max(ma, num);
    v.push_back(num);
    sum2 += num;
  }
  for (long long i = 0; i < n; i++) {
    sum1 += ma - v[i];
  }
  while (sum1 <= sum2) {
    sum1 += n;
    ma++;
  }
  cout << ma;
}
