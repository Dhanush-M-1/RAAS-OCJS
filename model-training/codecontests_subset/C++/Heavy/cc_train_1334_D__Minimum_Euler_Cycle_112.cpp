#include <bits/stdc++.h>
using namespace std;
template <typename T>
T InvMod(T a, T b, T &x, T &y) {
  if (a == 0) {
    x = 0;
    y = 1;
    return b;
  }
  T x1, y1;
  T g = InvMod(b % a, a, x1, y1);
  x = y1 - (b / a) * x1;
  y = x1;
  return g;
}
long long fact(long long n) {
  if (n == 1) return 1;
  return (n % 1000000007 * fact(n - 1) % 1000000007) % 1000000007;
}
void sieve(vector<int> &v) {
  bool arr[1000004];
  memset(arr, true, sizeof arr);
  for (int i = 2; i * i <= 1000002; i++) {
    if (arr[i] == true) {
      v.push_back(i);
      for (int j = i * i; j <= 1000002; j += i) {
        arr[j] = false;
      }
    }
  }
}
bool cmp(pair<int, int> a, pair<int, int> b) { return a.first > b.first; }
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    int i = 1;
    long long tmp = l;
    for (long long j = l; j <= r; j++) {
      while (2 * (n - i) < tmp && i <= n) {
        tmp -= 2 * (n - i);
        i++;
      }
      if (i > n) {
        cout << 1 << " ";
        continue;
      }
      long long rem = tmp;
      if (rem % 2 == 1) {
        cout << i << " ";
      } else {
        cout << i + (rem / 2) << " ";
      }
      tmp++;
    }
    cout << endl;
  }
}
