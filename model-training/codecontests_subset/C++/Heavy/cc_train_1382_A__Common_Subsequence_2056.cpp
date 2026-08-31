#include <bits/stdc++.h>
using namespace std;
template <typename T>
void input(vector<T> &arr, long long int n) {
  T temp;
  for (long long int i = 0; i < n; i++) cin >> temp, arr.push_back(temp);
}
template <typename T>
void output(vector<T> arr) {
  T temp;
  for (auto x : arr) cout << x << " ";
  cout << endl;
}
template <typename T>
void input_set(set<T> &arr, long long int n) {
  T temp;
  for (long long int i = 0; i < n; i++) cin >> temp, arr.insert(temp);
}
long long int power(long long int num, long long int base) {
  if (base == 0) return 1;
  if (base % 2)
    return (num % 1000000007 * power(num, base - 1) % 1000000007) % 1000000007;
  else {
    long long int x = power(num, base / 2);
    x = (x * x) % 1000000007;
    return x;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int testcases;
  cin >> testcases;
  while (testcases--) {
    long long int n, m, k, i, ans = -1;
    cin >> n >> m;
    map<long long int, long long int> m1;
    for (i = 0; i < n; i++) {
      cin >> k;
      m1[k]++;
    }
    for (i = 0; i < m; i++) {
      cin >> k;
      if (m1[k] && ans == -1) ans = k;
    }
    if (ans == -1)
      cout << "NO" << endl;
    else
      cout << "YES" << endl << 1 << " " << ans << endl;
  }
}
