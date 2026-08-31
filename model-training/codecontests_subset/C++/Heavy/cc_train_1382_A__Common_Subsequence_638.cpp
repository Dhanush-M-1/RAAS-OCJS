#include <bits/stdc++.h>
using namespace std;
void printarray(long long arr[], long long n) {
  for (long long i = 0; i < n; i++) {
    cout << arr[i] << " ";
  }
  cout << endl;
  return;
}
void printvector(vector<long long> v) {
  for (long long i = 0; i < v.size(); i++) {
    cout << v[i] << " ";
  }
  cout << endl;
  return;
}
void help() {
  long long n, m;
  cin >> n >> m;
  long long a[n], b[m];
  for (long long i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (long long j = 0; j < m; j++) {
    cin >> b[j];
  }
  set<long long> s;
  for (long long i = 0; i < n; i++) {
    s.insert(a[i]);
  }
  for (long long i = 0; i < m; i++) {
    if (s.find(b[i]) != s.end()) {
      cout << "YES" << endl;
      cout << "1 " << b[i] << endl;
      return;
    }
  }
  cout << "NO" << endl;
}
int32_t main() {
  ios_base::sync_with_stdio(NULL);
  cin.tie(0);
  long long t;
  cin >> t;
  while (t--) {
    help();
  }
  return 0;
}
