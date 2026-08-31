#include <bits/stdc++.h>
const long long int mod = 1e9 + 7;
using namespace std;
bool prime(long long int n) {
  if (n <= 1) return false;
  if (n <= 3) return true;
  if (n % 2 == 0 || n % 3 == 0) return false;
  for (long long int i = 5; i * i <= n; i = i + 6)
    if (n % i == 0 || n % (i + 2) == 0) return false;
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  string s1, s2;
  cin >> s1 >> s2;
  map<string, long long int> v;
  v[s1]++;
  v[s2]++;
  long long int n;
  cin >> n;
  while (n--) {
    for (auto x : v) {
      if (x.second) cout << x.first << " ";
    }
    string s3, s4;
    cin >> s3 >> s4;
    if (v[s3]) {
      v[s3] = 0;
    } else
      v[s3]++;
    if (v[s4])
      v[s4] = 0;
    else
      v[s4]++;
    cout << '\n';
  }
  for (auto x : v) {
    if (x.second) cout << x.first << " ";
  }
  return 0;
}
