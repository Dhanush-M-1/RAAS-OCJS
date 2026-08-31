#include <bits/stdc++.h>
using namespace std;
void test() {
  long long n;
  cin >> n;
  vector<long long> v;
  for (long long i = 0; i < n; i++) {
    long long num;
    cin >> num;
    v.push_back(num);
  }
  if (v[0] + v[1] <= v[n - 1]) {
    cout << 1 << " " << 2 << " " << n << endl;
  } else {
    cout << -1 << endl;
  }
}
int main() {
  long long t;
  cin >> t;
  while (t--) {
    test();
  }
}
