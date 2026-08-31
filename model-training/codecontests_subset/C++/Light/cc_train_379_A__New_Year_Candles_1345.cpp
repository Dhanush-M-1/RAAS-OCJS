#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int drunk = 0;
  long long int n, k, temp1, butt;
  cin >> n >> k;
  drunk = n;
  butt = n;
  while (butt >= k) {
    temp1 = butt / k;
    drunk += temp1;
    butt = (butt % k) + temp1;
  }
  cout << drunk << endl;
  return 0;
}
