#include <bits/stdc++.h>
using namespace std;
map<long long int, long long int> cnt;
map<long long int, long long int> cnt2;
map<long long int, long long int> cnt3;
long long int num[100010];
long long int num2[100010];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  long long int n, i, j, k, x, y, p;
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> num[i];
    cnt[num[i]]++;
  }
  for (i = 1; i <= n - 1; i++) {
    cin >> num2[i];
    cnt2[num2[i]]++;
  }
  for (i = 1; i <= n; i++) {
    if (cnt[num[i]] != cnt2[num[i]]) {
      x = num[i];
      break;
    }
  }
  for (i = 1; i <= n - 2; i++) {
    cin >> p;
    cnt3[p]++;
  }
  for (i = 1; i <= n - 1; i++) {
    if (cnt2[num2[i]] != cnt3[num2[i]]) {
      y = num2[i];
      break;
    }
  }
  cout << x << endl << y;
  return 0;
}
