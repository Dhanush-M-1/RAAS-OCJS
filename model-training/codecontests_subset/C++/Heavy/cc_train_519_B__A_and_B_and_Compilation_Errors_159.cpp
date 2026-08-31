#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, arr[2];
  cin >> n;
  vector<long long> a;
  vector<long long> b;
  vector<long long> c;
  for (long long i = 0; i < n; i++) {
    long long v;
    cin >> v;
    a.push_back(v);
  }
  sort(a.begin(), a.end());
  for (long long i = 0; i < n - 1; i++) {
    long long v;
    cin >> v;
    b.push_back(v);
  }
  sort(b.begin(), b.end());
  for (long long i = 0; i < n - 2; i++) {
    long long v;
    cin >> v;
    c.push_back(v);
  }
  sort(c.begin(), c.end());
  for (long long i = 0; i < a.size(); i++) {
    if (a[i] != b[i]) {
      arr[0] = a[i];
      break;
    }
  }
  for (long long i = 0; i < b.size(); i++) {
    if (b[i] != c[i]) {
      arr[1] = b[i];
      break;
    }
  }
  cout << arr[0] << endl << arr[1] << endl;
  return 0;
}
