#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  vector<long long> v(2000000);
  for (long long i = 0; i < 2000000; i++) v[i] = 0;
  for (long long i = 0; i < n; i++) {
    long long t1;
    cin >> t1;
    v[t1]++;
  }
  long long t = 0;
  long long l = 1;
  long long r = 1000000;
  while (n > 0) {
    t++;
    l++;
    r--;
    if (v[l]) n--;
    if (v[r]) n--;
  }
  cout << t;
}
