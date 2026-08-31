#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const long long N = 3e2 + 5;
int main() {
  ios_base::sync_with_stdio(false);
  long long n, k, one = 0, two = 0;
  cin >> n >> k;
  vector<long long> v1, v2, v3;
  for (int i = 0; i < n; i++) {
    long long x, y, z;
    cin >> x >> y >> z;
    if (y) one++;
    if (z) two++;
    if (y && z)
      v1.push_back(x);
    else if (y)
      v2.push_back(x);
    else if (z)
      v3.push_back(x);
  }
  if (one < k || two < k) {
    cout << -1 << endl;
    return 0;
  }
  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());
  sort(v3.begin(), v3.end());
  long long sum = 0, count1 = k, count2 = k, p = 0, q = 0, r = 0;
  int len1 = v1.size(), len2 = v2.size(), len3 = v3.size();
  while (count1 > 0 || count2 > 0) {
    if (q >= len2 || r >= len3) {
      sum += v1[p];
      p++;
      count1--;
      count2--;
    } else if (p < len1) {
      if (v1[p] <= (v2[q] + v3[r])) {
        sum += v1[p];
        p++;
        count1--;
        count2--;
      } else {
        sum += (v2[q] + v3[r]);
        q++;
        r++;
        count2--;
        count1--;
      }
    } else {
      sum += (v2[q] + v3[r]);
      q++;
      r++;
      count2--;
      count1--;
    }
  }
  cout << sum;
  return 0;
}
