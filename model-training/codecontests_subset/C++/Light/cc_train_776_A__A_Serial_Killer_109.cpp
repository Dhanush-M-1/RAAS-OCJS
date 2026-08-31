#include <bits/stdc++.h>
using namespace std;
int main() {
  unsigned long long n, i, j;
  string s1, s2;
  cin >> s1 >> s2;
  scanf("%lld", &n);
  string s3[n], s4[n];
  for (i = 0; i < n; i++) {
    cin >> s3[i] >> s4[i];
  }
  string tm1, tm2;
  tm1 = s1;
  tm2 = s2;
  for (i = 0; i < n; i++) {
    cout << tm1 << " " << tm2 << endl;
    if (s3[i] == tm1) {
      tm1 = s4[i];
    } else if (s3[i] == tm2) {
      tm2 = s4[i];
    }
  }
  cout << tm1 << " " << tm2;
  return 0;
}
