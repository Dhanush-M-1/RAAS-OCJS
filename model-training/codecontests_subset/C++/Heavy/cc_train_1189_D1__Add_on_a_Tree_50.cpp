#include <bits/stdc++.h>
using namespace std;
vector<long long> vin(long long n) {
  vector<long long> a(n);
  for (long long i = 0; i < n; i += 1) cin >> a[i];
  return a;
}
long long intin() {
  long long n;
  cin >> n;
  return n;
}
char charin() {
  char a;
  cin >> a;
  return a;
}
string strin() {
  string s;
  cin >> s;
  return s;
}
long long factorial(long long n) {
  return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n, u, v;
  cin >> n;
  vector<long long> counter(n + 1, 0);
  for (long long i = 0; i < n - 1; i += 1) {
    cin >> u >> v;
    counter[u]++;
    counter[v]++;
  }
  for (auto i : counter) {
    if (i == 2) {
      cout << "NO\n";
      return 0;
    }
  }
  cout << "YES\n";
  return 0;
}
