#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int n;
  cin >> n;
  vector<long long int> a(n), v1(n);
  for (long long int i = 0; i < n; i++) cin >> a[i];
  v1 = a;
  sort(a.begin(), a.end(), greater<long long int>());
  long long int q;
  cin >> q;
  while (q--) {
    long long int k, p;
    cin >> k >> p;
    vector<long long int> v;
    long long int sum = 0;
    for (long long int i = 0; i < k; i++) sum += a[i];
    long long int l1 = 0;
    for (long long int i = 0; i < k; i++) {
      if (a[i] == a[k - 1]) l1++;
    }
    for (long long int i = 0; i < n; i++) {
      if (v1[i] >= a[k - 1]) v.push_back(v1[i]);
    }
    vector<long long int> v2, v3;
    for (long long int i = 0; i < v.size(); i++) {
      if (a[k - 1] == v[i] && l1 > 0)
        v3.push_back(v[i]), l1--;
      else if (v[i] > a[k - 1])
        v3.push_back(v[i]);
    }
    v2 = v3;
    cout << v2[p - 1] << endl;
    v.clear();
  }
}
