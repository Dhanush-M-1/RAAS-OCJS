#include <bits/stdc++.h>
using namespace std;
int main() {
  vector<long long int> vec1, vec2;
  vector<long long int>::iterator it;
  long long int n, a, sz, s1 = 0, s2 = 0, s3 = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    s1 += a;
  }
  n--;
  for (int i = 0; i < n; i++) {
    cin >> a;
    s2 += a;
  }
  n--;
  for (int i = 0; i < n; i++) {
    cin >> a;
    s3 += a;
  }
  cout << s1 - s2 << endl << s2 - s3;
  return 0;
}
