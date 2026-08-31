#include <bits/stdc++.h>
using namespace std;
pair<long long int, long long int> mult(pair<long long int, long long int> x,
                                        pair<long long int, long long int> y) {
  return pair<long long int, long long int>(
      x.first * y.first - x.second * y.second,
      x.first * y.second + x.second * y.first);
}
pair<long long int, long long int> sub(pair<long long int, long long int> x,
                                       pair<long long int, long long int> y) {
  return pair<long long int, long long int>(x.first - y.first,
                                            x.second - y.second);
}
pair<long long int, long long int> conj(pair<long long int, long long int> x) {
  return pair<long long int, long long int>(x.first, -x.second);
}
long long int lenSqr(pair<long long int, long long int> x) {
  return x.first * x.first + x.second * x.second;
}
int main() {
  ios_base::sync_with_stdio(0);
  pair<long long int, long long int> A, B, C;
  cin >> A.first >> A.second >> B.first >> B.second >> C.first >> C.second;
  pair<long long int, long long int> iK(1, 0);
  bool good = false;
  for (int i = (0); i <= (3); ++i) {
    if (mult(A, iK) == B) good = true;
    pair<long long int, long long int> R = sub(B, mult(A, iK));
    R = mult(R, conj(C));
    long long int d = lenSqr(C);
    if (d && R.first % d == 0 && R.second % d == 0) good = true;
    iK = mult(iK, pair<long long int, long long int>(0, 1));
  }
  if (good)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
