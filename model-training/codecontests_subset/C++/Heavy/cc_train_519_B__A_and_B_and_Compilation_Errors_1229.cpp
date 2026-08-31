#include <bits/stdc++.h>
using namespace std;
int main() {
  map<long, long> s1, s2, s3;
  long n, a[100005], b[100005], c[100005], x, first, second;
  cin >> n;
  for (long i = 0; i < n; i++) {
    cin >> a[i];
    s1[a[i]]++;
  }
  for (long i = 0; i < n - 1; i++) {
    cin >> b[i];
    s2[b[i]]++;
  }
  for (long i = 0; i < n - 1; i++) {
    cin >> c[i];
    s3[c[i]]++;
  }
  for (long i = 0; i < n; i++) {
    if (s1[a[i]] != s2[a[i]]) {
      first = a[i];
      break;
    }
  }
  for (long i = 0; i < n - 1; i++) {
    if (s2[b[i]] != s3[b[i]]) {
      second = b[i];
      break;
    }
  }
  cout << first << endl << second;
  return 0;
}
