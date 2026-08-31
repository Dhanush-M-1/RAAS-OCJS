#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e9;
const long long mod = 1e9 + 7;
const double eps = 1e-8;
const long long MAX = 1e7 + 20;
template <class T>
T gcd(T a, T b) {
  return (b != 0 ? gcd<T>(b, a % b) : a);
}
template <class T>
T lcm(T a, T b) {
  return (a / gcd<T>(a, b) * b);
}
const int N = 200200;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long a, b, c, d;
  cin >> a >> b;
  vector<long long> v;
  for (int i = 0; i < a; i++) {
    cin >> c;
    v.push_back(c);
  }
  vector<long long> v1;
  for (int i = 0; i < a - 1; i++) {
    if (v[i] >= v[i + 1]) {
      v1.push_back(v[i] - v[i + 1] - b);
    }
  }
  sort(v1.begin(), v1.end());
  if (v1.size() == 0 || v1[v1.size() - 1] < 0) {
    cout << 0 << endl;
    return 0;
  }
  cout << v1[v1.size() - 1] << endl;
}
