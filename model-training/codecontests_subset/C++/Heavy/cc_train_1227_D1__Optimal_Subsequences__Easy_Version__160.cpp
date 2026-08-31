#include <bits/stdc++.h>
using namespace std;
vector<vector<long long>> adj;
map<long, bool> vis, viss;
vector<long long> rnk, parent, sz;
int spf[1000000 + 1];
long long binpow(long long a, long long b, long long m) {
  a %= m;
  long long res = 1;
  while (b > 0) {
    if (b & 1) res = res * a % m;
    a = a * a % m;
    b >>= 1;
  }
  return res;
}
vector<long long> v;
bool yg(long long a, long long b) {
  return (v[a] > v[b] || ((v[a] == v[b]) && a < b));
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(nullptr);
  long long t, temp;
  long long n, m;
  cin >> n;
  vector<long long> indx;
  for (long long i = 0; i < n; i++) {
    cin >> temp;
    v.push_back(temp);
    indx.push_back(i);
  }
  sort(indx.begin(), indx.end(), yg);
  cin >> m;
  while (m--) {
    long long k, pos;
    cin >> k >> pos;
    vector<long long> arr;
    for (long long i = 0; i < k; i++) arr.push_back(indx[i]);
    sort(arr.begin(), arr.end());
    cout << v[arr[pos - 1]] << "\n";
  }
}
