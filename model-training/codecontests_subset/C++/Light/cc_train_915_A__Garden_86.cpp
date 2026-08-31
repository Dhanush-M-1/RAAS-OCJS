#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int n, k;
  vector<long long int> v;
  cin >> n >> k;
  long long int x;
  while (n--) {
    cin >> x;
    v.push_back(x);
  }
  sort(v.begin(), v.end(), greater<int>());
  for (long long int i = 0; i < v.size(); i++) {
    if (k % v[i] == 0) {
      cout << k / v[i];
      break;
    }
  }
  return 0;
}
