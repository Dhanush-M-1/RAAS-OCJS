#include <bits/stdc++.h>
using namespace std;
using namespace std;
using namespace std;
signed main() {
  long long n;
  cin >> n;
  vector<long long> v1(n);
  vector<long long> v2(n);
  for (long long i = 0; i < (long long)(n); ++i) {
    cin >> v1[i] >> v2[i];
  }
  long long c = 0;
  for (long long i = 0; i < (long long)(n); ++i) {
    for (long long j = 0; j < (long long)(n); ++j) {
      if (v1[i] == v2[j]) c++;
    }
  }
  cout << c << "\n";
}
