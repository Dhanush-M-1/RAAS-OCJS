#include <bits/stdc++.h>
#pragma GCC optimize("Ofast,no-stack-protector,unroll-loops")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
void rev(string s) {
  for (int i = 0; i < s.size(); i++) {
    long long p = (s[i] - '0') % 10;
    cout << p;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long b;
  cin >> b;
  int v;
  for (long long i = 1; i < b; i++) {
    for (long long j = 1; j < b; j++) {
      long long c = i * j;
      long long i, a[10] = {0};
      for (i = 0; c != 0; i++) {
        long long k = c % b;
        a[i] = k;
        c = c / b;
      }
      for (int j = i - 1; j >= 0; j--) cout << a[j];
      cout << " ";
    }
    cout << '\n';
  }
  return 0;
}
