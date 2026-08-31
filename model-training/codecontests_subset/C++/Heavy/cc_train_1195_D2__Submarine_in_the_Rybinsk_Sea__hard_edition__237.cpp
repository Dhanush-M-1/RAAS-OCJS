#include <bits/stdc++.h>
using namespace std;
void __print(int x) { cerr << x; }
void __print(long x) { cerr << x; }
void __print(long long x) { cerr << x; }
void __print(unsigned x) { cerr << x; }
void __print(unsigned long x) { cerr << x; }
void __print(unsigned long long x) { cerr << x; }
void __print(float x) { cerr << x; }
void __print(double x) { cerr << x; }
void __print(long double x) { cerr << x; }
void __print(char x) { cerr << '\'' << x << '\''; }
void __print(const char *x) { cerr << '\"' << x << '\"'; }
void __print(const string &x) { cerr << '\"' << x << '\"'; }
void __print(bool x) { cerr << (x ? "true" : "false"); }
template <typename T, typename V>
void __print(const pair<T, V> &x) {
  cerr << '{';
  __print(x.first);
  cerr << ',';
  __print(x.second);
  cerr << '}';
}
template <typename T>
void __print(const T &x) {
  int first = 0;
  cerr << '{';
  for (auto &i : x) cerr << (first++ ? "," : ""), __print(i);
  cerr << "}";
}
void _print() { cerr << "]\n"; }
template <typename T, typename... V>
void _print(T t, V... v) {
  __print(t);
  if (sizeof...(v)) cerr << ", ";
  _print(v...);
}
const int mod = 998244353;
void test_case() {
  int a;
  cin >> a;
  vector<int> t(a);
  vector<long long> digits(11);
  for (int i = 0; i < a; i++) {
    cin >> t[i];
    int k = 0, tmp = t[i];
    while (tmp) {
      k++, tmp /= 10;
    }
    digits[k]++;
  }
  long long ans = 0;
  vector<long long> tens(30, 1);
  for (int i = 1; i < 30; i++) {
    tens[i] = tens[i - 1] * 10 % mod;
  }
  for (int i = 0; i < a; i++) {
    for (int j = 1; j < 11; j++) {
      int k1 = 1, k2 = 0, o1 = 1, o2 = 0, tmp = t[i];
      while (tmp) {
        long long digit = tmp % 10;
        ans += ((tens[k1] + tens[k2]) * digit % mod) * digits[j] % mod,
            ans %= mod;
        k1 += o1++ < j ? 2 : 1, k2 += o2++ < j ? 2 : 1, tmp /= 10;
      }
    }
  }
  cout << ans;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t = 1;
  for (int i = 1; i <= t; i++) {
    test_case();
  }
}
