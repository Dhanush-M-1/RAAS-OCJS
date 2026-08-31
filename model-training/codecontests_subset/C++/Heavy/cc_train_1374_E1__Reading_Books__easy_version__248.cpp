#include <bits/stdc++.h>
using namespace std;
template <typename T>
void print1d(vector<T> &a) {
  for (long long int i = 0; i < a.size(); i++) {
    cout << a[i] << " ";
  }
  cout << endl;
}
vector<long long int> divisor(long long int n) {
  vector<long long int> a;
  for (long long int i = 1; i * i <= n; i++) {
    if (n % i == 0) {
      if (n / i == i)
        a.push_back(i);
      else {
        a.push_back(i);
        a.push_back(n / i);
      }
    }
  }
  return a;
}
long long int K = 1E9;
bool sortsecond(const pair<long long int, long long int> &a,
                const pair<long long int, long long int> &b) {
  return a.second < b.second;
}
bool sortmake(const pair<long long int, long long int> &a,
              const pair<long long int, long long int> &b) {
  if (a.first < b.first)
    return true;
  else if (a.first > b.first)
    return false;
  else {
    if (a.second < b.second)
      return false;
    else
      return true;
  }
}
bool isPrime(long long int n) {
  for (long long int i = 2; i * i <= n; i++) {
    if (n % i == 0) return false;
  }
  return true;
}
int32_t main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  ;
  long long int n, k;
  cin >> n >> k;
  vector<long long int> a, b, c;
  long long int x, y, z;
  for (long long int i = 0; i < n; i++) {
    cin >> x >> y >> z;
    if (y == 1 && z == 1)
      a.push_back(x);
    else if (y == 1)
      b.push_back(x);
    else if (z == 1)
      c.push_back(x);
  }
  long long int an = a.size();
  long long int bn = b.size();
  long long int cn = c.size();
  if (an + min(bn, cn) < k) {
    cout << -1 << endl;
    return 0;
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  long long int dn = min(bn, cn);
  long long int ans = 0;
  long long int i = 0, j = 0;
  for (long long int q = 0; q < k; q++) {
    if (i < an && j < dn) {
      if (a[i] <= b[j] + c[j]) {
        ans += a[i];
        i++;
      } else {
        ans += b[j] + c[j];
        j++;
      }
    } else if (i >= an) {
      ans += b[j] + c[j];
      j++;
    } else if (j >= dn) {
      ans += a[i];
      i++;
    }
  }
  cout << ans << endl;
  return 0;
}
