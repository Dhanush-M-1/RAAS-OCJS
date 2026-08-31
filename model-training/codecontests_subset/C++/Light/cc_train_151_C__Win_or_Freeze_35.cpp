#include <bits/stdc++.h>
using namespace std;
int dcmp(double a, double b) {
  return fabs(a - b) <= 0.0000000001 ? 0 : (a > b) ? 1 : -1;
}
vector<long long> v;
void primefact(long long n) {
  long long sq = sqrt(n);
  for (long long i = 2; i <= sq; i++) {
    while (n % i == 0) {
      v.push_back(i);
      n /= i;
    }
  }
  if (n > 1) v.push_back(n);
}
int main() {
  long long q;
  cin >> q;
  primefact(q);
  if (((int)(v).size()) <= 1)
    cout << "1\n0";
  else if (((int)(v).size()) == 2)
    cout << "2\n";
  else
    cout << "1\n" << v[0] * v[1];
}
