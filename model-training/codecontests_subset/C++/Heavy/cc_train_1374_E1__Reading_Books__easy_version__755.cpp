#include <bits/stdc++.h>
using namespace std;
void fast() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
int main() {
  long long int n, i, j, w, x, y, k, cv1 = 0, cv2 = 0, cv3 = 0, c = 0, ans = 0;
  cin >> n >> k;
  vector<long long int> v2, v1, v3;
  for (i = 0; i < n; i++) {
    cin >> w >> x >> y;
    if (x == 1 && y == 1) {
      cv3++;
      v3.push_back(w);
    } else if (x == 0 && y == 1) {
      v2.push_back(w);
      cv2++;
    } else if (x == 1 && y == 0) {
      v1.push_back(w);
      cv1++;
    }
  }
  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());
  sort(v3.begin(), v3.end());
  long long int i1 = 0, i3 = 0;
  while (c < k && (min(cv1, cv2) > 0 || cv3 > 0)) {
    if (min(cv1, cv2) == 0 && cv3 > 0) {
      ans += v3[i3];
      i3++;
      cv3--;
      c++;
    } else if (min(cv1, cv2) > 0 && cv3 == 0) {
      ans += v1[i1] + v2[i1];
      cv1--;
      cv2--;
      c++;
      i1++;
    } else if (min(cv1, cv2) == 0 && cv3 == 0) {
      break;
    } else if (v1[i1] + v2[i1] >= v3[i3]) {
      ans += v3[i3];
      i3++;
      c++;
      cv3--;
    } else {
      ans += v1[i1] + v2[i1];
      cv1--;
      cv2--;
      c++;
      i1++;
    }
  }
  if (c == k)
    cout << ans << endl;
  else
    cout << "-1" << endl;
  return 0;
}
