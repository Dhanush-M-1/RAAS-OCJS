#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1);
const long long INF = 1LL << 62;
const long long MINF = -(1LL << 62);
template <typename T>
T getint() {
  T val = 0;
  char c;
  bool neg = false;
  while ((c = getchar()) && !(c >= '0' && c <= '9')) {
    neg |= c == '-';
  }
  do {
    val = (val * 10) + c - '0';
  } while ((c = getchar()) && (c >= '0' && c <= '9'));
  return val * (neg ? -1 : 1);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int T;
  cin >> T;
  while (T--) {
    int n;
    cin >> n;
    vector<int> t(n);
    for (int i = 0; i < n; ++i) cin >> t[i];
    if (t[0] + t[1] > t[n - 1]) {
      cout << "-1\n";
    } else {
      cout << "1 2 " << n << "\n";
    }
  }
  return 0;
}
