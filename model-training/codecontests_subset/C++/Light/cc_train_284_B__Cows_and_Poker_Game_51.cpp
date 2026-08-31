#include <bits/stdc++.h>
using namespace std;
long long int a[200005], b[200005];
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  long long int n, count = 0, count1 = 0;
  cin >> n;
  char c[200005];
  for (long long int i = 0; i < n; i++) {
    cin >> c[i];
    if (c[i] == 'I')
      count++;
    else if (c[i] == 'A')
      count1++;
  }
  cout << (count ? (count == 1 ? 1 : 0) : count1);
}
